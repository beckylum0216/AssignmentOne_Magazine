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
public class InvoiceTest {
    
    public InvoiceTest() {
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
     * Test of SetInvoiceID method, of class Invoice.
     */
    @Test
    public void testSetInvoiceID() {
        System.out.println("SetInvoiceID");
        String inputID = "";
        Invoice instance = null;
        instance.SetInvoiceID(inputID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetInvoiceID method, of class Invoice.
     */
    @Test
    public void testGetInvoiceID() {
        System.out.println("GetInvoiceID");
        Invoice instance = null;
        String expResult = "";
        String result = instance.GetInvoiceID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetPatronEmail method, of class Invoice.
     */
    @Test
    public void testSetPatronEmail() {
        System.out.println("SetPatronEmail");
        String inputEmail = "";
        Invoice instance = null;
        instance.SetPatronEmail(inputEmail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetPatronEmail method, of class Invoice.
     */
    @Test
    public void testGetPatronEmail() {
        System.out.println("GetPatronEmail");
        Invoice instance = null;
        String expResult = "";
        String result = instance.GetPatronEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetCustomer method, of class Invoice.
     */
    @Test
    public void testSetCustomer() {
        System.out.println("SetCustomer");
        Customer inputCustomer = null;
        Invoice instance = null;
        instance.SetCustomer(inputCustomer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetCustomer method, of class Invoice.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("GetCustomer");
        Invoice instance = null;
        Customer expResult = null;
        Customer result = instance.GetCustomer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetSubscriptions method, of class Invoice.
     */
    @Test
    public void testSetSubscriptions() {
        System.out.println("SetSubscriptions");
        HashMap<String, Subscription> inputSubscription = null;
        Invoice instance = null;
        instance.SetSubscriptions(inputSubscription);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetSubscriptions method, of class Invoice.
     */
    @Test
    public void testGetSubscriptions() {
        System.out.println("GetSubscriptions");
        Invoice instance = null;
        HashMap<String, Subscription> expResult = null;
        HashMap<String, Subscription> result = instance.GetSubscriptions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetInvoiceDate method, of class Invoice.
     */
    @Test
    public void testSetInvoiceDate() {
        System.out.println("SetInvoiceDate");
        Datum inputDate = null;
        Invoice instance = null;
        instance.SetInvoiceDate(inputDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetInvoiceDate method, of class Invoice.
     */
    @Test
    public void testGetInvoiceDate() {
        System.out.println("GetInvoiceDate");
        Invoice instance = null;
        Datum expResult = null;
        Datum result = instance.GetInvoiceDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PrintInvoice method, of class Invoice.
     */
    @Test
    public void testPrintInvoice() {
        System.out.println("PrintInvoice");
        Invoice instance = null;
        instance.PrintInvoice();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetTotalInvoice method, of class Invoice.
     */
    @Test
    public void testGetTotalInvoice() {
        System.out.println("GetTotalInvoice");
        Invoice instance = null;
        float expResult = 0.0F;
        float result = instance.GetTotalInvoice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
