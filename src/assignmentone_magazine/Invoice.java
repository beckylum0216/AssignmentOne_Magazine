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
public abstract class Invoice {
    Customer customerInvoice;
    Supplement magazineInvoice;
    
    public void SetCustomerInvoice(Customer inputCustomer)
    {
        this.customerInvoice = inputCustomer;
    }
    
    public Customer GetCustpmerInvoice()
    {
        return this.customerInvoice;
    }
        
    public void SetMagazineInvoice(Supplement inputMagazine)
    {
        this.magazineInvoice = inputMagazine;
    }
    
    public Supplement GetMagazineInvoice()
    {
        return this.magazineInvoice;
    }
    
}
