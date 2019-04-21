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
public class MagazineTest {
    
    public MagazineTest() {
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
     * Test of SetMagazineName method, of class Magazine.
     */
    @Test
    public void testSetMagazineName() {
        System.out.println("SetMagazineName");
        String inputName = "";
        Magazine instance = null;
        instance.SetMagazineName(inputName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetMagazineName method, of class Magazine.
     */
    @Test
    public void testGetMagazineName() {
        System.out.println("GetMagazineName");
        Magazine instance = null;
        String expResult = "";
        String result = instance.GetMagazineName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetMagazineCost method, of class Magazine.
     */
    @Test
    public void testSetMagazineCost() {
        System.out.println("SetMagazineCost");
        float inputCost = 0.0F;
        Magazine instance = null;
        instance.SetMagazineCost(inputCost);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetMagazineCost method, of class Magazine.
     */
    @Test
    public void testGetMagazineCost() {
        System.out.println("GetMagazineCost");
        Magazine instance = null;
        float expResult = 0.0F;
        float result = instance.GetMagazineCost();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
