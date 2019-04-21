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
public class SupplementTest {
    
    public SupplementTest() {
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
     * Test of SetMainMagazineName method, of class Supplement.
     */
    @Test
    public void testSetMainMagazineName() {
        System.out.println("SetMainMagazineName");
        String inputName = "";
        Supplement instance = null;
        instance.SetMainMagazineName(inputName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetMainMagazineName method, of class Supplement.
     */
    @Test
    public void testGetMainMagazineName() {
        System.out.println("GetMainMagazineName");
        Supplement instance = null;
        String expResult = "";
        String result = instance.GetMainMagazineName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
