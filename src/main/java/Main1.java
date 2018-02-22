import java.io.IOException;
import java.lang.reflect.Executable;
import java.util.*;

import org.junit.jupiter.engine.execution.ExecutableInvoker;

import goal_1.ExtractWords;
import goal_1.QueryParameters;
import goal_1.QuerySplit;
import goal_3.MakeMap;
import goal_3.readCsvFile;
import goal_5.Execute;

public class Main1 {

	public static void main(String[] args) throws Exception {
			System.out.println("Hello");
			
			//reading and splitting query 
			QuerySplit querySplit=new QuerySplit();
			String query=querySplit.input();
			String Arr[] = querySplit.split1(query);
			
			//displaying splitter query
			System.out.println("Splitted Query:");
			for(String var:Arr) {
				System.out.println(var);
			}
			
			//extract keywords and store in object
			ExtractWords extract=new ExtractWords();
			QueryParameters obj1=extract.find(query);
			System.out.println("------File Details-------------------");
			System.out.println("Filename "+obj1.getFileName());
			System.out.println("Before Where "+obj1.getBeforeWhere());
			System.out.println("After Where "+obj1.getAfterWhere());
			System.out.println("Conditions "+obj1.getConditions());
			System.out.println("Get Columns "+obj1.getColumns());
			System.out.println("Columns in Order By "+obj1.getColumnsOrderBy());
			System.out.println("Columns in Group By "+obj1.getColumnsGroupBy());
			System.out.println("Operators "+obj1.getOperator());
			
			//reading the file
	        readCsvFile readFile=new readCsvFile();
			readFile.read();
			
			//making LinkedHashmap 
			MakeMap mp =new MakeMap();
		    LinkedHashMap<String,ArrayList<Object>> map = mp.FileRead();
            int row=mp.getHeader();
            
            //executing the query
            System.out.println("------Result-------------------");
            Execute exe=new Execute(map,row,obj1.getConditions(),obj1.getColumns(),obj1.getOperator());
            exe.exequery();
		
	} 

}
