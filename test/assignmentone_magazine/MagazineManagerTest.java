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
import org.testng.Assert;

/**
 *
 * @author becky
 */
public class MagazineManagerTest {
    
    public MagazineManagerTest() {
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
     * Test of GetMagazines method, of class MagazineManager.
     */
    @Test
    public void testGetMagazines() {
        System.out.println("GetMagazines");
        MagazineManager instance = new MagazineManager();
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.AddMagazine(testMagazine);
       
        assertEquals("blah weekly", instance.magazines.get("blah weekly").GetMagazineName());
        
    }

    /**
     * Test of GetSupplement method, of class MagazineManager.
     */
    @Test
    public void testGetSupplement() {
        System.out.println("GetSupplement");
        MagazineManager instance = new MagazineManager();
        
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.AddMagazine(testMagazine);
        
        Supplement testSupplement = new Supplement("blah supplement", 13.00f, "blah weekly");
        instance.AddSupplement(testSupplement);
        
        assertEquals("blah supplement", instance.GetSupplement().get("blah weekly").get("blah supplement").GetMagazineName());
        
    }

    /**
     * Test of AddMagazine method, of class MagazineManager.
     */
    @Test
    public void testAddMagazine() {
        System.out.println("AddMagazine");
        MagazineManager instance = new MagazineManager();
        
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.AddMagazine(testMagazine);
        // TODO review the generated test code and remove the default call to fail.
        Assert.assertEquals("blah weekly", instance.GetMagazines().get(testMagazine.GetMagazineName()).GetMagazineName());
    }

    /**
     * Test of AddSupplement method, of class MagazineManager.
     */
    @Test
    public void testAddSupplement() {
        System.out.println("AddSupplement");
        MagazineManager instance = new MagazineManager();
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.AddMagazine(testMagazine);
        
        Supplement testSupplement = new Supplement("blah supplement", 13.00f, "blah weekly");
        instance.AddSupplement(testSupplement);
        
        assertEquals("blah supplement", instance.GetSupplement().get("blah weekly").get("blah supplement").GetMagazineName());
    }

    /**
     * Test of RemoveMagazine method, of class MagazineManager.
     */
    @Test
    public void testRemoveMagazine() {
        System.out.println("RemoveMagazine");
        MagazineManager instance = new MagazineManager();
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.AddMagazine(testMagazine);
        
        instance.RemoveMagazine(testMagazine);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of RemoveOneSupplement method, of class MagazineManager.
     */
    @Test
    public void testRemoveOneSupplement() {
        System.out.println("RemoveOneSupplement");
        MagazineManager instance = new MagazineManager();
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.AddMagazine(testMagazine);
        
        Supplement testSupplement = new Supplement("blah supplement", 13.00f, "blah weekly");
        instance.AddSupplement(testSupplement);
        instance.RemoveOneSupplement(testSupplement);
        
    }

    /**
     * Test of GetAllPublicationList method, of class MagazineManager.
     */
    @Test
    public void testGetAllPublicationList() {
        System.out.println("GetAllPublicationList");
        MagazineManager instance = new MagazineManager();
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.AddMagazine(testMagazine);
        
        Supplement testSupplement = new Supplement("blah supplement", 13.00f, "blah weekly");
        instance.AddSupplement(testSupplement);
        
        instance.GetAllPublicationList();
    }

    /**
     * Test of PrintMagazines method, of class MagazineManager.
     */
    @Test
    public void testPrintMagazines() {
        System.out.println("PrintMagazines");
        MagazineManager instance = new MagazineManager();
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.AddMagazine(testMagazine);
        
        Supplement testSupplement = new Supplement("blah supplement", 13.00f, "blah weekly");
        instance.AddSupplement(testSupplement);
        instance.PrintMagazines();
        
    }
    
}
