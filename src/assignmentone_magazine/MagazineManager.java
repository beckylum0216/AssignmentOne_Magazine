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
public class MagazineManager 
{
    
    HashMap <String, Magazine> magazines;
    HashMap <String, HashMap<String,Supplement>> supplements;
    
    public MagazineManager()
    {
        this.magazines = new HashMap <>();
        this.supplements = new HashMap <>();
    }
    
    
   
    
    public HashMap<String, Magazine> GetMagazines()
    {
        return this.magazines;
    }
    
    public HashMap <String, HashMap<String, Supplement>> GetSupplement()
    {
        return this.supplements;
    }
    
    /**
    * <p> This is the patron manager
    * </p>
    * @param newMagazine the new magazine to be added
    * @return void
    * @see 
    * @since 1.0
    */
    public void AddMagazine(Magazine newMagazine)
    {
        
        magazines.put(newMagazine.GetMagazineName(), newMagazine);
    }
    
    /**
    * <p> This is the associate manager
    * </p>
    * @param supplementMagazine the new associate to be added
    * @return void
    * @see 
    * @since 1.0
    */
    public void AddSupplement(Supplement supplementMagazine)
    {
        // checks if magazine exists before adding the supplement
        if(magazines.containsKey(supplementMagazine.GetMainMagazineName()))
        {
            supplements.get(supplementMagazine.GetMainMagazineName()).put(supplementMagazine.GetMagazineName(), supplementMagazine);
        }
        else
        {
            HashMap<String, Supplement> tempMap = new HashMap<>();
            tempMap.put(supplementMagazine.GetMainMagazineName(), supplementMagazine);
            supplements.put(supplementMagazine.GetMainMagazineName(),tempMap);
        }
    }
    
     /**
    * <p> This is the associate manager
    * </p>
    * @param targetMagazine the magazine to be removed
    * @return void
    * @see 
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
    * <p> This is the associate manager
    * </p>
    * @param targetSupplement the new associate to be removed
    * @return void
    * @see 
    * @since 1.0
    */
    public void RemoveOneSupplement(Supplement targetSupplement)
    {
        supplements.get(targetSupplement.GetMainMagazineName()).remove(targetSupplement.GetMagazineName());
    }
    
    /**
    * <p> This is to get a derived list of all customers</p>
    * @param 
    * @return void
    * @see 
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
    
    
    
}
