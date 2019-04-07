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
public abstract class Customer {
    
    public enum customerType{associate, customer};
    private int magazineID;
    private String firstName;
    private String lastName;
    private String emailAddress;
    
    public void SetCustomerID(int inputID)
    {
        this.magazineID = inputID;
    }
    
    public int GetCustomerID()
    {
        return this.magazineID;
    }
    
    public void SetFirstName(String inputFirstName)
    {
        this.firstName = inputFirstName;
    }
    
    public String GetFirstName()
    {
        return this.firstName;
    }
    
    public void SetLastName(String inputLastName)
    {
        this.lastName = inputLastName;
    }
    
    public String GetLastName()
    {
        return this.lastName;
    }
    
    public void SetEmailAddress(String inputEmail)
    {
        this.emailAddress = inputEmail;
    }
    
    public String GetEmailAddress()
    {
        return this.emailAddress;
    }
    
    
}
