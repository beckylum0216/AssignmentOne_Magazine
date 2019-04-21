/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author becky
 */
public class CustomerManagerTest {
    
    public CustomerManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of AddPatron method, of class CustomerManager.
     */
    @Test
    public void testAddPatron() {
        System.out.println("AddPatron");
        Customer newCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        CustomerManager instance = new CustomerManager();
        instance.AddPatron(newCustomer);
        Assert.assertEquals("baldy", instance.GetPatron().get("bs@wanpan.co.jp").GetFirstName());
    }

    /**
     * Test of GetPatron method, of class CustomerManager.
     */
    @Test
    public void testGetPatron() {
        System.out.println("GetPatron");
        CustomerManager instance = new CustomerManager();
        Customer newCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        instance.AddPatron(newCustomer);
        String expResult = "baldy";
        String result = instance.GetPatron().get("bs@wanpan.co.jp").GetFirstName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of AddAssociate method, of class CustomerManager.
     */
    @Test
    public void testAddAssociate() {
        System.out.println("AddAssociate");
        CustomerManager instance = new CustomerManager();
        Customer testCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        instance.AddPatron(testCustomer);
        Associate testAssociate = new Associate("genos", "Saitama", "gs@wanpan.co.jp", "Patron", "bs@wanpan.co.jp");
        instance.AddAssociate(testAssociate);
        
        
        // TODO review the generated test code and remove the default call to fail.
        Assert.assertEquals("genos", instance.GetAssociates().get("bs@wanpan.co.jp").get("gs@wanpan.co.jp").GetFirstName());
    }

    /**
     * Test of RemovePatron method, of class CustomerManager.
     */
    @Test
    public void testRemovePatron() {
        System.out.println("RemovePatron");
        
        
        Customer targetCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        CustomerManager instance = new CustomerManager();
        instance.AddPatron(targetCustomer);
        instance.RemovePatron(targetCustomer);
        
    }

    /**
     * Test of RemoveAssociate method, of class CustomerManager.
     */
    @Test
    public void testRemoveAssociate() {
        System.out.println("RemoveAssociate");
        CustomerManager instance = new CustomerManager();
        Customer targetCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        instance.AddPatron(targetCustomer);
        Associate testAssociate = new Associate("genos", "Saitama", "gs@wanpan.co.jp", "Patron", "bs@wanpan.co.jp");
        instance.AddAssociate(testAssociate);
        
        instance.RemoveAssociate(testAssociate);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of GetAssociates method, of class CustomerManager.
     */
    @Test
    public void testGetAssociates() {
        System.out.println("GetAssociates");
        CustomerManager instance = new CustomerManager();
        Customer targetCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        instance.AddPatron(targetCustomer);
        Associate testAssociate = new Associate("genos", "Saitama", "gs@wanpan.co.jp", "Patron", "bs@wanpan.co.jp");
        instance.AddAssociate(testAssociate);
        assertEquals("genos", instance.associate.get(targetCustomer.GetEmailAddress()).get(testAssociate.GetEmailAddress()).GetFirstName());
    }

    /**
     * Test of CustomerList method, of class CustomerManager.
     */
    @Test
    public void testCustomerList() {
        System.out.println("CustomerList");
        CustomerManager instance = new CustomerManager();
        Customer targetCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        instance.AddPatron(targetCustomer);
        assertEquals("baldy", instance.CustomerList().get(targetCustomer.GetEmailAddress()).GetFirstName());
        
    }

    /**
     * Test of PrintCustomers method, of class CustomerManager.
     */
    @Test
    public void testPrintCustomers() {
        System.out.println("PrintCustomers");
        CustomerManager instance = new CustomerManager();
        Customer targetCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        instance.AddPatron(targetCustomer);
        
    }
    
}
