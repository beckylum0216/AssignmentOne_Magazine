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
public class Supplement extends Magazine {
    
    private String mainMagazineName;
    
    public Supplement(String inputName, float inputCost, String inputMainMagazine)
    {
        super(inputName, inputCost);
        this.mainMagazineName = inputMainMagazine;
    }

    /**
    * <p> This is the mutator for the periodicalID. The periodical id is the magazine's 
    * id used to link the supplement to the magazine</p>
    * @param inputID the magazine ID for the main part
    * @return void
    * @see 
    * @since 1.0
    */
    public void SetMainMagazineName(String inputName)
    {
        this.mainMagazineName = inputName;
    }
    
    /**
    * <p> This is the accessor for the periodicalID. The periodical id is the magazine's 
    * id used to link the supplement to the magazine</p>
    * @param void
    * @return periodicalID
    * @see 
    * @since 1.0
    */
    public String GetMainMagazineName()
    {
        return this.mainMagazineName;
    }
        
}

