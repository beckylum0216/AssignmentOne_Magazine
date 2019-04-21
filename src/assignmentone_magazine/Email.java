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
/**
* <p> Parent passive data structure for Emails</p>
* @since 1.0
*/
public class Email 
{
    String emailID;
    private String patronEmail;
    private Customer customer;
    private HashMap <String, Subscription> subscriptions;
    private Datum emailDate;
    
    /**
    * <p> Email constructor</p>
    * @param emailID unique email id
    * @param inputEmail customer email
    * @param inputCustomer customer record
    * @param inputSubscription subscription record
    * @param inputDate email date
    * @since 1.0
    */
    public Email(String emailID, String inputEmail, Customer inputCustomer, HashMap<String, Subscription> inputSubscription, Datum inputDate)
    {
        this.emailID = emailID;
        this.patronEmail = inputEmail;
        this.customer = inputCustomer;
        this.subscriptions = inputSubscription;
        this.emailDate = inputDate;
    }
    
    /**
    * <p> This is the mutator for the email id. Allows the email to be stored</p>
    * @param inputEmailID unique email id
    * @since 1.0
    */
    public void SetEmailId(String inputEmailID)
    {
        this.emailID = inputEmailID;
    }
    
    /**
    * <p> This is the accessor for the email id. Allows the email to be retrieved</p>
    * @return emailID the unique email identifier
    * @since 1.0
    */
    public String GetEmailID()
    {
        return this.emailID;
    }
    
    /**
    * <p> This is the mutator for the patron email. Allows the email to be stored</p>
    * @param inputEmail email address of the patron
    * @since 1.0
    */
    public void SetPatronEmail(String inputEmail)
    {
        this.patronEmail = inputEmail;
    }
    
    /**
    * <p> This is the accessor for the patron email. Allows the email to be retrieved</p>
    * @return patronEmail the patron email address
    * @since 1.0
    */
    public String GetPatronEmail()
    {
        return this.patronEmail;
    }
    
    /**
    * <p>This is the setter for the customer. Allows the customer to be 
    * associated with the email</p>
    * @param inputCustomer the customer to be linked
    * @since 1.0
    */
    public void SetCustomer(Customer inputCustomer)
    {
        this.customer = inputCustomer;
    }
    
    /**
    * <p> This is the getter for the customer. Allows the customer to be 
    * retrieved</p>
    * @return void
    * @since 1.0
    */
    public Customer GetCustomer()
    {
        return this.customer;
    }
    
    /**
    * <p>This is the mutator for the email subscription. Allows the subscription to be 
    * associated with the email</p>
    * @param inputSubscription the subscription to be linked
    * @since 1.0
    */
    public void SetSubscriptions(HashMap<String, Subscription> inputSubscription)
    {
        this.subscriptions = inputSubscription;
    }
    
    /**
    * <p> This is the getter for the subscription. Allows the subcription to be 
    * retrieved</p>
    * @return subscription the subscription list
    * @since 1.0
    */
    public HashMap<String, Subscription> GetSubscriptions()
    {
        return this.subscriptions;
    }
    
    /**
    * <p>This is the mutator for the email date. Dates the email</p>
    * @param inputDate the date the email is generated
    * @since 1.0
    */
    public void SetEmailDate(Datum inputDate)
    {
        this.emailDate = inputDate;
    }
    
    /**
    * <p> This is the accessor for the date. Retrieves the date of the email</p>
    * @return emailDate
    * @since 1.0
    */
    public Datum GetEmailDate()
    {
        return this.emailDate;
    }
    
    /**
    * <p> This is a utility function to print one email. </p>
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
