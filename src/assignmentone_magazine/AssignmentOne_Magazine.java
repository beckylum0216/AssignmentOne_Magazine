/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author becky
 */
public class AssignmentOne_Magazine {
    static ServiceManager magazineService = new ServiceManager();
    static Scanner theKB = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean theFlag = true;
       
        int theChoice;
       
        do
        {
            try
            {
                Menu();
                theChoice = Integer.parseInt(theKB.nextLine());
                System.out.println();
                switch (theChoice)
                {

                    case 1:
                        theFlag = exitProg();
                        break;
                    case 2:
                        UploadCustomers();
                        break;
                    case 3:
                        UploadMagazines();
                        break;
                    case 4:
                        UploadSubscription();
                        break;
                    case 5:
                        PrintCorrespondence();
                        break;
                    case 6:
                        PrintInvoices();
                        break;
                    case 7:
                        RemoveCustomers();
                        break;
                    case 8:
                        PrintCustomerList();
                        break;
                    case 9:
                        PrintMagazineList();
                        break;
                    case 10:
                        PrintSubscriptionList();
                        break;
                    
                     
                    default:
                        System.out.println("Please enter a valid choice");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
                theFlag = true;
            }
                
        }while(theFlag);
        
        System.out.println("Exiting...");
        
    }
    
    public static void Menu()
    {
        System.out.println("Menu");
        System.out.println("==============================================");
        System.out.println("1: Quit.");
        System.out.println("2: Press 2 to add customer data.");
        System.out.println("3: Press 3 to add magazine data.");
        System.out.println("4: Press 4 to add subscription data");
        System.out.println("5: Press 5 to print subscription emails");
        System.out.println("6: Press 6 to print monthly invoice emails");
        System.out.println("7: Press 7 to remove customer");
        System.out.println("8: Press 8 to print customer list.");
        System.out.println("9: Press 9 to print magazine list.");
        System.out.println("10: Press 10 to print subscription list.");
        
    }
    
    public static void UploadCustomers()
    {
        Utility ut = new Utility();
        String filePath = "src/assignmentOne_magazine/CustomerList.txt";
        List<List<String>> tempList = ut.CSVFileReader(filePath);
        
        for(int ii = 0; ii < tempList.size(); ii += 1)
        {
            
            if(tempList.get(ii).size() == 4)
            {
                Customer tempCustomer = new Customer(tempList.get(ii).get(0), 
                                                    tempList.get(ii).get(1),
                                                    tempList.get(ii).get(2),
                                                    tempList.get(ii).get(3));
                
                magazineService.GetCustomerList().AddPatron(tempCustomer);
            }
            else
            {
                System.out.println("tempList element:" + tempList.get(ii).get(4));
                Associate tempAssociate = new Associate(tempList.get(ii).get(0), 
                                                    tempList.get(ii).get(1),
                                                    tempList.get(ii).get(2),
                                                    tempList.get(ii).get(3),
                                                    tempList.get(ii).get(4));
                
                magazineService.GetCustomerList().AddAssociate(tempAssociate);
            }
            
        }
        
    }
    
    public static void PrintCustomerList()
    {
        magazineService.GetCustomerList().PrintCustomers();
    }
    
    public static void UploadMagazines()
    {
        Utility ut = new Utility();
        String filePath = "src/assignmentOne_magazine/MagazineList.txt";
        List<List<String>> tempList = ut.CSVFileReader(filePath);
        
        for(int ii = 0; ii < tempList.size(); ii += 1)
        {
            System.out.println("tempList: "+ tempList.get(ii).size());
            if(tempList.get(ii).size() == 2 )
            {
                Magazine tempMagazine = new Magazine(tempList.get(ii).get(0), 
                                                    Float.parseFloat(tempList.get(ii).get(1)));
                
                magazineService.GetMagazineList().AddMagazine(tempMagazine);
            }
            else
            {
                Supplement tempSupplement = new Supplement(tempList.get(ii).get(0), 
                                                    Float.parseFloat(tempList.get(ii).get(1)),
                                                    tempList.get(ii).get(2));
                
                magazineService.GetMagazineList().AddSupplement(tempSupplement);
            }
            
        }
    }
    
    public static void PrintMagazineList()
    {
        magazineService.GetMagazineList().PrintMagazines();
    }
    
    
    public static void UploadSubscription()
    {
        Utility ut = new Utility();
        String filePath = "src/assignmentOne_magazine/SubscriptionList.txt";
        List<List<String>> tempList = ut.CSVFileReader(filePath);
        
        System.out.println(tempList.size());
        for(int ii = 0; ii < tempList.size(); ii += 1)
        {
            
            if(magazineService.GetMagazineList().GetAllPublicationList().containsKey(tempList.get(ii).get(2)))
            {
                try{
                    Magazine subbedMagazine = magazineService.GetMagazineList().GetAllPublicationList().get(tempList.get(ii).get(2));
                
                    String[] subbedDate = tempList.get(ii).get(1).split("/");
                    Datum subbedDatum = new Datum(Integer.parseInt(subbedDate[0]),
                                                    Integer.parseInt(subbedDate[1]),
                                                        Integer.parseInt(subbedDate[2]));
                    Subscription newSubscription = new Subscription(tempList.get(ii).get(0),
                                                                        subbedDatum,
                                                                        subbedMagazine, 
                                                                        Boolean.parseBoolean(tempList.get(ii).get(3)));
                    magazineService.AddSubscription(newSubscription);
                }
                catch(IllegalArgumentException e)
                {
                    System.out.println(e);
                }
            }
            else
            {
                throw new IllegalArgumentException("Magazine does not exist!");
            }
            
            
        }
    }
    
    public static void PrintSubscriptionList()
    {
        magazineService.PrintSubscription();
    }
    
    public static void PrintInvoices()
    {
        magazineService.InvoiceCustomers();
        magazineService.PrintStatements();
    }
    
    public static void PrintCorrespondence()
    {
        magazineService.EmailCustomers();
        magazineService.PrintEmails();
    }
    
    public static void RemoveCustomers()
    {
        Utility ut = new Utility();
        String filePath = "src/assignmentOne_magazine/DeleteCustomerList.txt";
        List<List<String>> tempList = ut.CSVFileReader(filePath);
        
        for(int ii = 0; ii < tempList.size(); ii += 1)
        {
            
            if(tempList.get(ii).size() == 4)
            {
                Customer tempCustomer = new Customer(tempList.get(ii).get(0), 
                                                    tempList.get(ii).get(1),
                                                    tempList.get(ii).get(2),
                                                    tempList.get(ii).get(3));
                
                magazineService.GetCustomerList().RemovePatron(tempCustomer);
            }
            else
            {
                System.out.println("tempList element:" + tempList.get(ii).get(4));
                Associate tempAssociate = new Associate(tempList.get(ii).get(0), 
                                                    tempList.get(ii).get(1),
                                                    tempList.get(ii).get(2),
                                                    tempList.get(ii).get(3),
                                                    tempList.get(ii).get(4));
                
                magazineService.GetCustomerList().RemoveAssociate(tempAssociate);
            }
            
        }
    }
    
    /**
     * <p>This method allows the user to exit the program.</p>
     * @return theFlag boolean of state of program on exit
     */
    public static boolean exitProg()
    {
        Scanner theKB = new Scanner(System.in);
        char theResponse;
        boolean theCheck = true;
        boolean theFlag = true;
        do
        {
            System.out.println("Would you like to continue");
            theResponse = theKB.nextLine().toLowerCase().charAt(0);
            if(theResponse == 'y')
            {
                theCheck = false;
                theFlag = true;
            }
            else if(theResponse == 'n')
            {
                theCheck = false;
                theFlag = false;
            }
            else
            {
                System.out.println("Please enter the Y/N only");
                theCheck = true;
            }
                
        }while(theCheck);
        
        return theFlag;
    }
    
    
}
