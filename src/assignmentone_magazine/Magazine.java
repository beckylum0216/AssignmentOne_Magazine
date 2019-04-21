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

/**
* <p> Parent passive data structure for Magazines</p>
* @since 1.0
*/
public class Magazine 
{
    private String magazineName;
    private float magazineCost;
    
    /**
    * <p> Constructor for the magazine class</p>
    * @param inputName the name of the magazine
    * @param inputCost the cost of the magazine
    * @since 1.0
    */
    public Magazine(String inputName, float inputCost)
    {
        this.magazineName = inputName;
        this.magazineCost = inputCost;
    }
    
    /**
    * <p> This is the mutator for the magazine name. The name is assumed to be unique</p>
    * @param inputName unique magazine name
    * @since 1.0
    */
    public void SetMagazineName(String inputName)
    {
        this.magazineName = inputName;
    }
    
    /**
    * <p> This is the accessor for the magazine name. The name is assumed to be unique</p>
    * @return magazineName retrieved unique magazine name
    * @since 1.0
    */
    public String GetMagazineName()
    {
        return this.magazineName;
    }
    
    
    /**
    * <p> This is the mutator for the magazine cost. </p>
    * @param inputCost cost of the magazine. cannot be less than zero
    * @since 1.0
    */
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
    
    /**
    * <p> This is the accessor for the magazine cost.</p>
    * @return magazineCost cannot be zero
    * @since 1.0
    */
    public float GetMagazineCost()
    {
        return this.magazineCost;
    }
    
    
    
    
    
}
