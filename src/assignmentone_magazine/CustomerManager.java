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
public class CustomerManager {
    HashMap <String, Customer> patron;
    HashMap <String, HashMap<String, Associate>> associate;
    
    public CustomerManager()
    {
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
        
        patron.put(newCustomer.GetEmailAddress(), newCustomer);
    }
    
    public HashMap<String, Customer> GetPatron()
    {
        return this.patron;
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
        if(patron.containsKey(associateCustomer.GetPatronEmail()))
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
    * @return void
    * @see 
    * @since 1.0
    */
    public void RemoveAssociate(Associate targetAssociate)
    {
        associate.get(targetAssociate.GetPatronEmail()).remove(targetAssociate.GetEmailAddress());
    }
    
    /**
    * <p> This is to get a derived list of all customers</p>
    * @param 
    * @return void
    * @see 
    * @since 1.0
    */
    public HashMap<String,Customer> CustomerList()
    {
        
        HashMap<String, Customer> resultList = new HashMap<>();
        
        resultList.putAll(patron);
        
        for (Map.Entry pair : this.associate.entrySet()) {
            HashMap<String, Customer> tempAssociate = (HashMap<String, Customer>) pair.getValue();
            resultList.putAll(tempAssociate);
        }
        
        return resultList;
    }
    
}
