/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package goal_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Dinesh
 */
public class readCsvFile {
 public static void main(String[] args) {

        String csvFile = "C:///Users/Dinesh/Documents/NetBeansProjects/ipl.csv";
        String line = "";
        String[] columnName={};
        String[] columnData={};
        int num;
int i=0;
ArrayList<String> lines = new ArrayList<String>();

        try  {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null)
             {
lines.add(line);
             }

        } catch (IOException e) {
            e.printStackTrace();
        }
 columnName= lines.get(0).split(",");
 System.out.print("Columns:");
          for(String val:columnName)
               System.out.print(val+" | ");
System.out.println("");

  columnData= lines.get(1).split(",");
 System.out.print("ColType:");
 i=0;
          for(String val:columnData){
//              try {
//                  num= Integer.parseInt(val);
//                  System.out.print(columnName[i]+" (Int) | ");
//              } catch (Exception e) {
//                  System.out.print(columnName[i]+ " (Str) | ");
//              }
//              i++;
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
