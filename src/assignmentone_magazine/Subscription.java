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
public class Subscription {
    
    private String subscriptionEmail;
    private Datum subscriptionDate;
    private Magazine subbedPublication;
    private boolean subscriptionActive;
    
    Subscription(String inputEmail, Datum inputDate)
    {
        this.subscriptionEmail = inputEmail;
        this.subscriptionDate = inputDate;
       
    }
    
    public void SetSubscriptionEmail(String inputSubscriptionEmail)
    {
        this.subscriptionEmail = inputSubscriptionEmail;
    }
    
    public String GetSubscriptionEmail()
    {
        return this.subscriptionEmail;
    }
    
    public void SetSubscriptionDate(Datum inputDate)
    {
        this.subscriptionDate = inputDate;
    }
    
    public Datum GetSubscriptionDate()
    {
        return this.subscriptionDate;
    }
    
    public void SetSubbedPublication(Magazine inputPublication)
    {
        this.subbedPublication = inputPublication;
    }
    
    public Magazine GetSubbedPublication()
    {
        return this.subbedPublication;
    }
    
    public void SetActiveSubscriptionTrue()
    {
        this.subscriptionActive = true;
    }
    
    public void SetActiveSubscriptionFalse()
    {
        this.subscriptionActive = false;
    }
    
    public boolean GetActiveSubscription()
    {
        return this.subscriptionActive;
    }
}
