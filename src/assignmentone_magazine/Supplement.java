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
public abstract class Supplement extends Magazine {
    
    private int periodicalID;

    /**
    * <p> This is the mutator for the periodicalID. The periodical id is the magazine's 
    * id used to link the supplement to the magazine</p>
    * @param inputID the magazine ID for the main part
    * @return void
    * @see 
    * @since 1.0
    */
    public void SetPeriodicalID(int inputID)
    {
        this.periodicalID = inputID;
    }
    
    /**
    * <p> This is the accessor for the periodicalID. The periodical id is the magazine's 
    * id used to link the supplement to the magazine</p>
    * @param void
    * @return periodicalID
    * @see 
    * @since 1.0
    */
    public int GetPeriodicalID()
    {
        return this.periodicalID;
    }
        
}

