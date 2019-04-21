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
* <p> Parent passive data structure for customer</p>
* @since 1.0
*/
public class Customer {
    
    
    private String firstName;
    private String lastName;
    private String emailAddress;
    //public enum PaymentType{CreditCard, DirectDebit, Patron};
    private String paymentMethod;
    
    /**
    * <p> Default Customer constructor</p>
    * @since 1.0
    */
    public Customer(){}
    
    /**
    * <p> Parameterised Customer constructor</p>
    * @param inputFirstName customer first name 
    * @param inputLastName customer last name
    * @param inputEmail customer email
    * @param inputPayment customer payment method
    * @since 1.0
    */
    public Customer(String inputFirstName, String inputLastName, String inputEmail, String inputPayment)
    {
        this.firstName = inputFirstName;
        this.lastName = inputLastName;
        this.emailAddress = inputEmail;
        this.paymentMethod = inputPayment;
    }
    
    
    /**
    * <p> This is the setter for the first name. Allows the first name to be stored</p>
    * @param inputFirstName the first name to be stored
    * @since 1.0
    */
    public void SetFirstName(String inputFirstName)
    {
        this.firstName = inputFirstName;
    }
    
    /**
    * <p> This is the getter for the first name.</p>
    * @return first name
    * @since 1.0
    */
    public String GetFirstName()
    {
        return this.firstName;
    }
    
     /**
    * <p> This is the setter for the first name. Allows the last name to be stored</p>
    * @param inputLastName the last name to be stored
    * @since 1.0
    */
    public void SetLastName(String inputLastName)
    {
        this.lastName = inputLastName;
    }
    
    
    /**
    * <p> This is the setter for the first name. Allows the first name to be stored</p>
    * @return last name of the customer
    * @since 1.0
    */
    public String GetLastName()
    {
        return this.lastName;
    }
    
    /**
    * <p> This is the setter for the email. Allows the email to be stored</p>
    * @param inputEmail the email to be stored
    * @since 1.0
    */
    public void SetEmailAddress(String inputEmail)
    {
        this.emailAddress = inputEmail;
    }
    
    /**
    * <p> This is the getter for the email. Allows the email to be retrieved</p>
    * @return emailAddress retrieves the email address
    * @since 1.0
    */
    public String GetEmailAddress()
    {
        return this.emailAddress;
    }
    
    
    
    
    /**
    * <p> This is the mutator for the payment method. </p>
    * @param inputType the type of payment method enum of credit card or direct debit
    * @since 1.0
    */
    public void SetPaymentMethod(String inputType)
    {
        this.paymentMethod = inputType;
    }
    
    
    /**
    * <p> This is the accessor for the payment method. </p>
    * @return paymentMethod the payment type of enum payment type 
    * @since 1.0
    */
    public String GetPaymentMethod()
    {
        return this.paymentMethod;
    }
}
