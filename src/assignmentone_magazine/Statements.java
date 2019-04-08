/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author becky
 */

public class Statements {
    
    HashMap <String, HashMap<Integer, ArrayList<Invoice>>> billedInvoice;
    
    public Statements()
    {
        this.billedInvoice = new HashMap <String, HashMap<Integer,ArrayList<Invoice>>> ();
    }
    
    
    public void AddInvoice(Invoice inputInvoice)
    {
        // get relevant year and month
        String tempKey = Integer.toString(inputInvoice.GetInvoiceDate().getYear()) 
                            + Integer.toString(inputInvoice.GetInvoiceDate().getMonth());
        
        if(billedInvoice.get(tempKey).get(inputInvoice.GetCustomerInvoice().GetCustomerID()).hashCode() > 0)
        {
            billedInvoice.get(tempKey).get(inputInvoice.GetCustomerInvoice().GetCustomerID()).add(inputInvoice);
        }
        else
        {
            ArrayList<Invoice> tempList = new ArrayList<>();
            HashMap <Integer, ArrayList<Invoice>> tempMap = new HashMap<>();
            tempList.add(inputInvoice);
            tempMap.put(inputInvoice.GetCustomerInvoice().GetCustomerID(), tempList);
            billedInvoice.put(tempKey, tempMap);
        }
    }
    
    public void PrintStatement(String keyYearMonth)
    {
        
        HashMap <Integer, ArrayList<Invoice>> customerMap = billedInvoice.get(keyYearMonth);
        System.out.println("Invoice for Period: " + keyYearMonth.substring(0, 3) + " " + keyYearMonth.substring(3, 5));
        for(Map.Entry<Integer, ArrayList<Invoice>> customerID: customerMap.entrySet())
        {
            System.out.println("Customer: " + customerID.getValue().get(0).GetCustomerInvoice().GetFirstName()
                                + " " + customerID.getValue().get(0).GetCustomerInvoice().GetLastName());
            for(int ii = 0; ii < customerID.getValue().size(); ii += 1)
            {
                customerID.getValue().get(ii).PrintInvoice();
            }
            
        }
    }
}
