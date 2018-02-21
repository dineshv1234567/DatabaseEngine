package goal_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MakeMap {
    public static 	String []header=null;
    int row=0;
    public LinkedHashMap<String,ArrayList<Object>> FileRead()throws IOException {
	
    	LinkedHashMap<String,ArrayList<Object>> obj = new LinkedHashMap<>();
	File f=new File("src/main/java/ipl1.csv");
	BufferedReader br = new BufferedReader(new FileReader(f));
    String head=br.readLine();
    header=head.split(",");
  /*  for(String temp : header) {
    	System.out.println(temp);
    }*/
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
//    for(int i=0;i<header.length;i++) {
//	    	ArrayList<Object> p= obj.get(header[i]);
//	    	System.out.println(header[i]+"|||||||||||||"+p.size());
//	    }
//	    System.out.println("@@@@@@@@@@@"+obj.keySet());
    	
    br.close();
    row = (obj.get(header[0])).size();
    return obj;
}
    public int getHeader() {
    	return row;
    }

}
