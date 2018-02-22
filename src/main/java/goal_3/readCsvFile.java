/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package goal_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Dinesh
 */
public class readCsvFile {
 public void read()  {

        String csvFile = "src/main/java/ipl1.csv";
   
        String line = "";
        String[] columnName={};
        String[] columnData={};
        int i;
        ArrayList<String> lines = new ArrayList<>();
      //  LinkedHashMap<String, ArrayList<Object>> fileMap=new LinkedHashMap<String, ArrayList<Object>>();
        i=0;
        try  {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null)
             {
            //	System.out.println(line);
             	lines.add(line);
             	
             }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        columnName= lines.get(0).split(",");
 		System.out.print("Columns:");
          for(String val:columnName) {
               System.out.print(val+" | ");
          	//	System.out.println("");

          }
          System.out.println("");
        columnData= lines.get(1).split(",");
        System.out.print("ColType:");
        i=0;
        
          for(String val:columnData){
              boolean checkInt=Pattern.compile("\\d+",Pattern.CASE_INSENSITIVE).matcher(val).matches();
              if(checkInt){
                   System.out.print(columnName[i]+" (Int) | ");
              }
              boolean checkDate=Pattern.compile("\\d{4}\\-\\d{2}\\-\\d{2}",Pattern.CASE_INSENSITIVE).matcher(val).matches();
              if(checkDate){
                   System.out.print(columnName[i]+" (Date) | ");
              }
              boolean checkString=Pattern.compile("\\D+",Pattern.CASE_INSENSITIVE).matcher(val).matches();
              if(checkString){
                   System.out.print(columnName[i]+" (String) | ");
              }
              i++;
          }
 
    }
}
