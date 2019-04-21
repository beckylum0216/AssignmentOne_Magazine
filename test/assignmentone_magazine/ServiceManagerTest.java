/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

import static assignmentone_magazine.AssignmentOne_Magazine.magazineService;
import java.util.HashMap;
import java.util.List;
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
public class ServiceManagerTest {
    
    public ServiceManagerTest() {
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
     * Test of GetCustomerList method, of class ServiceManager.
     */
    @Test
    public void testGetCustomerList() {
        System.out.println("GetCustomerList");
        ServiceManager instance = new ServiceManager();
        Customer newCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        CustomerManager testCustomerManager = instance.GetCustomerList();
        testCustomerManager.AddPatron(newCustomer);
        CustomerManager result = instance.GetCustomerList();
        assertEquals("baldy", result.CustomerList().get(newCustomer.GetEmailAddress()).GetFirstName());
        
    }

    /**
     * Test of GetMagazineList method, of class ServiceManager.
     */
    @Test
    public void testGetMagazineList() {
        System.out.println("GetMagazineList");
        ServiceManager instance = new ServiceManager();
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.GetMagazineList().AddMagazine(testMagazine);
        
        MagazineManager result = instance.GetMagazineList();
        assertEquals("blah weekly", result.GetMagazines().get(testMagazine.GetMagazineName()).GetMagazineName());
        
    }
    
    
    
    /**
     * Test of InvoiceCustomers method, of class ServiceManager.
     */
    @Test
    public void testInvoiceCustomers() {
        System.out.println("InvoiceCustomers");
        ServiceManager instance = new ServiceManager();
        
        Customer newCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        Datum testDate = new Datum(17, 07, 2007);
        Subscription testSubcription = new Subscription(newCustomer.GetEmailAddress(), testDate, testMagazine, true);
        
        instance.GetCustomerList().AddPatron(newCustomer);
        instance.GetMagazineList().AddMagazine(testMagazine);
        instance.AddSubscription(testSubcription);
        
        instance.InvoiceCustomers();
        
    }

    /**
     * Test of GetBilledInvoices method, of class ServiceManager.
     */
    @Test
    public void testGetBilledInvoices() {
        System.out.println("GetBilledInvoices");
        ServiceManager instance = new ServiceManager();
        Customer newCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        Datum testDate = new Datum(17, 07, 2007);
        Subscription testSubcription = new Subscription(newCustomer.GetEmailAddress(), testDate, testMagazine, true);
        
        instance.GetCustomerList().AddPatron(newCustomer);
        instance.GetMagazineList().AddMagazine(testMagazine);
        instance.AddSubscription(testSubcription);
        
        instance.GetBilledInvoices();
    }

    /**
     * Test of PrintStatements method, of class ServiceManager.
     */
    @Test
    public void testPrintStatements() {
        System.out.println("PrintStatements");
        ServiceManager instance = new ServiceManager();
        
        Customer newCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        Datum testDate = new Datum(17, 07, 2007);
        Subscription testSubcription = new Subscription(newCustomer.GetEmailAddress(), testDate, testMagazine, true);
        
        instance.GetCustomerList().AddPatron(newCustomer);
        instance.GetMagazineList().AddMagazine(testMagazine);
        instance.AddSubscription(testSubcription);
        
        instance.PrintStatements();
    }

    /**
     * Test of AddSubscription method, of class ServiceManager.
     */
    @Test
    public void testAddSubscription() {
        System.out.println("AddSubscription");
        ServiceManager instance = new ServiceManager();
        Customer newCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        Datum testDate = new Datum(17, 07, 2007);
        Subscription testSubcription = new Subscription(newCustomer.GetEmailAddress(), testDate, testMagazine, true);
        
        instance.GetCustomerList().AddPatron(newCustomer);
        instance.GetMagazineList().AddMagazine(testMagazine);
        instance.AddSubscription(testSubcription);
    }

    /**
     * Test of GetSubscriptions method, of class ServiceManager.
     */
    @Test
    public void testGetSubscriptions() {
        System.out.println("GetSubscriptions");
        ServiceManager instance = new ServiceManager();
        
        Customer newCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        Datum testDate = new Datum(17, 07, 2007);
        Subscription testSubscription = new Subscription(newCustomer.GetEmailAddress(), testDate, testMagazine, true);
        
        instance.GetCustomerList().AddPatron(newCustomer);
        instance.GetMagazineList().AddMagazine(testMagazine);
        instance.AddSubscription(testSubscription);
        
        Assert.assertEquals("bs@wanpan.co.jp", instance.GetSubscriptions().get(newCustomer.GetEmailAddress()).get(testSubscription.GetSubbedPublication().GetMagazineName()).GetSubscriptionEmail());
    }

    /**
     * Test of RemoveSubscription method, of class ServiceManager.
     */
    @Test
    public void testRemoveSubscription() {
        System.out.println("RemoveSubscription");
        ServiceManager instance = new ServiceManager();
        
        Customer newCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        Datum testDate = new Datum(17, 07, 2007);
        Subscription testSubscription = new Subscription(newCustomer.GetEmailAddress(), testDate, testMagazine, true);
        
        instance.GetCustomerList().AddPatron(newCustomer);
        instance.GetMagazineList().AddMagazine(testMagazine);
        instance.AddSubscription(testSubscription);
        
        instance.RemoveSubscription(testSubscription);
        
    }

    /**
     * Test of PrintSubscription method, of class ServiceManager.
     */
    @Test
    public void testPrintSubscription() {
        System.out.println("PrintSubscription");
        ServiceManager instance = new ServiceManager();
        
        Customer newCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        Datum testDate = new Datum(17, 07, 2007);
        Subscription testSubscription = new Subscription(newCustomer.GetEmailAddress(), testDate, testMagazine, true);
        
        instance.GetCustomerList().AddPatron(newCustomer);
        instance.GetMagazineList().AddMagazine(testMagazine);
        instance.AddSubscription(testSubscription);
        
        instance.PrintSubscription();
        
    }

    /**
     * Test of EmailCustomers method, of class ServiceManager.
     */
    @Test
    public void testEmailCustomers() {
        System.out.println("EmailCustomers");
        ServiceManager instance = new ServiceManager();
        
        Customer newCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        Datum testDate = new Datum(17, 07, 2007);
        Subscription testSubscription = new Subscription(newCustomer.GetEmailAddress(), testDate, testMagazine, true);
        
        instance.GetCustomerList().AddPatron(newCustomer);
        instance.GetMagazineList().AddMagazine(testMagazine);
        instance.AddSubscription(testSubscription);
        
        instance.EmailCustomers();
        
    }

    /**
     * Test of PrintEmails method, of class ServiceManager.
     */
    @Test
    public void testPrintEmails() {
        System.out.println("PrintEmails");
        ServiceManager instance = new ServiceManager();
        
        Customer newCustomer = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        Datum testDate = new Datum(17, 07, 2007);
        Subscription testSubscription = new Subscription(newCustomer.GetEmailAddress(), testDate, testMagazine, true);
        
        instance.GetCustomerList().AddPatron(newCustomer);
        instance.GetMagazineList().AddMagazine(testMagazine);
        instance.AddSubscription(testSubscription);
        
        instance.PrintEmails();
        
    }
    
}
