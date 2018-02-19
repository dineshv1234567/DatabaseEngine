package goal_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MakeMap {
	 static String []header=null;
     int row=0;
     LinkedHashMap<String,ArrayList<Object>> FileRead(){
    	 
		LinkedHashMap<String,ArrayList<Object>> obj = new LinkedHashMap<>();
		String csvFile="src/Document/ipl.csv";
		BufferedReader br=null;
 	try  {
        br = new BufferedReader(new FileReader(csvFile));
        String head=br.readLine();
        header=head.split(",");
        
        for(int i=0;i<header.length;i++) {
        	ArrayList<Object> temp = new ArrayList<>();
        	obj.put(header[i], temp);
        }
        head=br.readLine();
        while(head != null) {
        	String temp[]=head.split(",");
        	for(int i=0;i<header.length;i++) {
        		ArrayList<Object> p= obj.get(header[i]);
        	    p.add(temp[i]);
        	    obj.put(header[i], p);
        	}
        	head=br.readLine();
        }
       
        
     	
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
	

     row = (obj.get(header[0])).size();
     return obj;
	}
     int getHeader() {
     	return row;
     }

}
