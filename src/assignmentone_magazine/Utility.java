/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author becky
 */
public class Utility {
    
    public List<List<String>> CSVFileReader(String filePath)
    {
        List<List<String>> customerRecords = new ArrayList<>();
        try 
        {
            FileReader targetFile = new FileReader(filePath);
            BufferedReader br = new BufferedReader(targetFile);
            
            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] values = line.split(",");
                customerRecords.add(Arrays.asList(values));
                
            }
            
            targetFile.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        
        
        
        return customerRecords;
    }
    
}
