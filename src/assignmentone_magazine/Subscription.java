/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

import java.util.ArrayList;

/**
 *
 * @author becky
 */

/**
* <p> Parent passive data structure for subscriptions</p>
* @since 1.0
*/
public class Subscription {
    
    private String subscriptionEmail;
    private Datum subscriptionDate;
    private Magazine subbedPublication;
    private boolean subscriptionActive;
    
    /**
    * <p> Parameterised Subscription constructor</p>
    * @param inputEmail unique email identifier
    * @param inputDate subscription date
    * @param inputPublication magazine being subscribed to 
    * @param inputStatus subscription being made inactive. Cannot delete subscription records finance regulations
    * @return void
    * @see 
    * @since 1.0
    */
    Subscription(String inputEmail, Datum inputDate, Magazine inputPublication, boolean inputStatus)
    {
        this.subscriptionEmail = inputEmail;
        this.subscriptionDate = inputDate;
        this.subbedPublication = inputPublication;
        this.subscriptionActive = inputStatus;
       
    }
    
    /**
    * <p> This is the setter for the subscription email. unique subscription email</p>
    * @param inputSubscriptionEmail unique subscription email 
    * @since 1.0
    */
    public void SetSubscriptionEmail(String inputSubscriptionEmail)
    {
        this.subscriptionEmail = inputSubscriptionEmail;
    }
    
    /**
    * <p> This is the getter for the subscription email.</p>
    * @return subscriptionEmail 
    * @since 1.0
    */
    public String GetSubscriptionEmail()
    {
        return this.subscriptionEmail;
    }
    
    /**
    * <p> This is the setter for the subscription date. date of the subscription</p>
    * @param inputDate date of subscription 
    * @since 1.0
    */
    public void SetSubscriptionDate(Datum inputDate)
    {
        this.subscriptionDate = inputDate;
    }
    
    /**
    * <p> This is the accessor for the subscription date. date of the subscription</p>
    * @return subscriptionDate date of subscription
    * @since 1.0
    */
    public Datum GetSubscriptionDate()
    {
        return this.subscriptionDate;
    }
    
    /**
    * <p> This is the setter for the magazine. details of magazine subscription</p>
    * @param inputPublication details of subscription
    * @since 1.0
    */
    public void SetSubbedPublication(Magazine inputPublication)
    {
        this.subbedPublication = inputPublication;
    }
    
    /**
    * <p> This is the accessor for the subscribed publications.</p>
    * @return subbedPublication subscribed magazine
    * @since 1.0
    */
    public Magazine GetSubbedPublication()
    {
        return this.subbedPublication;
    }
    
    /**
    * <p> This is the setter for the subscription state. sets it to true </p>
    * @since 1.0
    */
    public void SetActiveSubscriptionTrue()
    {
        this.subscriptionActive = true;
    }
    
    /**
    * <p> This is the setter for the subscription state. sets it to false </p>
    * @since 1.0
    */
    public void SetActiveSubscriptionFalse()
    {
        this.subscriptionActive = false;
    }
    
    /**
    * <p> This is the accessor for the subscription state. </p>
    * @return subscriptionActive subscription state
    * @since 1.0
    */
    public boolean GetActiveSubscription()
    {
        return this.subscriptionActive;
    }
    
    
}
