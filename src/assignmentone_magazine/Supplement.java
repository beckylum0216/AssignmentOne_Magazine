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
* <p> Child passive data structure for Supplements</p>
* @since 1.0
*/
public class Supplement extends Magazine {
    
    private String mainMagazineName;
    
    /**
    * <p> Constructor for the supplement class</p>
    * @param inputName the name of the magazine
    * @param inputCost the cost of the magazine
    * @param inputMainMagazine associated magazine
    * @since 1.0
    */
    public Supplement(String inputName, float inputCost, String inputMainMagazine)
    {
        super(inputName, inputCost);
        this.mainMagazineName = inputMainMagazine;
    }

    /**
    * <p> This is the mutator for the periodicalID. The periodical id is the magazine's 
    * id used to link the supplement to the magazine</p>
    * @param inputName the magazine ID for the main part
    * @since 1.0
    */
    public void SetMainMagazineName(String inputName)
    {
        this.mainMagazineName = inputName;
    }
    
    /**
    * <p> This is the accessor for the periodicalID. The periodical id is the magazine's 
    * id used to link the supplement to the magazine</p>
    * @return periodicalID
    * @since 1.0
    */
    public String GetMainMagazineName()
    {
        return this.mainMagazineName;
    }
        
}

