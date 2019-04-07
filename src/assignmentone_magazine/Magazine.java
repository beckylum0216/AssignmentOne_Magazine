/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

/**
 *
 * @author becky
 */
public abstract class Magazine 
{
    private int magazineID;
    private String magazineName;
    private float magazineCost;
    
    public void SetMagazineID(int inputID)
    {
        this.magazineID = inputID;
    }
    
    public int GetMagazineID()
    {
        return this.magazineID;
    }
    
    public void SetMagazineName(String inputName)
    {
        this.magazineName = inputName;
    }
    
    public String GetMagazineName()
    {
        return this.magazineName;
    }
    
    public void SetMagazineCost(float inputCost)
    {
        this.magazineCost = inputCost;
    }
    
    public float GetMagazineCost()
    {
        return this.magazineCost;
    }
    
    
    
    
    
}
