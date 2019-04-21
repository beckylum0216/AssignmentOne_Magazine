/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author becky
 */

/**
* <p> This is the customer manager</p>
* @since 1.0
*/
public class CustomerManager {
    HashMap <String, Customer> patron;
    HashMap <String, HashMap<String, Associate>> associate;
    
    /**
    * <p> This is the customer manager constructor</p>
    * @since 1.0
    */
    public CustomerManager()
    {
        this.patron = new HashMap<>();
        this.associate = new HashMap<>();
    }
    
    /**
    * <p> This method add patrons</p>
    * @param newCustomer the new customer to be added
    * @since 1.0
    */
    public void AddPatron(Customer newCustomer)
    {
        if(!patron.containsKey(newCustomer.GetEmailAddress()))
        {
            patron.put(newCustomer.GetEmailAddress(), newCustomer);
        }
        else
        {
            throw new IllegalArgumentException("Customer already exists!");
        }
        
    }
    
    /**
    * <p> Accessor for patrons</p>
    * @return patron a hashmap of patrons
    * @since 1.0
    */
    public HashMap<String, Customer> GetPatron()
    {
        return this.patron;
    }
    
    /**
    * <p> This is the associate manager</p>
    * @param associateCustomer the new associate to be added
    * @since 1.0
    */
    public void AddAssociate(Associate associateCustomer)
    {
        // checks if customer exists 
        if(patron.containsKey(associateCustomer.GetPatronEmail()))
        {
            if(associate.containsKey(associateCustomer.GetPatronEmail()))
            {
                associate.get(associateCustomer.GetPatronEmail()).put(associateCustomer.GetEmailAddress(),associateCustomer);
            }
            else
            {
                HashMap <String, Associate> tempList = new HashMap<>();
                tempList.put(associateCustomer.GetEmailAddress(),associateCustomer);
                associate.put(associateCustomer.GetPatronEmail(), tempList);
            }
            
        }
        else
        {
            throw new IllegalArgumentException("Patron must exist before adding associate");
            
        }
    }
    
    
    /**
    * <p> This is the customer removal manager</p>
    * @param targetCustomer the customer to be removed
    * @since 1.0
    */
    public void RemovePatron(Customer targetCustomer)
    {
        if(associate.containsKey(targetCustomer.GetEmailAddress()))
        {
            patron.remove(targetCustomer.GetEmailAddress());
            
            associate.remove(targetCustomer.GetEmailAddress());
        }
        else
        {
            patron.remove(targetCustomer.GetEmailAddress());
            
        }
        
    }
    
    
    /**
    * <p> This is the associate removal manager</p>
    * @param targetAssociate the associate to be removed
    * @since 1.0
    */
    public void RemoveAssociate(Associate targetAssociate)
    {
        if(associate.containsKey(targetAssociate.GetPatronEmail()))
        {
            if(associate.get(targetAssociate.GetPatronEmail()).containsKey(targetAssociate.GetEmailAddress()))
            {
                associate.get(targetAssociate.GetPatronEmail()).remove(targetAssociate.GetEmailAddress());
            }
            else
            {
                throw new IllegalArgumentException("Associate does not exist");
            }
        }
        else
        {
            System.out.println("Patron does not exist!");
        }
        
    }
    
    /**
    * <p> This is the accessor for associates</p>
    * @return associates a list of associates
    * @since 1.0
    */
    public HashMap<String, HashMap<String, Associate>> GetAssociates()
    {
        return this.associate;
    }
    
    /**
    * <p> This is to get a derived list of all customers</p>
    * @return resultList a complete lsit of customers
    * @since 1.0
    */
    public HashMap<String,Customer> CustomerList()
    {
        
        HashMap<String, Customer> resultList = new HashMap<>();
        
        resultList.putAll(patron);
        
        for (Map.Entry pair : this.associate.entrySet()) 
        {
            HashMap<String, Customer> tempAssociate = (HashMap<String, Customer>) pair.getValue();
            resultList.putAll(tempAssociate);
        }
        
        return resultList;
    }
    
    /**
    * <p> This is a utility function to print all the customers stored</p>
    * @since 1.0
    */
    public void PrintCustomers()
    {
        HashMap<String, Customer> printList = CustomerList();
        
        for(Map.Entry pair: printList.entrySet())
        {
            String currentKey = (String) pair.getKey();
            Customer currentCustomer = (Customer) pair.getValue();
            System.out.println("Record Key:" + currentKey);
            System.out.println("Name: " + currentCustomer.GetFirstName() + " " + currentCustomer.GetLastName());
            System.out.println("Payment Method:" + currentCustomer.GetPaymentMethod());
        }
    }
    
}
