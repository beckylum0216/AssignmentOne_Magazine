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
public class Associate extends Customer 
{    
    private int patronID;
    
    /**
    * <p> This is the setter for the patronID. The patron id is the customer's 
    * id used to link the associate to the customer account</p>
    * @param inputID the inputID;
    * @return void
    * @see 
    * @since 1.0
    */
    public void SetPatronID(int inputID)
    {
        this.patronID = inputID;
    }
    
    /**
    * <p> This is the getter for the patronID. The patron id is the customer's 
    * id used to link the associate to the customer account</p>
    * @param void
    * @return void
    * @see 
    * @since 1.0
    */
    public int GetPatronID()
    {
        return this.patronID;
    }
}
