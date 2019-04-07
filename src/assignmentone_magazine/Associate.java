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
        
    public void SetPatronID(int inputID)
    {
        this.patronID = inputID;
    }

    public int GetPatronID()
    {
        return this.patronID;
    }
}
