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
	ArrayList<String> col=new ArrayList<>();
	ArrayList<String> cond=new ArrayList<>();
	ArrayList<String> head=new ArrayList<>();
	ArrayList<String> operator=new ArrayList<>();
	
	public Execute(LinkedHashMap<String,ArrayList<Object>> map,int row,ArrayList<String> cond,ArrayList<String> col,ArrayList<String> op){
		  this.col=col;
		  this.map=map;
		  this.cond=cond;
		  this.operator=op;	
	}
	
	public void exequery() throws IOException {
		//if no particular column given (Select * from ipl.csv)
		if(col.isEmpty()) {
			for(String i:MakeMap.header) {
				ArrayList<Object> p= new ArrayList<Object>();
				result.put(i, p);
			}	
		}
		//particular column given (Select id,season from ipl.csv)
		else
		{
		for(String column:col) {
			ArrayList<Object> temp = new ArrayList<Object>();
	    	result.put(column, temp);
			}
		}
	    
		//making column names ArrayList
		 for(int i=0;i<MakeMap.header.length;i++) {
			 head.add(MakeMap.header[i].trim());
		 }	 
		 
		 System.out.println(" ");
		 ArrayList<Integer> index=new ArrayList<Integer>();
		 int k=0;

		 //Nothing after tablename (select * from ipl.csv)
		 if(operator.isEmpty() && cond.isEmpty()) {
			 ArrayList<Object> p= map.get(head.get(0));
			
			 Iterator it = p.iterator();
			 int j=0;
			    while(it.hasNext()) {
			    
			    		if(!(index.contains(j)))
			    			index.add(j);
			    		j++;
			    		it.next();
			    	}	 
			    }
		 //only one condition after tablename (select * from ipl.csv where id>4)
		 else if(operator.isEmpty() && !(cond.isEmpty()))	 {
			 System.out.println("22222");
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
			 else if(cond.get(k).contains("<")) {
				 String[] temp1=cond.get(k).split("<");
				 ArrayList<Object> p= map.get(temp1[0].trim());
				 Iterator it = p.iterator();
				 int j=0;
				    while(it.hasNext()) {
				    	int temp2=Integer.parseInt((String) it.next());
				    	if(temp2< Integer.parseInt(temp1[1].trim())) {
				    		if(!(index.contains(j)))
				    			index.add(j);
				    	}
				    	j++;
				    }
			 } 
			 else if(cond.get(k).contains("=")) {
				 String[] temp1=cond.get(k).split("=");
				 ArrayList<Object> p= map.get(temp1[0].trim());
				 Iterator it = p.iterator();
				 int j=0;
				    while(it.hasNext()) {
				    	int temp2=Integer.parseInt((String) it.next());
				    	if(temp2 == Integer.parseInt(temp1[1].trim())) {
				    		if(!(index.contains(j)))
				    			index.add(j);
				    	}
				    	j++;
				    }
			 } 
			 
		 }
		 //multiple conditions after tablename (select * from ipl.csv where id>4 and id>4 or id>4 and id>5)
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
			 else if(cond.get(k).contains("<")) {
				 String[] temp1=cond.get(k).split("<");
				 ArrayList<Object> p= map.get(temp1[0].trim());
				 Iterator it = p.iterator();
				 int j=0;
				    while(it.hasNext()) {
				    	int temp2=Integer.parseInt((String) it.next());
				    	if(temp2< Integer.parseInt(temp1[1].trim())) {
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
			 else if(cond.get(k).contains("=")) {
				 String[] temp1=cond.get(k).split("=");
				 ArrayList<Object> p= map.get(temp1[0].trim());
				 Iterator it = p.iterator();
				 int j=0;
				    while(it.hasNext()) {
				    	int temp2=Integer.parseInt((String) it.next());
				    	if(temp2== Integer.parseInt(temp1[1].trim())) {
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

		 //index stored in ArrayList index
		 //column stored in LinkedHashMap result
		 for(String columns:result.keySet()) {
			 ArrayList<Object> p= map.get(columns.trim());
			 ArrayList<Object> temp=new ArrayList<Object>();
			 for(int i:index) {
				 String val=(String) p.get(i);
				 temp.add(val);
			 	}
			 result.put(columns, temp);
		 }
		 
		 //displaying result
		 for(String columns:result.keySet()) {
			 ArrayList<Object> arr=new ArrayList<Object>();
			 arr=result.get(columns);
			System.out.println("Output: "+columns+"---"+arr);	 
		 }
	}	
}
