/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author becky
 */

/**
    * <p>To get the monthly charge of each magazine or supplement related to 
    * each customer and to format the output</p> 
    * @since 1.0
    */

public class Invoice 
{
    private String invoiceID;
    private String patronEmail;
    private Customer customer;
    
    private HashMap <String, Subscription> subscriptions;
    private Datum invoiceDate;
    
    /**
    * <p> Invoice constructor</p>
    * @param inputID unique email id
    * @param inputEmail customer email
    * @param inputCustomer customer record
    * @param inputSubscriptions subscription record
    * @param inputDate email date 
    * @since 1.0
    */
    public Invoice(String inputID, String inputEmail, Customer inputCustomer, HashMap<String, Subscription> inputSubscriptions, Datum inputDate)
    {
        this.invoiceID = inputID;
        this.patronEmail = inputEmail;
        this.customer = inputCustomer;
        this.subscriptions = inputSubscriptions;
        this.invoiceDate = inputDate;
    }
    
    /**
    * <p> This is the mutator for the invoice id. unique invoice identifier</p>
    * @param inputID unique email id
    * @since 1.0
    */
    public void SetInvoiceID(String inputID)
    {
        this.invoiceID = inputID;
    }
    
    /**
    * <p> This is the accessor for the invoice id. Allows the email to be retrieved</p>
    * @return invoiceID the unique invoice identifier
    * @since 1.0
    */
    public String GetInvoiceID()
    {
        return this.invoiceID;
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
    * @since 1.0
    */
    public void SetCustomer(Customer inputCustomer)
    {
        this.customer = inputCustomer;
    }
    
    /**
    * <p> This is the getter for the invoice. Allows the customer to be 
    * retrieved</p>
    * @return void
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
    
    /**
    * <p> This is the mutator for the invoice date. </p>
    * @param inputDate the invoice date to be stored
    * @since 1.0
    */
    public void SetInvoiceDate(Datum inputDate)
    {
        this.invoiceDate = inputDate;
    }
    
    /**
    * <p> This is the accessor for the invoice date. </p>
    * @return invoiceDate
    * @since 1.0
    */
    public Datum GetInvoiceDate()
    {
        return this.invoiceDate;
    }
    
    /**
    * <p> This is a utility function to print one invoice. </p>
    * @since 1.0
    */
    public void PrintInvoice()
    {
       
        // itemise account
        for(Map.Entry pair: this.subscriptions.entrySet())
        {
            Subscription tempSubscription = (Subscription) pair.getValue();
            System.out.println("Invoice ID: " + this.invoiceID + " Date: " + this.invoiceDate.toString()+"    Magazine: " + tempSubscription.GetSubbedPublication().GetMagazineName() +
                               "    "+ tempSubscription.GetSubbedPublication().GetMagazineCost());
            
        }
    }
    
    public float GetTotalInvoice()
    {
        float totalInvoice = 0.00f;
        for(Map.Entry pair: this.subscriptions.entrySet())
        {
            Subscription tempSubscription = (Subscription) pair.getValue();
            totalInvoice +=  tempSubscription.GetSubbedPublication().GetMagazineCost();

        }
        
        return totalInvoice;
    }
    
}
