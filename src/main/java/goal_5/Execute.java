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
	ArrayList<String> operator=new ArrayList<String>();
	
	public Execute(LinkedHashMap<String,ArrayList<Object>> map,int row,ArrayList<String> cond,ArrayList<String> col,ArrayList<String> op){
		 // System.out.println("Condition "+cond);
		  this.col=col;
		  this.map=map;
		  this.cond=cond;
		  this.operator=op;	
	}
	
	public void exequery() throws IOException {
		
		if(col.isEmpty()) {
			for(String i:MakeMap.header) {
				ArrayList<Object> p= new ArrayList<>();
				result.put(i, p);
			}	
		}
		else
		{
		for(String column:col) {
			ArrayList<Object> temp = new ArrayList<>();
	    	result.put(column, temp);
		}
		}
	    
//		System.out.println(" ");
//		System.out.println("2222"+result.keySet());
		
		 for(int i=0;i<MakeMap.header.length;i++) {
			 head.add(MakeMap.header[i].trim());
		 }
		 
//Select only
//		 for(String i:head) {
//			 for(String j:col) {
//				 if(i.equalsIgnoreCase(j.trim())) {
//					 ArrayList<Object> p= map.get(i);
//					 result.put(i, p);
//				 }
//			 }
//		 }
//		 
		 
		 System.out.println(" ");
		 ArrayList<Integer> index=new ArrayList<Integer>();
		 int k=0;
		 if(operator.isEmpty())
		 {
//			for(int i=1;i<= map.get(MakeMap.header[0]).size();i++) {
//				index.add(i);
//			}
			 if(cond.get(k).contains(">")) {
				 String[] temp1=cond.get(k).split(">");
				 ArrayList<Object> p= map.get(temp1[0].trim());
				 Iterator it = p.iterator();
				 int j=0;
				    while(it.hasNext()) {
				    	int temp2=Integer.parseInt((String) it.next());
				    	if(temp2> Integer.parseInt(temp1[1].trim())) {
				    		if(!(index.contains(j)))
				    			index.add(j);
				    	}
				    	j++;
				    }
			 } 
			 
		 }
		 else {
		 for(String op:operator) {
			 ArrayList<Integer> temp=new ArrayList<Integer>();
			 for(int i=0;i<2;i++) {
				 if(k>1 && (k== (operator.size()))) {
					 i=1;
				 }
			 if(cond.get(k).contains(">")) {
				 String[] temp1=cond.get(k).split(">");
				 ArrayList<Object> p= map.get(temp1[0].trim());
				 Iterator it = p.iterator();
				 int j=0;
				    while(it.hasNext()) {
				    	int temp2=Integer.parseInt((String) it.next());
				    	if(temp2> Integer.parseInt(temp1[1].trim())) {
				    		if(i==0) {
				    		if(!(index.contains(j)))
				    			index.add(j);
				    		}
				    		else
				    		temp.add(j);	
				    	}
				    	j++;
				    }
			 } 
			 
			 k++;
			 }
			 if(op.equals("and")) {
				 index.retainAll(temp);
			 }
			 if(op.equals("or")) {
				 index.addAll(temp);
			 }
		 }
		 }
		// System.out.println("Output"+index);
		// System.out.println("Output"+result.keySet());
		 
		 for(String columns:result.keySet()) {
			 ArrayList<Object> p= map.get(columns.trim());
			 ArrayList<Object> temp=new ArrayList<>();
			 for(int i:index) {
				 String val=(String) p.get(i);
				 temp.add(val);
				// System.out.println(val);
		 }
			 result.put(columns, temp);
			// System.out.println("Output"+columns+"---"+temp);
		 }
		 
		 for(String columns:result.keySet()) {
			 ArrayList<Object> arr=new ArrayList<Object>();
			 arr=result.get(columns);
			System.out.println("Output"+columns+"---"+arr);	 
		 }
		 
//		 for(String condition:cond) {
//			 String[] temp;
//			 if(condition.contains(">")) {
//				 temp=condition.split(">");	 
//			 ArrayList<Object> p= map.get(temp[0].trim());
//			// System.out.println("22222"+p);
//			 Iterator it = p.iterator();
//			 int j=1;
//			    while(it.hasNext()) {
//			    	int temp1=Integer.parseInt((String) it.next());
//			    	if(temp1> Integer.parseInt(temp[1])) {
//			    		index.add(j);
//			    	}
//			    	j++;
//			    }
//		 }
//		 }
//		 
//		 System.out.println("22222"+index);
		 
//      for(int i=0;i<MakeMap.header.length;i++) {
//    	//  if(MakeMap.header[i].equals(col))
//  		ArrayList<Object> p= map.get(MakeMap.header[i]);
//  		System.out.println(i+"   "+MakeMap.header[i]+"|||||||||||||"+p.size());
//  	}
//		

	}
	
}
