/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author becky
 */
public class AssignmentOne_Magazine {
    ServiceManager magazineService = new ServiceManager();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
    }
    
    public void UploadCustomers()
    {
        Utility ut = new Utility();
        String filePath = "CustomerList.txt";
        List<List<String>> tempList = ut.CSVFileReader(filePath);
        
        for(int ii = 0; ii < tempList.size(); ii += 1)
        {
            if(tempList.get(ii).get(4) == null)
            {
                Customer tempCustomer = new Customer(tempList.get(ii).get(0), 
                                                    tempList.get(ii).get(1),
                                                    tempList.get(ii).get(2),
                                                    tempList.get(ii).get(3));
                
                magazineService.GetCustomerList().AddPatron(tempCustomer);
            }
            else
            {
                Associate tempAssociate = new Associate(tempList.get(ii).get(0), 
                                                    tempList.get(ii).get(1),
                                                    tempList.get(ii).get(2),
                                                    tempList.get(ii).get(3),
                                                    tempList.get(ii).get(4));
                
                magazineService.GetCustomerList().AddAssociate(tempAssociate);
            }
            
        }
        
    }
    
    public void UploadMagazines()
    {
        
    }
    
    
    
    
}
