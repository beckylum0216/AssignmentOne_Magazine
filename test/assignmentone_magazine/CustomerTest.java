/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author becky
 */
public class CustomerTest {
    
    public CustomerTest() {
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
     * Test of SetFirstName method, of class Customer.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("SetFirstName");
        String inputFirstName = "baldy";
        Customer instance = new Customer("genos", "Saitama", "bs@wanpan.co.jp", "credit Card");
        instance.SetFirstName(inputFirstName);
        
    }

    /**
     * Test of GetFirstName method, of class Customer.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("GetFirstName");
        Customer instance = new Customer("baldy", "Saitama", "bs@wanpan.co.jp", "credit Card");
        String expResult = "baldy";
        instance.SetFirstName(expResult);
        String result = instance.GetFirstName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of SetLastName method, of class Customer.
     */
    @Test
    public void testSetLastName() {
        System.out.println("SetLastName");
        String inputLastName = "";
        Customer instance = null;
        instance.SetLastName(inputLastName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetLastName method, of class Customer.
     */
    @Test
    public void testGetLastName() {
        System.out.println("GetLastName");
        Customer instance = null;
        String expResult = "";
        String result = instance.GetLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetEmailAddress method, of class Customer.
     */
    @Test
    public void testSetEmailAddress() {
        System.out.println("SetEmailAddress");
        String inputEmail = "";
        Customer instance = null;
        instance.SetEmailAddress(inputEmail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetEmailAddress method, of class Customer.
     */
    @Test
    public void testGetEmailAddress() {
        System.out.println("GetEmailAddress");
        Customer instance = null;
        String expResult = "";
        String result = instance.GetEmailAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetPaymentMethod method, of class Customer.
     */
    @Test
    public void testSetPaymentMethod() {
        System.out.println("SetPaymentMethod");
        String inputType = "";
        Customer instance = null;
        instance.SetPaymentMethod(inputType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetPaymentMethod method, of class Customer.
     */
    @Test
    public void testGetPaymentMethod() {
        System.out.println("GetPaymentMethod");
        Customer instance = null;
        String expResult = "";
        String result = instance.GetPaymentMethod();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
