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
public class SubscriptionTest {
    
    public SubscriptionTest() {
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
     * Test of SetSubscriptionEmail method, of class Subscription.
     */
    @Test
    public void testSetSubscriptionEmail() {
        System.out.println("SetSubscriptionEmail");
        String inputSubscriptionEmail = "";
        Subscription instance = null;
        instance.SetSubscriptionEmail(inputSubscriptionEmail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetSubscriptionEmail method, of class Subscription.
     */
    @Test
    public void testGetSubscriptionEmail() {
        System.out.println("GetSubscriptionEmail");
        Subscription instance = null;
        String expResult = "";
        String result = instance.GetSubscriptionEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetSubscriptionDate method, of class Subscription.
     */
    @Test
    public void testSetSubscriptionDate() {
        System.out.println("SetSubscriptionDate");
        Datum inputDate = null;
        Subscription instance = null;
        instance.SetSubscriptionDate(inputDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetSubscriptionDate method, of class Subscription.
     */
    @Test
    public void testGetSubscriptionDate() {
        System.out.println("GetSubscriptionDate");
        Subscription instance = null;
        Datum expResult = null;
        Datum result = instance.GetSubscriptionDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetSubbedPublication method, of class Subscription.
     */
    @Test
    public void testSetSubbedPublication() {
        System.out.println("SetSubbedPublication");
        Magazine inputPublication = null;
        Subscription instance = null;
        instance.SetSubbedPublication(inputPublication);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetSubbedPublication method, of class Subscription.
     */
    @Test
    public void testGetSubbedPublication() {
        System.out.println("GetSubbedPublication");
        Subscription instance = null;
        Magazine expResult = null;
        Magazine result = instance.GetSubbedPublication();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetActiveSubscriptionTrue method, of class Subscription.
     */
    @Test
    public void testSetActiveSubscriptionTrue() {
        System.out.println("SetActiveSubscriptionTrue");
        Subscription instance = null;
        instance.SetActiveSubscriptionTrue();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetActiveSubscriptionFalse method, of class Subscription.
     */
    @Test
    public void testSetActiveSubscriptionFalse() {
        System.out.println("SetActiveSubscriptionFalse");
        Subscription instance = null;
        instance.SetActiveSubscriptionFalse();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetActiveSubscription method, of class Subscription.
     */
    @Test
    public void testGetActiveSubscription() {
        System.out.println("GetActiveSubscription");
        Subscription instance = null;
        boolean expResult = false;
        boolean result = instance.GetActiveSubscription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
