package assignment;

import goal_1.ExtractWords;
import goal_1.QuerySplit;
import goal_5.filterData;

public class Main {

	public static void main(String args[]) {
	QuerySplit querySplit=new QuerySplit();
	String query=querySplit.input();
	String Arr[] = querySplit.split1(query);
	System.out.println("Splitted Query:");
	for(String var:Arr) {
		System.out.println(var);
	}
	ExtractWords extract=new ExtractWords();
	extract.find(query);
	//System.out.println("Filtering data on Select Fields:");
        //filterData filteringData=new filterData();
        //filteringData.filterSelectField();
	
	}
}
