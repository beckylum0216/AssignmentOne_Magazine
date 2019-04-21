/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentOne.Test.MagazineService;
/*
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
*/


import assignmentone_magazine.Associate;
import assignmentone_magazine.Customer;
import assignmentone_magazine.CustomerManager;
import java.util.HashMap;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;


/**
 *
 * @author becky
 */
public class Test000_CustomerManager {
    
    public Test000_CustomerManager() {
    }
    
    

    @Test
    public void Test000_CustomerManager()
    {
        CustomerManager testManager = new CustomerManager();
        
        Assert.assertTrue(true);
    }
    
    @Test
    public void Test001_AddPatron()
    {
        CustomerManager testManager = new CustomerManager();
        Customer testCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        
        testManager.AddPatron(testCustomer);
        
        Assert.assertEquals("baldy", testManager.GetPatron().get("bs@wanpan.co.jp").GetFirstName());
    }
    
    @Test
    public void Test002_GetPatron()
    {
        CustomerManager testManager = new CustomerManager();
        Customer testCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        
        testManager.AddPatron(testCustomer);
        HashMap<String,Customer> testMap = testManager.GetPatron();
        
        Assert.assertEquals("baldy", testMap.get("bs@wanpan.co.jp").GetFirstName());
    }
    
    @Test
    public void Test003_AddAssociate()
    {
        CustomerManager testManager = new CustomerManager();
       
        Customer testCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        
        testManager.AddPatron(testCustomer);
        Associate testAssociate = new Associate("genos", "Saitama", "gs@wanpan.co.jp", "Patron", "bs@wanpan.co.jp");
        testManager.AddAssociate(testAssociate);
        
        Assert.assertEquals("genos", testManager.GetAssociates().get("bs@wanpan.co.jp").get("gs@wanpan.co.jp").GetFirstName());
    }
    
    
    
}
