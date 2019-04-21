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
public class DatumTest {
    
    public DatumTest() {
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
     * Test of getDay method, of class Datum.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        Datum instance = new Datum();
        int expResult = 0;
        int result = instance.getDay();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDay method, of class Datum.
     */
    @Test
    public void testSetDay() {
        System.out.println("setDay");
        int day = 0;
        Datum instance = new Datum();
        instance.setDay(day);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonth method, of class Datum.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        Datum instance = new Datum();
        int expResult = 0;
        int result = instance.getMonth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMonth method, of class Datum.
     */
    @Test
    public void testSetMonth() {
        System.out.println("setMonth");
        int month = 0;
        Datum instance = new Datum();
        instance.setMonth(month);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getYear method, of class Datum.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Datum instance = new Datum();
        int expResult = 0;
        int result = instance.getYear();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setYear method, of class Datum.
     */
    @Test
    public void testSetYear() {
        System.out.println("setYear");
        int year = 0;
        Datum instance = new Datum();
        instance.setYear(year);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEqual method, of class Datum.
     */
    @Test
    public void testIsEqual() {
        System.out.println("isEqual");
        Datum inputDate = null;
        Datum instance = new Datum();
        boolean expResult = false;
        boolean result = instance.isEqual(inputDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidDate method, of class Datum.
     */
    @Test
    public void testIsValidDate() {
        System.out.println("isValidDate");
        Datum instance = new Datum();
        boolean expResult = false;
        boolean result = instance.isValidDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class Datum.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Datum instance = new Datum();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Datum.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Datum instance = new Datum();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
