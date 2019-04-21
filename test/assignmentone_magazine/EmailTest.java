/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

import java.util.HashMap;
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
public class EmailTest {
    
    public EmailTest() {
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
     * Test of SetEmailId method, of class Email.
     */
    @Test
    public void testSetEmailId() {
        System.out.println("SetEmailId");
        String inputEmailID = "";
        Email instance = null;
        instance.SetEmailId(inputEmailID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetEmailID method, of class Email.
     */
    @Test
    public void testGetEmailID() {
        System.out.println("GetEmailID");
        Email instance = null;
        String expResult = "";
        String result = instance.GetEmailID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetPatronEmail method, of class Email.
     */
    @Test
    public void testSetPatronEmail() {
        System.out.println("SetPatronEmail");
        String inputEmail = "";
        Email instance = null;
        instance.SetPatronEmail(inputEmail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetPatronEmail method, of class Email.
     */
    @Test
    public void testGetPatronEmail() {
        System.out.println("GetPatronEmail");
        Email instance = null;
        String expResult = "";
        String result = instance.GetPatronEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetCustomer method, of class Email.
     */
    @Test
    public void testSetCustomer() {
        System.out.println("SetCustomer");
        Customer inputCustomer = null;
        Email instance = null;
        instance.SetCustomer(inputCustomer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetCustomer method, of class Email.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("GetCustomer");
        Email instance = null;
        Customer expResult = null;
        Customer result = instance.GetCustomer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetSubscriptions method, of class Email.
     */
    @Test
    public void testSetSubscriptions() {
        System.out.println("SetSubscriptions");
        HashMap<String, Subscription> inputSubscription = null;
        Email instance = null;
        instance.SetSubscriptions(inputSubscription);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetSubscriptions method, of class Email.
     */
    @Test
    public void testGetSubscriptions() {
        System.out.println("GetSubscriptions");
        Email instance = null;
        HashMap<String, Subscription> expResult = null;
        HashMap<String, Subscription> result = instance.GetSubscriptions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetEmailDate method, of class Email.
     */
    @Test
    public void testSetEmailDate() {
        System.out.println("SetEmailDate");
        Datum inputDate = null;
        Email instance = null;
        instance.SetEmailDate(inputDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetEmailDate method, of class Email.
     */
    @Test
    public void testGetEmailDate() {
        System.out.println("GetEmailDate");
        Email instance = null;
        Datum expResult = null;
        Datum result = instance.GetEmailDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PrintEmail method, of class Email.
     */
    @Test
    public void testPrintEmail() {
        System.out.println("PrintEmail");
        Email instance = null;
        instance.PrintEmail();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
