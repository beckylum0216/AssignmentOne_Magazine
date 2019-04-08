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
public abstract class Customer {
    
    public enum customerType{associate, customer};
    private int customerID;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private int subscriptionID;
    public enum PaymentType{CreditCard, DirectDebit};
    private PaymentType paymentMethod;
    
    /**
    * <p> This is the setter for the customerID. This is the unique identifier</p>
    * @param inputID the new id to be inputted.
    * @return void
    * @see 
    * @since 1.0
    */
    public void SetCustomerID(int inputID)
    {
        this.customerID = inputID;
    }
    
    /**
    * <p> This is the getter for the customerID. </p>
    * @param void
    * @return void
    * @see 
    * @since 1.0
    */
    public int GetCustomerID()
    {
        return this.customerID;
    }
    
    /**
    * <p> This is the setter for the first name. Allows the first name to be stored</p>
    * @param inputFirstName the first name to be stored
    * @return void
    * @see 
    * @since 1.0
    */
    public void SetFirstName(String inputFirstName)
    {
        this.firstName = inputFirstName;
    }
    
    /**
    * <p> This is the getter for the first name.</p>
    * @param void
    * @return first name
    * @see 
    * @since 1.0
    */
    public String GetFirstName()
    {
        return this.firstName;
    }
    
     /**
    * <p> This is the setter for the first name. Allows the last name to be stored</p>
    * @param inputLastName the last name to be stored
    * @return void
    * @see 
    * @since 1.0
    */
    public void SetLastName(String inputLastName)
    {
        this.lastName = inputLastName;
    }
    
    
    /**
    * <p> This is the setter for the first name. Allows the first name to be stored</p>
    * @param void
    * @return last name of the customer
    * @see 
    * @since 1.0
    */
    public String GetLastName()
    {
        return this.lastName;
    }
    
    /**
    * <p> This is the setter for the email. Allows the email to be stored</p>
    * @param inputEmail the email to be stored
    * @return void
    * @see 
    * @since 1.0
    */
    public void SetEmailAddress(String inputEmail)
    {
        this.emailAddress = inputEmail;
    }
    
    /**
    * <p> This is the getter for the email. Allows the email to be retrieved</p>
    * @param void
    * @return emailAddress retrieves the email address
    * @see 
    * @since 1.0
    */
    public String GetEmailAddress()
    {
        return this.emailAddress;
    }
    
    /**
    * <p> This is the mutator for the subscriptions. </p>
    * @param inputMagazine
    * @return void
    * @see 
    * @since 1.0
    */
    public void AddSubscriptionID(int inputSubscriptionID)
    {
        this.subscriptionID = inputSubscriptionID;
    }
    
    /**
    * <p> This is the accessor for the subscriptions. </p>
    * @param void
    * @return subscriptions. gets a list of subscriptions
    * @see 
    * @since 1.0
    */
    public int GetSubscriptions()
    {
        return this.subscriptionID;
    }
    
    
    /**
    * <p> This is the mutator for the payment method. </p>
    * @param inputType the type of payment method enum of credit card or direct debit
    * @return void
    * @see 
    * @since 1.0
    */
    public void SetPaymentMethod(PaymentType inputType)
    {
        this.paymentMethod = inputType;
    }
    
    
    /**
    * <p> This is the accessor for the payment method. </p>
    * @param void
    * @return paymentMethod the payment type of enum payment type
    * @see 
    * @since 1.0
    */
    public PaymentType GetPaymentMethod()
    {
        return this.paymentMethod;
    }
}
