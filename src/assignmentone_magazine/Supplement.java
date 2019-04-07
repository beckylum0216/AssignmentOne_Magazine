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
       
        public void SetPeriodicalID(int inputID)
        {
            this.periodicalID = inputID;
        }
        
        public int GetPeriodicalID()
        {
            return this.periodicalID;
        }
        
}

