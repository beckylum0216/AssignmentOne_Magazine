/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

/**
 *
 * @author becky
 */

/**
    * <p>To get the monthly charge of each magazine or supplement related to 
    * each customer and to format the output</p>
    * @param void
    * @return void
    * @see 
    * @since 1.0
    */

public class Invoice 
{
    private int invoiceID;
    private Subscription invoiceSubscription;
    private Datum invoiceDate;
    
    public Invoice(Subscription inputSubscription)
    {
        this.invoiceSubscription = inputSubscription;
    }
    
    public void SetInvoiceID(int inputID)
    {
        this.invoiceID = inputID;
    }
    
    public int GetInvoiceID()
    {
        return this.invoiceID;
    }
    
    /**
    * <p>This is the setter for the invoice. Allows the customer to be 
    * associated with the invoice</p>
    * @param inputCustomer the email to be stored
    * @return void
    * @see 
    * @since 1.0
    */
    public void SetCustomerInvoice(Customer inputCustomer)
    {
        this.invoiceCustomer = inputCustomer;
    }
    
    /**
    * <p> This is the getter for the invoice. Allows the customer to be 
    * retrieved</p>
    * @param inputCustomer the email to be stored
    * @return void
    * @see 
    * @since 1.0
    */
    public Customer GetCustomerInvoice()
    {
        return this.invoiceCustomer;
    }
    
    /**
    * <p> This is the mutator for the invoice date. </p>
    * @param inputDate the invoice date to be stored
    * @return void
    * @see 
    * @since 1.0
    */
    public void SetInvoiceDate(Datum inputDate)
    {
        this.invoiceDate = inputDate;
    }
    
    /**
    * <p> This is the accessor for the invoice date. </p>
    * @param void 
    * @return invoiceDate
    * @see 
    * @since 1.0
    */
    public Datum GetInvoiceDate()
    {
        return this.invoiceDate;
    }
    
    /**
    * <p> This is the accessor for the invoice date. </p>
    * @param void 
    * @return invoiceDate
    * @see 
    * @since 1.0
    */
    
    public void PrintInvoice()
    {
        for(int ii = 0; ii < invoiceCustomer.GetSubscriptions().size(); ii += 1)
        {
            System.out.print(
                    "Invoice ID: " + this.invoiceID 
                    + " Customer: " + invoiceCustomer.GetFirstName() + " " + invoiceCustomer.GetLastName() 
                    + " Magazine: " + invoiceCustomer.GetSubscriptions().get(ii).GetMagazineName()
                    + " Cost: " + invoiceCustomer.GetSubscriptions().get(ii).GetMagazineCost());
        }
    }
}
