/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author becky
 */

/**
* <p> This is the customer manager</p>
* @since 1.0
*/
public class MagazineManager 
{
    
    HashMap <String, Magazine> magazines;
    HashMap <String, HashMap<String,Supplement>> supplements;
    
    /**
    * <p> This is the magazine manager constructor</p>
    * @since 1.0
    */
    public MagazineManager()
    {
        this.magazines = new HashMap <>();
        this.supplements = new HashMap <>();
    }
    
    /**
    * <p> This is the accessor for the magazine list</p>
    * @return magazines list of magazines
    * @since 1.0
    */
    public HashMap<String, Magazine> GetMagazines()
    {
        return this.magazines;
    }
    
    /**
    * <p> This is the accessor for the supplement list</p>
    * @return supplements supplement lists
    * @since 1.0
    */
    public HashMap <String, HashMap<String, Supplement>> GetSupplement()
    {
        return this.supplements;
    }
    
    /**
    * <p> This is the magazine manager
    * </p>
    * @param newMagazine the new magazine to be added
    * @since 1.0
    */
    public void AddMagazine(Magazine newMagazine)
    {
        if(!magazines.containsKey(newMagazine.GetMagazineName()))
        {
            magazines.put(newMagazine.GetMagazineName(), newMagazine);
        }
        else
        {
            throw new IllegalArgumentException("Record already exists!");
        }
        
    }
    
    /**
    * <p> This is the supplement manager
    * </p>
    * @param supplementMagazine the new associate to be added
    * @since 1.0
    */
    public void AddSupplement(Supplement supplementMagazine)
    {
        // checks if magazine exists before adding the supplement
        if(magazines.containsKey(supplementMagazine.GetMainMagazineName()))
        {
            if(supplements.containsKey(supplementMagazine.GetMainMagazineName()))
            {
                supplements.get(supplementMagazine.GetMainMagazineName()).put(supplementMagazine.GetMagazineName(), supplementMagazine);
            }
            else
            {
                HashMap<String, Supplement> tempMap = new HashMap<>();
                tempMap.put(supplementMagazine.GetMagazineName(), supplementMagazine);
                supplements.put(supplementMagazine.GetMainMagazineName(),tempMap);
            }
            
        }
        else
        {
            throw new IllegalArgumentException("Magazine must exist before adding supplement!");
        }
    }
    
     /**
    * <p> This removes magazines
    * </p>
    * @param targetMagazine the magazine to be removed
    * @since 1.0
    */
    public void RemoveMagazine(Magazine targetMagazine)
    {
        // if the magazine is removed the supplement is removed too  cascase delete
        if(supplements.containsKey(targetMagazine.GetMagazineName()))
        {
            throw new IllegalArgumentException("You must delete supplements before deleting main magazine!");
        }
        else
        {
            magazines.remove(targetMagazine.GetMagazineName());
            
        }
        
    }
    
    /**
    * <p> This removes supplements 
    * </p>
    * @param targetSupplement the supplement to be removed
    * @since 1.0
    */
    public void RemoveOneSupplement(Supplement targetSupplement)
    {
        supplements.get(targetSupplement.GetMainMagazineName()).remove(targetSupplement.GetMagazineName());
    }
    
    /**
    * <p> This is to get a derived list of all customers</p> 
    * @since 1.0
    */
    public HashMap<String, Magazine> GetAllPublicationList()
    {
        HashMap<String, Magazine> resultList = new HashMap<>();
        
        resultList.putAll(magazines);
        
        for (Map.Entry pair : this.supplements.entrySet()) {
            HashMap<String, Magazine> supplement = (HashMap<String, Magazine>) pair.getValue();
            resultList.putAll(supplement);
        }
        
        return resultList;
    }
    
    /**
    * <p> This is a utility function to print the derived list of all magazines</p>
    * @since 1.0
    */
    public void PrintMagazines()
    {
        HashMap<String, Magazine> printList = this.GetAllPublicationList();
        
        for(Map.Entry pair: printList.entrySet())
        {
            String currentKey = (String) pair.getKey();
            Magazine currentMagazine = (Magazine) pair.getValue();
            System.out.println("Record Key:" + currentKey);
            System.out.println("Name: " + currentMagazine.GetMagazineName());
            System.out.println("Cost:" + currentMagazine.GetMagazineCost());
        }
    }
    
    
    
}
