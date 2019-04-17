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
public class Magazine 
{
    private String magazineName;
    private float magazineCost;
    
    public Magazine(String inputName, float inputCost)
    {
        this.magazineName = inputName;
        this.magazineCost = inputCost;
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
        if(inputCost <= 0)
        {
            throw new IllegalArgumentException("Cost cannot be less than zero or zero");
        }
        else
        {
            this.magazineCost = inputCost;
        }
        
    }
    
    public float GetMagazineCost()
    {
        return this.magazineCost;
    }
    
    
    
    
    
}
