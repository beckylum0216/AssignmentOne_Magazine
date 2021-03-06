/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.DAYS;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author becky
 */

/**
* <p> This is the service manager. Contains the business logic of the application</p>
* @since 1.0
*/
public class ServiceManager {
    
    private MagazineManager magazineList;
    private CustomerManager customerList;
    // email, magazine name, subscription
    private HashMap<String, HashMap<String, Subscription>> subscriptionList;
    //customer--> invoicekey-->invoice
    private HashMap<String, HashMap<String, Invoice>> billedInvoice;
    private HashMap<String, HashMap<String, Email>> generatedEmails;
    
    /**
    * <p> This is the service manager constructor</p>
    * @since 1.0
    */
    public ServiceManager()
    {
        this.billedInvoice = new HashMap<>();
        this.generatedEmails = new HashMap<>();
        this.subscriptionList = new HashMap<>();
        this.customerList = new CustomerManager();
        this.magazineList = new MagazineManager();
    }
    
    /**
    * <p> This is the accessor for the customer list</p>
    * @return magazines magazine lists
    * @since 1.0
    */
    public CustomerManager GetCustomerList()
    {
        return customerList;
    }
    
    /**
    * <p> This is the accessor for the magazine list</p>
    * @return magazines magazine lists
    * @since 1.0
    */
    public MagazineManager GetMagazineList()
    {
        return magazineList;
    }
    
    /**
    * <p> This function contains the logic for the invoicing customers</p> 
    * @since 1.0
    */
    public void InvoiceCustomers()
    {
        LocalDate currentDate = LocalDate.now();
        
        // Iterate through patrons
        for(Map.Entry pair: this.customerList.GetPatron().entrySet())
        {
            
            Customer currentCustomer = (Customer) pair.getValue();
            HashMap<String, Subscription> customerSubscription;
            customerSubscription = subscriptionList.get(currentCustomer.GetEmailAddress());
            
            // get subscription information
            for(Map.Entry magazinePair: customerSubscription.entrySet())
            {
                
                Subscription currentSubs = (Subscription) magazinePair.getValue();
                // select dates for every monday following the subscription date
                ArrayList<LocalDate> invoiceDates = GetInvoiceDates(currentDate, currentSubs);
                
                // invoicing the customer for every monday following the subscription date
                for(int ii = 0; ii < invoiceDates.size(); ii += 1)
                {
                    
                    Datum invoiceDate = new Datum(invoiceDates.get(ii).getDayOfMonth(), invoiceDates.get(ii).getMonthValue(), invoiceDates.get(ii).getYear());
                    //System.out.println("invoiceDate: "+ invoiceDate.toString());
                    String invoiceKey = currentCustomer.GetEmailAddress()
                            +currentSubs.GetSubbedPublication().GetMagazineName()
                            + invoiceDate.toString();
                    Invoice currentInvoice = new Invoice(invoiceKey, currentCustomer.GetEmailAddress(), currentCustomer,customerSubscription, invoiceDate);

                    if(billedInvoice.containsKey(currentCustomer.GetEmailAddress()))
                    {
                        if(billedInvoice.get(currentCustomer.GetEmailAddress()).containsKey(invoiceKey))
                        {
                            throw new IllegalArgumentException("Invoice Exists");
                        }
                        else
                        {
                            billedInvoice.get(currentCustomer.GetEmailAddress()).put(invoiceKey, currentInvoice);
                        }
                    }
                    else
                    {
                        HashMap<String, Invoice> tempMap = new HashMap<>();
                        tempMap.put(invoiceKey, currentInvoice);
                        billedInvoice.put(currentCustomer.GetEmailAddress(), tempMap);
                    }
                }

                
            }
            
            // invoicing the associates
            if(this.customerList.GetAssociates().containsKey(currentCustomer.GetEmailAddress()))
            {
                
                HashMap<String, Associate> associateMap = this.customerList.GetAssociates().get(currentCustomer.GetEmailAddress());
                // iterating all the associates relating to the patron
                for(Map.Entry associatePair: associateMap.entrySet())
                {
                    Customer associateCustomer = (Customer) associatePair.getValue();
                    
                    HashMap<String, Subscription> associateSubscriptions;
                    associateSubscriptions = subscriptionList.get(associateCustomer.GetEmailAddress());
                    // iterating though the associates subscriptions
                    for(Map.Entry associateSubsPair : associateSubscriptions.entrySet())
                    {
                        Subscription associateSubscription = (Subscription) associateSubsPair.getValue();
                        // getting all the mondays following the subscription date
                        ArrayList<LocalDate> invoiceAssociateDates = this.GetInvoiceDates(currentDate, associateSubscription);
                        // invoicing the patron customer
                        for(int ii = 0; ii < invoiceAssociateDates.size(); ii += 1)
                        {
                            
                            Datum invoiceAssociateDate = new Datum(invoiceAssociateDates.get(ii).getDayOfMonth(), invoiceAssociateDates.get(ii).getMonthValue(), invoiceAssociateDates.get(ii).getYear());
                            String invoiceAssociateKey = associateCustomer.GetEmailAddress() 
                                    + associateSubscription.GetSubbedPublication().GetMagazineName()
                                    + invoiceAssociateDate.toString();
                            Invoice associateInvoice = new Invoice(invoiceAssociateKey, 
                                                                    associateCustomer.GetEmailAddress(), 
                                                                    associateCustomer, 
                                                                    associateSubscriptions, 
                                                                    invoiceAssociateDate);

                            if(billedInvoice.containsKey(currentCustomer.GetEmailAddress()))
                            {
                                if(billedInvoice.get(currentCustomer.GetEmailAddress()).containsKey(invoiceAssociateKey))
                                {
                                    throw new IllegalArgumentException("Invoice Exists");
                                }
                                else
                                {
                                    billedInvoice.get(currentCustomer.GetEmailAddress()).put(invoiceAssociateKey, associateInvoice);
                                }
                            }
                            else
                            {
                                HashMap<String, Invoice> tempMap = new HashMap<>();
                                tempMap.put(invoiceAssociateKey, associateInvoice);
                                billedInvoice.put(currentCustomer.GetEmailAddress(), tempMap);
                            }
                        }
                    }
                }
                    
            }
            else
            {
                System.out.println("No associate customer linked to patron.");
                //throw new IllegalArgumentException("No associate customer linked to patron.");
            }
        }
    }
    
    /**
    * <p> This function gets all the monday invoice dates related to each subscription</p>
    * @param currentDate current system date
    * @return currentSubs the subscriptions related to the customers
    * @see 
    * @since 1.0
    */
    private ArrayList<LocalDate> GetInvoiceDates(LocalDate currentDate, Subscription currentSubs)
    {
        ArrayList<LocalDate> invoiceDates = new ArrayList<>();
       
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate endDate = LocalDate.parse(currentDate.toString(), formatter);
        LocalDate startDate = LocalDate.of(currentSubs.GetSubscriptionDate().getYear(), currentSubs.GetSubscriptionDate().getMonth(), currentSubs.GetSubscriptionDate().getDay());
        long rangeDate = ChronoUnit.DAYS.between(startDate, endDate);
        
        LocalDate getMondays = startDate;
        for(int ii = 0; ii < rangeDate; ii += 1)
        {
            
            if(getMondays.getDayOfWeek().getValue() == 1)
            {
                invoiceDates.add(getMondays);

            }
            getMondays = getMondays.plusDays(1);
            
        }

        return invoiceDates;
    }
    
    /**
    * <p> This is the accessor to billed invoices </p>
    * @return billedInvoice billed invoice list
    * @since 1.0
    */
    public HashMap<String, HashMap<String,Invoice>> GetBilledInvoices()
    {
        return this.billedInvoice;
    }
    
    /**
    * <p> This function collates and print all the invoices in a statement </p>
    * @since 1.0
    */
    public void PrintStatements()
    {
        LocalDateTime currentDate = LocalDateTime.now();
        for(Map.Entry pair: this.billedInvoice.entrySet())
        {
            String customerKey = (String)pair.getKey();
            System.out.println("customerKey" + customerKey);
            String patronFirstName = customerList.patron.get(customerKey).GetFirstName();
            String patronLastName = customerList.patron.get(customerKey).GetLastName();
            
            System.out.println("Statement for Period: " + currentDate.getYear() + " " + currentDate.getMonth());
            System.out.println();
            System.out.println("Customer Name:" + patronFirstName + " " + patronLastName);
            
            HashMap <String, Invoice> customerMap = (HashMap<String, Invoice>) pair.getValue();
            float totalStatement = 0;
            for(Map.Entry customerPair: customerMap.entrySet())
            {
                
                String invoiceKey = (String)customerPair.getKey();
                
                String currentPeriod = currentDate.getYear() + "" +currentDate.getMonthValue();
                String periodInvoice = billedInvoice.get(customerKey).get(invoiceKey).GetInvoiceDate().getYear() + ""
                                        +billedInvoice.get(customerKey).get(invoiceKey).GetInvoiceDate().getMonth();
                
                // only prints invoices for the current month
                if(currentPeriod.equals(periodInvoice))
                {
                    billedInvoice.get(customerKey).get(invoiceKey).PrintInvoice();
                    totalStatement += billedInvoice.get(customerKey).get(invoiceKey).GetTotalInvoice();
                }
            }
            
            System.out.println("Statement Total: " + totalStatement);
            System.out.println();
            
        } 
        
    }
    
   
    /**
    * <p> This is the mutator to the subscription list  </p>
    * @param newSubscription subscription record 
    * @since 1.0
    */
    public void AddSubscription(Subscription newSubscription )
    {
        // testing if patron exists
        if(customerList.CustomerList().containsKey(newSubscription.GetSubscriptionEmail()))
        {
           
            // testing if magazine exists
            if(magazineList.GetAllPublicationList().containsKey(newSubscription.GetSubbedPublication().GetMagazineName()))
            {
                // testing if subscription contains new subscription
                if(subscriptionList.containsKey(newSubscription.GetSubscriptionEmail()))
                {
                    if(subscriptionList.get(newSubscription.GetSubscriptionEmail()).containsKey(newSubscription.GetSubbedPublication().GetMagazineName()))
                    {
                        throw new IllegalArgumentException("Subscription exists already");
                    }
                    else
                    {
                        subscriptionList.get(newSubscription.GetSubscriptionEmail()).put(newSubscription.GetSubbedPublication().GetMagazineName(), newSubscription);
                       
                    }
                }
                else
                {
                    HashMap<String, Subscription> tempList = new HashMap<>();
                    tempList.put(newSubscription.GetSubbedPublication().GetMagazineName(), newSubscription);
                    subscriptionList.put(newSubscription.GetSubscriptionEmail(), tempList);
                }
            }
            else
            {
                throw new IllegalArgumentException("Magazine does not exist!");
            }
        }
        else
        {
            throw new IllegalArgumentException("Subscriber is not a customer");
        }
    }
    
    /**
    * <p> This is the accessor to subscription list </p>
    * @return subscriptionList the list of subscription 
    * @since 1.0
    */
    public HashMap<String, HashMap<String,Subscription>> GetSubscriptions()
    {
        return subscriptionList;
    }
    
    public void RemoveSubscription(Subscription targetSubscription)
    {
        if(subscriptionList.containsKey(targetSubscription.GetSubscriptionEmail()))
        {
            if(subscriptionList.get(targetSubscription.GetSubscriptionEmail()).containsKey(targetSubscription.GetSubbedPublication().GetMagazineName()))
            {
                subscriptionList.get(targetSubscription.GetSubscriptionEmail()).get(targetSubscription.GetSubbedPublication().GetMagazineName()).SetActiveSubscriptionFalse();
            }
            else
            {
                throw new IllegalArgumentException("Publication has not been subscribed");
            }
        }
        else
        {
            throw new IllegalArgumentException("Customer does not have a subscription");
        }
    }
    
    
    /**
    * <p> This is the accessor to the subscription List </p>
    * @since 1.0
    */
    public void PrintSubscription()
    {
        for(Map.Entry pair : this.subscriptionList.entrySet())
        {
            
            HashMap<String, Subscription> tempSubs = (HashMap <String, Subscription>) pair.getValue();
            for(Map.Entry subbedPair: tempSubs.entrySet())
            {
                Subscription printSubs = (Subscription) subbedPair.getValue();
                System.out.println();
                System.out.println("Subscription Customer: " + printSubs.GetSubscriptionEmail());
                System.out.println("Subbed Magazine: "+ printSubs.GetSubbedPublication().GetMagazineName());
                System.out.println("Subscription Cost: " + printSubs.GetSubbedPublication().GetMagazineCost());
                System.out.println("Subscription Date: " + printSubs.GetSubscriptionDate().toString());
                System.out.println("Subscription Status: " + printSubs.GetActiveSubscription());
            }
            
        }
    }
    
    /**
    * <p> This function contains the logic for the emailing customers</p>
    * @since 1.0
    */
    public void EmailCustomers()
    {
        LocalDate currentDate = LocalDate.now();
        
        // iterating through the patrons
        for(Map.Entry pair: this.customerList.GetPatron().entrySet())
        {
            
            Customer currentCustomer = (Customer) pair.getValue();
            HashMap<String, Subscription> customerSubscription;
            customerSubscription = subscriptionList.get(currentCustomer.GetEmailAddress());
            
            // iterating though the subscriptions
            for(Map.Entry magazinePair: customerSubscription.entrySet())
            {
                
                Subscription currentSubs = (Subscription) magazinePair.getValue();
                // gets all the mondays following the subscription date
                ArrayList<LocalDate> emailDates = GetInvoiceDates(currentDate, currentSubs);
                
                // iterating through all the email dates
                for(int ii = 0; ii < emailDates.size(); ii += 1)
                {
                    Datum emailDate = new Datum(emailDates.get(ii).getDayOfMonth(), emailDates.get(ii).getMonthValue(), emailDates.get(ii).getYear());
                    //System.out.println("invoiceDate: "+ invoiceDate.toString());
                    String emailKey = currentCustomer.GetEmailAddress()
                            +currentSubs.GetSubbedPublication().GetMagazineName()
                            + emailDate.toString();
                    Email currentEmail = new Email(emailKey, currentCustomer.GetEmailAddress(), currentCustomer,customerSubscription, emailDate);

                    if(generatedEmails.containsKey(currentCustomer.GetEmailAddress()))
                    {
                        if(generatedEmails.get(currentCustomer.GetEmailAddress()).containsKey(emailKey))
                        {
                            throw new IllegalArgumentException("Email Exists");
                        }
                        else
                        {
                            generatedEmails.get(currentCustomer.GetEmailAddress()).put(emailKey, currentEmail);
                        }
                    }
                    else
                    {
                        HashMap<String, Email> tempMap = new HashMap<>();
                        tempMap.put(emailKey, currentEmail);
                        generatedEmails.put(currentCustomer.GetEmailAddress(), tempMap);
                    }
                }

                
            }
            
            // getting all the associates subscription for emailling
            if(this.customerList.GetAssociates().containsKey(currentCustomer.GetEmailAddress()))
            {
                
                HashMap<String, Associate> associateMap = this.customerList.GetAssociates().get(currentCustomer.GetEmailAddress());
                for(Map.Entry associatePair: associateMap.entrySet())
                {
                    Customer associateCustomer = (Customer) associatePair.getValue();
                    
                    HashMap<String, Subscription> associateSubscriptions;
                    associateSubscriptions = subscriptionList.get(associateCustomer.GetEmailAddress());
                    for(Map.Entry associateSubsPair : associateSubscriptions.entrySet())
                    {
                        Subscription associateSubscription = (Subscription) associateSubsPair.getValue();
                        
                        ArrayList<LocalDate> invoiceAssociateDates = this.GetInvoiceDates(currentDate, associateSubscription);
                        
                        for(int ii = 0; ii < invoiceAssociateDates.size(); ii += 1)
                        {
                            
                            Datum invoiceAssociateDate = new Datum(invoiceAssociateDates.get(ii).getDayOfMonth(), invoiceAssociateDates.get(ii).getMonthValue(), invoiceAssociateDates.get(ii).getYear());
                            String invoiceAssociateKey = associateCustomer.GetEmailAddress() 
                                    + associateSubscription.GetSubbedPublication().GetMagazineName()
                                    + invoiceAssociateDate.toString();
                            Email associateInvoice = new Email(invoiceAssociateKey, 
                                                                    associateCustomer.GetEmailAddress(), 
                                                                    associateCustomer, 
                                                                    associateSubscriptions, 
                                                                    invoiceAssociateDate);

                            if(generatedEmails.containsKey(currentCustomer.GetEmailAddress()))
                            {
                                if(generatedEmails.get(currentCustomer.GetEmailAddress()).containsKey(invoiceAssociateKey))
                                {
                                    throw new IllegalArgumentException("Email Exists");
                                }
                                else
                                {
                                    generatedEmails.get(currentCustomer.GetEmailAddress()).put(invoiceAssociateKey, associateInvoice);
                                }
                            }
                            else
                            {
                                HashMap<String, Email> tempMap = new HashMap<>();
                                tempMap.put(invoiceAssociateKey, associateInvoice);
                                generatedEmails.put(currentCustomer.GetEmailAddress(), tempMap);
                            }
                        }
                        

                    
                    }
                }
                    
            }
            else
            {
                System.out.println("No associates linked to account");
                //throw new IllegalArgumentException("No associate customer linked to patron.");
            }
        }
    }
    
    /**
    * <p> This function collates and print all the emails in the subscription </p>
    * @since 1.0
    */
    public void PrintEmails()
    {
        LocalDateTime currentDate = LocalDateTime.now();
        for(Map.Entry pair: this.generatedEmails.entrySet())
        {
            String customerKey = (String)pair.getKey();
            
            String patronFirstName = customerList.patron.get(customerKey).GetFirstName();
            String patronLastName = customerList.patron.get(customerKey).GetLastName();
            
            System.out.println("To:" + customerKey);
            System.out.println();
            System.out.println("RE: Subcriptions for the period indexed: " + currentDate.getYear() +" " + currentDate.getMonth());
            System.out.println();
            System.out.println("Dear:" + patronFirstName + " " + patronLastName +",");
            System.out.println("The following subscriptions are available for reading:");
            
            HashMap <String, Email> customerMap = (HashMap<String, Email>) pair.getValue();
            for(Map.Entry customerPair: customerMap.entrySet())
            {
                String emailKey = (String)customerPair.getKey();
                String currentPeriod = currentDate.getYear() + "" +currentDate.getMonthValue();
                String periodInvoice = generatedEmails.get(customerKey).get(emailKey).GetEmailDate().getYear() + ""
                                        +generatedEmails.get(customerKey).get(emailKey).GetEmailDate().getMonth();
                // only prints email for the current period
                if(currentPeriod.equals(periodInvoice))
                {
                    generatedEmails.get(customerKey).get(emailKey).PrintEmail();
                }
            }
            System.out.println();
        } 
        
    }
}
