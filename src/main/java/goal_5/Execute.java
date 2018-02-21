package goal_5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

import goal_1.QueryParameters;
import goal_3.MakeMap;

public class Execute {
	
	LinkedHashMap<String,ArrayList<Object>> result=new LinkedHashMap<String,ArrayList<Object>>();
	LinkedHashMap<String,ArrayList<Object>> map=new LinkedHashMap<String,ArrayList<Object>>();
	ArrayList<String> col=new ArrayList<String>();
	ArrayList<String> cond=new ArrayList<String>();
	ArrayList<String> head=new ArrayList<String>();
	ArrayList<Integer> index=new ArrayList<Integer>();
	public Execute(LinkedHashMap<String,ArrayList<Object>> map,int row,ArrayList<String> cond,ArrayList<String> col){
		System.out.println(" ");
		System.out.println("OO Result@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		  System.out.println("Condition "+cond);
		  this.col=col;
		  this.map=map;
		  this.cond=cond;
		  System.out.println("Columns "+col);
		  System.out.println("CSV File@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"); 	
//        for(int i=0;i<MakeMap.header.length;i++) {
//    		ArrayList<Object> p= map.get(MakeMap.header[i]);
//    		System.out.println(i+"   "+MakeMap.header[i]+"|||||||||||||"+p.size());
//    	}
	}
	
	public void exequery() throws IOException {
		for(String column:col) {
			ArrayList<Object> temp = new ArrayList<>();
	    	result.put(column, temp);
		}
	
		 for(int i=0;i<MakeMap.header.length;i++) {
			 head.add(MakeMap.header[i].trim());
		 }
		 
//Select only
		 for(String i:head) {
			 for(String j:col) {
				 if(i.equalsIgnoreCase(j.trim())) {
					 ArrayList<Object> p= map.get(i);
					 result.put(i, p);
				 }
			 }
		 }
		 
		 for(String condition:cond) {
			 String[] temp;
			 if(condition.contains(">")) {
				 temp=condition.split(">");	 
			 ArrayList<Object> p= map.get(temp[0].trim());
			// System.out.println("22222"+p);
			 Iterator it = p.iterator();
			 int i=1;
			    while(it.hasNext()) {
			    	int temp1=Integer.parseInt((String) it.next());
			    	if(temp1> Integer.parseInt(temp[1])) {
			    		index.add(i);
			    	}
			    	i++;
			    }
		 }
		 }
		 
		 System.out.println("22222"+index);
		 
//      for(int i=0;i<MakeMap.header.length;i++) {
//    	//  if(MakeMap.header[i].equals(col))
//  		ArrayList<Object> p= map.get(MakeMap.header[i]);
//  		System.out.println(i+"   "+MakeMap.header[i]+"|||||||||||||"+p.size());
//  	}
//		

	}
	
}
