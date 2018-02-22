package goal_5;

import goal_1.QueryParameters;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class filterData {
	 ArrayList<String> columns=new ArrayList<String>();
    ArrayList<String> condition=new ArrayList<String>();
    
public void filterWheretField(ArrayList<String> condition){
this.condition=condition;
  System.out.println("###############@"+this.condition);
}

    public void filterSelectField(ArrayList<String> columns){
this.columns=columns;
       System.out.println("++++++++++++++++++++"+this.columns);
    }
   
    public void filterSelectedField() {
    	
   
    String csvFile="/home/sapient/Desktop/jenkins_practice1/Assignment/ipl.csv";
    String line="";
   
    ArrayList<String> lines=new ArrayList<String>();
    
    try {
    	BufferedReader br =new BufferedReader(new FileReader(csvFile));
    	while((line=br.readLine())!=null) {
    		lines.add(line);
    	}
    	
    }
    catch(IOException e){
    	e.printStackTrace();
    }
    String[] columnName=lines.get(0).split(",");
    int index=0;
    for(String val:columnName) {
    	for(String val1:columns) {
    		if(val.equalsIgnoreCase(val1)){
    		System.out.println("\n"+val);
    		for(int index2=1;index2<lines.size();index2++) {
    			String[] data=lines.get(index2).split(",");
    			System.out.print(data[index]+" ");
    		}
    		}
    	}
    	index++;
	
    }
   
    }
}