/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

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
public class AssociateTest {
    
    public AssociateTest() {
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
     * Test of SetPatronEmail method, of class Associate.
     */
    @Test
    public void testSetPatronEmail() {
        System.out.println("SetPatronEmail");
        String inputEmail = "blah@abc.net.au";
        Associate instance = new Associate();
        instance.SetPatronEmail(inputEmail);
        // TODO review the generated test code and remove the default call to fail.
        Assert.assertEquals("blah@abc.net.au", instance.GetPatronEmail());
    }

    /**
     * Test of GetPatronEmail method, of class Associate.
     */
    @Test
    public void testGetPatronEmail() {
        System.out.println("GetPatronEmail");
        String inputEmail = "blah@abc.net.au";
        Associate instance = new Associate();
        instance.SetPatronEmail(inputEmail);
        String result = instance.GetPatronEmail();
        assertEquals("blach@abc.net.au", result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
