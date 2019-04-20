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
public class ServiceManager {
    
    private MagazineManager magazineList;
    
    private CustomerManager customerList;
    // email, magazine name, subscription
    private HashMap<String, HashMap<String, Subscription>> subscriptionList;
    //customer--> invoicekey-->invoice
    private HashMap<String, HashMap<String, Invoice>> billedInvoice;
    
    private HashMap<String, HashMap<String, Email>> generatedEmails;
    
    
    public ServiceManager()
    {
        this.billedInvoice = new HashMap<>();
        this.generatedEmails = new HashMap<>();
        this.subscriptionList = new HashMap<>();
        this.customerList = new CustomerManager();
        this.magazineList = new MagazineManager();
    }
    
    public CustomerManager GetCustomerList()
    {
        return customerList;
    }
    
    public MagazineManager GetMagazineList()
    {
        return magazineList;
    }
    
    public void InvoiceCustomers()
    {
        LocalDate currentDate = LocalDate.now();
        
        for(Map.Entry pair: this.customerList.GetPatron().entrySet())
        {
            
            Customer currentCustomer = (Customer) pair.getValue();
            HashMap<String, Subscription> customerSubscription;
            customerSubscription = subscriptionList.get(currentCustomer.GetEmailAddress());
            
            for(Map.Entry magazinePair: customerSubscription.entrySet())
            {
                
                Subscription currentSubs = (Subscription) magazinePair.getValue();
                ArrayList<LocalDate> invoiceDates = GetInvoiceDates(currentDate, currentSubs);
                System.out.println("invoice array: " + invoiceDates.size());
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
    
    public HashMap<String, HashMap<String,Invoice>> GetBilledInvoices()
    {
        return this.billedInvoice;
    }
    
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
    
    // Only creates a subscription with an empty list of magazines. Does not add magazines to the subscription.
    public void AddSubscription(Subscription newSubscription )
    {
        // testing if patron exists
        if(customerList.CustomerList().containsKey(newSubscription.GetSubscriptionEmail()))
        {
            //Boolean check = magazineList.GetAllPublicationList().containsKey(newSubscription.GetSubbedPublication().GetMagazineName());
            //System.out.println("Magazine State: " + check);
            // testing if magazine exists
            if(magazineList.GetAllPublicationList().containsKey(newSubscription.GetSubbedPublication().GetMagazineName()))
            {
                
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
    
    public void EmailCustomers()
    {
        LocalDate currentDate = LocalDate.now();
        
        for(Map.Entry pair: this.customerList.GetPatron().entrySet())
        {
            
            Customer currentCustomer = (Customer) pair.getValue();
            HashMap<String, Subscription> customerSubscription;
            customerSubscription = subscriptionList.get(currentCustomer.GetEmailAddress());
            
            for(Map.Entry magazinePair: customerSubscription.entrySet())
            {
                
                Subscription currentSubs = (Subscription) magazinePair.getValue();
                ArrayList<LocalDate> emailDates = GetInvoiceDates(currentDate, currentSubs);
                
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
    
    public void PrintEmails()
    {
        System.out.println("Running print emails");
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
                if(currentPeriod.equals(periodInvoice))
                {
                    generatedEmails.get(customerKey).get(emailKey).PrintEmail();
                }
            }
            System.out.println();
        } 
        
    }
}
