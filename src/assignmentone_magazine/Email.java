/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author becky
 */
public class Email 
{
    String emailID;
    private String patronEmail;
    private Customer customer;
    private HashMap <String, Subscription> subscriptions;
    private Datum emailDate;
    
    public Email(String emailID, String inputEmail, Customer inputCustomer, HashMap<String, Subscription> inputSubscription, Datum inputDate)
    {
        this.emailID = emailID;
        this.patronEmail = inputEmail;
        this.customer = inputCustomer;
        this.subscriptions = inputSubscription;
        this.emailDate = inputDate;
    }
    
    public void SetEmailId(String inputEmailID)
    {
        this.emailID = inputEmailID;
    }
    
    public String GetEmailID()
    {
        return this.emailID;
    }
    
    public void SetPatronEmail(String inputEmail)
    {
        this.patronEmail = inputEmail;
    }
    
    public String GetPatronEmail()
    {
        return this.patronEmail;
    }
    
    /**
    * <p>This is the setter for the invoice. Allows the customer to be 
    * associated with the invoice</p>
    * @param inputCustomer the email to be stored
    * @return void
    * @see 
    * @since 1.0
    */
    public void SetCustomer(Customer inputCustomer)
    {
        this.customer = inputCustomer;
    }
    
    /**
    * <p> This is the getter for the invoice. Allows the customer to be 
    * retrieved</p>
    * @param inputCustomer the email to be stored
    * @return void
    * @see 
    * @since 1.0
    */
    public Customer GetCustomer()
    {
        return this.customer;
    }
    
    public void SetSubscriptions(HashMap<String, Subscription> inputSubscription)
    {
        this.subscriptions = inputSubscription;
    }
    
    public HashMap<String, Subscription> GetSubscriptions()
    {
        return this.subscriptions;
    }
    
    public void SetEmailDate(Datum inputDate)
    {
        this.emailDate = inputDate;
    }
    
    public Datum GetEmailDate()
    {
        return this.emailDate;
    }
    
    /**
    * <p> This is the accessor for the invoice date. </p>
    * @param void 
    * @return invoiceDate
    * @see 
    * @since 1.0
    */
    
    public void PrintEmail()
    {
        
        // itemise account
        for(Map.Entry pair: this.subscriptions.entrySet())
        {
            Subscription tempSubscription = (Subscription) pair.getValue();
            System.out.println("    Magazine: " + tempSubscription.GetSubbedPublication().GetMagazineName());
        }
        
    }
    
}
