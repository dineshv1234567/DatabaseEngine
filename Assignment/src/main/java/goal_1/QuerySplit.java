package goal_1;

import java.util.Scanner;
public class QuerySplit {
	
	public String input() {
		//Reading user query from command line
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter query:");
		String query=sc.nextLine();
		if(query.equals(""))
			System.out.println("Query not entered");
		else
		{
		System.out.println("Entered Query:"+query);
		}
		sc.close();
		return query;
		
	}
	
	public String[] split1(String query) {
		String queryArray[] = query.split(" ");
		return queryArray;
	}
}

	

