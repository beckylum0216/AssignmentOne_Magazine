/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author becky
 */
public class Subscription {
    private int subscriptionID;
    HashMap <Integer, Magazine> allMagazines;
    HashMap <Integer, Magazine> magazines;
    HashMap <Integer, ArrayList<Supplement>> supplements;
    
    public Subscription()
    {
        this.allMagazines = new HashMap<>();
        this.magazines = new HashMap <>();
        this.supplements = new HashMap <>();
    }
    
    public void SetSubscriptionID(int inputSubID)
    {
        this.subscriptionID = inputSubID;
    }
    
    public int GetSubscriptionID()
    {
        return this.subscriptionID;
    }
    
    public HashMap<Integer, Magazine> GetAllMagazines()
    {
        return this.allMagazines;
    }
    
    public HashMap<Integer, Magazine> GetMagazines()
    {
        return this.magazines;
    }
    
    public HashMap <Integer, ArrayList<Supplement>> GetSupplement()
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
        allMagazines.put(newMagazine.GetMagazineID(), newMagazine);
        magazines.put(newMagazine.GetMagazineID(), newMagazine);
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
        if(magazines.get(supplementMagazine.GetPeriodicalID()).hashCode() > 0)
        {
            allMagazines.put(supplementMagazine.GetMagazineID(), supplementMagazine);
            supplements.get(supplementMagazine.GetPeriodicalID()).add(supplementMagazine);
        }
        else
        {
            allMagazines.put(supplementMagazine.GetMagazineID(), supplementMagazine);
            ArrayList <Supplement> tempList = new ArrayList<>();
            tempList.add(supplementMagazine);
            supplements.put(supplementMagazine.GetPeriodicalID(), tempList);
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
        if(supplements.get(targetMagazine.GetMagazineID()).hashCode() > 0)
        {
            magazines.remove(targetMagazine.GetMagazineID());
            allMagazines.remove(targetMagazine.GetMagazineID());
            supplements.remove(targetMagazine.GetMagazineID());
        }
        else
        {
            magazines.remove(targetMagazine.GetMagazineID());
            allMagazines.remove(targetMagazine.GetMagazineID());
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
    public void RemoveSupplement(Supplement targetSupplement)
    {
        supplements.get(targetSupplement.GetPeriodicalID()).remove(targetSupplement.GetMagazineID());
    }
    
    
    
}
