/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author becky
 */
public class Subscribers {
    HashMap <Integer, Customer> allCustomers;
    HashMap <Integer, Customer> patron;
    HashMap <Integer, ArrayList<Associate>> associate;
    
    public Subscribers()
    {
        this.allCustomers = new HashMap<>();
        this.patron = new HashMap<>();
        this.associate = new HashMap<>();
    }
    
    /**
    * <p> This is the patron manager
    * </p>
    * @param newCustomer the new customer to be added
    * @return void
    * @see 
    * @since 1.0
    */
    public void AddPatron(Customer newCustomer)
    {
        allCustomers.put(newCustomer.GetCustomerID(), newCustomer);
        patron.put(newCustomer.GetCustomerID(), newCustomer);
    }
    
    
    /**
    * <p> This is the associate manager
    * </p>
    * @param associateCustomer the new associate to be added
    * @return void
    * @see 
    * @since 1.0
    */
    public void AddAssociate(Associate associateCustomer)
    {
        // checks if customer exists 
        if(patron.get(associateCustomer.GetPatronID()).hashCode() > 0)
        {
            allCustomers.put(associateCustomer.GetCustomerID(), associateCustomer);
            associate.get(associateCustomer.GetPatronID()).add(associateCustomer);
        }
        else
        {
            allCustomers.put(associateCustomer.GetCustomerID(), associateCustomer);
            ArrayList <Associate> tempList = new ArrayList<>();
            tempList.add(associateCustomer);
            associate.put(associateCustomer.GetPatronID(), tempList);
        }
    }
    
    
    /**
    * <p> This is the customer removal manager
    * </p>
    * @param targetCustomer the customer to be removed
    * @return void
    * @see 
    * @since 1.0
    */
    public void RemovePatron(Customer targetCustomer)
    {
        if(associate.get(targetCustomer.GetCustomerID()).hashCode() > 0)
        {
            patron.remove(targetCustomer.GetCustomerID());
            allCustomers.remove(targetCustomer.GetCustomerID());
            associate.remove(targetCustomer.GetCustomerID());
        }
        else
        {
            patron.remove(targetCustomer.GetCustomerID());
            allCustomers.remove(targetCustomer.GetCustomerID());
        }
        
    }
    
    
    /**
    * <p> This is the associate removal manager
    * </p>
    * @param targetAssociate the associate to be removed
    * @return void
    * @see 
    * @since 1.0
    */
    public void RemoveAssociate(Associate targetAssociate)
    {
        associate.get(targetAssociate.GetPatronID()).remove(targetAssociate.GetCustomerID());
    }
}
