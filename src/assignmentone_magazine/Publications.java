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

public class Publications {
    
    HashMap <Integer, Magazine> allMagazines = new HashMap<>();
    HashMap <Integer, Magazine> magazines = new HashMap <>();
    HashMap <Integer, ArrayList<Supplement>> supplements = new HashMap <> ();
    
    public void AddMagazine(Magazine newMagazine)
    {
        allMagazines.put(newMagazine.GetMagazineID(), newMagazine);
        magazines.put(newMagazine.GetMagazineID(), newMagazine);
    }
    
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
    
    public void RemoveSupplement(Supplement targetSupplement)
    {
        supplements.get(targetSupplement.GetPeriodicalID()).remove(targetSupplement.GetMagazineID());
    }
    
}
