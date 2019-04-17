/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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
    
    
    public ServiceManager()
    {
        this.billedInvoice = new HashMap<>();
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
        LocalDateTime currentDate = LocalDateTime.now();
        
        
        for(Map.Entry pair: this.customerList.GetPatron().entrySet())
        {
           
            Customer currentCustomer = (Customer) pair.getValue();
            String invoiceKey = currentCustomer.GetEmailAddress() 
                            + Integer.toString(currentDate.getYear()) 
                            + Integer.toString(currentDate.getMonthValue());
            
            HashMap<String, Subscription> customerSubscription;
            customerSubscription = subscriptionList.get(currentCustomer.GetEmailAddress());
            Datum invoiceDate = new Datum(currentDate.getDayOfMonth(), currentDate.getMonthValue(), currentDate.getYear());
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
            
            if(this.customerList.GetAssociates().containsKey(currentCustomer.GetEmailAddress()))
            {
                HashMap<String, Associate> associateMap = this.customerList.GetAssociates().get(currentCustomer.GetEmailAddress());
                System.out.println("Associate Map: "+associateMap);
                for(Map.Entry associatePair: associateMap.entrySet())
                {

                    String associateKey = (String) associatePair.getKey(); // <-- error here!
                    Customer associateCustomer = (Customer) associatePair.getValue();
                    String invoiceAssociateKey = associateCustomer.GetEmailAddress() 
                                    + Integer.toString(currentDate.getYear()) 
                                    + Integer.toString(currentDate.getMonthValue());

                    HashMap<String, Subscription> associateSubscription;
                    associateSubscription = subscriptionList.get(associateCustomer.GetEmailAddress());
                    //Datum invoiceDate = new Datum(currentDate.getDayOfMonth(), currentDate.getMonthValue(), currentDate.getYear());
                    Invoice associateInvoice = new Invoice(invoiceAssociateKey, 
                                                            associateCustomer.GetEmailAddress(), 
                                                            associateCustomer, 
                                                            associateSubscription, 
                                                            invoiceDate);

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
            else
            {
                throw new IllegalArgumentException("No associate customer linked to patron.");
            }
            
            
        }
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
            
            System.out.println("Statement for Period: " + currentDate.getYear() + " " + currentDate.getMonth());
            HashMap <String, Invoice> customerMap = (HashMap<String, Invoice>) pair.getValue();
            for(Map.Entry customerPair: customerMap.entrySet())
            {
                String invoiceKey = (String)customerPair.getKey();
                
                billedInvoice.get(customerKey).get(invoiceKey).PrintInvoice();
                
            }
            
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
    
    
    
}
