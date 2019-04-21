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
    public void test000CreateMagazineManager()
    {
        MagazineManager testMagazine = new MagazineManager();
    }
    
    /**
     * Test of AddMagazine method, of class MagazineManager.
     */
    @Test
    public void test001AddMagazine() {
        System.out.println("AddMagazine");
        MagazineManager instance = new MagazineManager();
        
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.AddMagazine(testMagazine);
        // TODO review the generated test code and remove the default call to fail.
        Assert.assertEquals("blah weekly", instance.GetMagazines().get(testMagazine.GetMagazineName()).GetMagazineName());
    }
    
    /**
     * Test of AddMagazine method, of class MagazineManager.
     */
    @Test (expected = IllegalArgumentException.class)
    public void test002AddMagazine() {
        System.out.println("AddMagazine");
        MagazineManager instance = new MagazineManager();
        
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.AddMagazine(testMagazine);
        instance.AddMagazine(testMagazine);
        
        Assert.assertEquals("blah weekly", instance.GetMagazines().get(testMagazine.GetMagazineName()).GetMagazineName());
    }
    
    /**
     * Test of GetMagazines method, of class MagazineManager.
     */
    @Test
    public void test003GetMagazines() {
        System.out.println("GetMagazines");
        MagazineManager instance = new MagazineManager();
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.AddMagazine(testMagazine);
       
        assertEquals("blah weekly", instance.magazines.get("blah weekly").GetMagazineName());
        
    }
    
    /**
     * Test of GetMagazines method, of class MagazineManager.
     */
    @Test (expected = NullPointerException.class)
    public void test004GetMagazines() {
        System.out.println("GetMagazines");
        MagazineManager instance = new MagazineManager();
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.AddMagazine(testMagazine);
       
        assertEquals("bleach weekly", instance.magazines.get("bleach weekly").GetMagazineName());
        
    }
    
    /**
     * Test of AddSupplement method, of class MagazineManager.
     */
    @Test (expected = IllegalArgumentException.class)
    public void test005AddSupplement() {
        System.out.println("AddSupplement");
        MagazineManager instance = new MagazineManager();
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        //instance.AddMagazine(testMagazine);
        
        Supplement testSupplement = new Supplement("blah supplement", 13.00f, "blah weekly");
        instance.AddSupplement(testSupplement);
        
        assertEquals("blah supplement", instance.GetSupplement().get("blah weekly").get("blah supplement").GetMagazineName());
    }
    
    /**
     * Test of AddSupplement method, of class MagazineManager.
     */
    @Test 
    public void test006AddSupplement() {
        System.out.println("AddSupplement");
        MagazineManager instance = new MagazineManager();
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.AddMagazine(testMagazine);
        
        Supplement testSupplement = new Supplement("blah supplement", 13.00f, "blah weekly");
        instance.AddSupplement(testSupplement);
        
        assertEquals("blah supplement", instance.GetSupplement().get("blah weekly").get("blah supplement").GetMagazineName());
    }
    
    /**
     * Test of AddSupplement method, of class MagazineManager.
     */
    @Test (expected = IllegalArgumentException.class)
    public void test007AddSupplement() {
        System.out.println("AddSupplement");
        MagazineManager instance = new MagazineManager();
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.AddMagazine(testMagazine);
        
        Supplement testSupplement = new Supplement("blah supplement", 13.00f, "blah weekly");
        instance.AddSupplement(testSupplement);
        instance.AddSupplement(testSupplement);
        
        assertEquals("blah supplement", instance.GetSupplement().get("blah weekly").get("blah supplement").GetMagazineName());
    }
    
    /**
     * Test of RemoveMagazine method, of class MagazineManager.
     */
    @Test 
    public void test008RemoveMagazine() {
        System.out.println("RemoveMagazine");
        MagazineManager instance = new MagazineManager();
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.AddMagazine(testMagazine);
        
        instance.RemoveMagazine(testMagazine);
       
        
    }
    
    /**
     * Test of RemoveMagazine method, of class MagazineManager.
     */
    @Test (expected = IllegalArgumentException.class)
    public void test009RemoveMagazine() {
        System.out.println("RemoveMagazine");
        MagazineManager instance = new MagazineManager();
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        //instance.AddMagazine(testMagazine);
        
        instance.RemoveMagazine(testMagazine);
        
        
    }
    
    /**
     * Test of RemoveOneSupplement method, of class MagazineManager.
     */
    @Test
    public void test010RemoveOneSupplement() {
        System.out.println("RemoveOneSupplement");
        MagazineManager instance = new MagazineManager();
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.AddMagazine(testMagazine);
        
        Supplement testSupplement = new Supplement("blah supplement", 13.00f, "blah weekly");
        instance.AddSupplement(testSupplement);
        instance.RemoveOneSupplement(testSupplement);
        
    }
    
    /**
     * Test of RemoveOneSupplement method, of class MagazineManager.
     */
    @Test (expected = IllegalArgumentException.class)
    public void test011RemoveOneSupplement() {
        System.out.println("RemoveOneSupplement");
        MagazineManager instance = new MagazineManager();
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.AddMagazine(testMagazine);
        
        Supplement testSupplement = new Supplement("blah supplement", 13.00f, "blah weekly");
        instance.AddSupplement(testSupplement);
        instance.RemoveOneSupplement(testSupplement);
        instance.RemoveOneSupplement(testSupplement);
        
    }
    
    /**
     * Test of GetSupplement method, of class MagazineManager.
     */
    @Test
    public void test012GetSupplement() {
        System.out.println("GetSupplement");
        MagazineManager instance = new MagazineManager();
        
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.AddMagazine(testMagazine);
        
        Supplement testSupplement = new Supplement("blah supplement", 13.00f, "blah weekly");
        instance.AddSupplement(testSupplement);
        
        assertEquals("blah supplement", instance.GetSupplement().get("blah weekly").get("blah supplement").GetMagazineName());
        
    }

    @Test (expected = NullPointerException.class)
    public void test013GetSupplement() {
        System.out.println("GetSupplement");
        MagazineManager instance = new MagazineManager();
        
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.AddMagazine(testMagazine);
        
        Supplement testSupplement = new Supplement("blah supplement", 13.00f, "blah weekly");
        //instance.AddSupplement(testSupplement);
        
        assertEquals("blah supplement", instance.GetSupplement().get("blah weekly").get("blah supplement").GetMagazineName());
        
    }
    
    
    /**
     * Test of GetAllPublicationList method, of class MagazineManager.
     */
    @Test
    public void test014GetAllPublicationList() {
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
    public void test015PrintMagazines() {
        System.out.println("PrintMagazines");
        MagazineManager instance = new MagazineManager();
        Magazine testMagazine = new Magazine("blah weekly", 13.00f);
        instance.AddMagazine(testMagazine);
        
        Supplement testSupplement = new Supplement("blah supplement", 13.00f, "blah weekly");
        instance.AddSupplement(testSupplement);
        instance.PrintMagazines();
        
    }
    
}
