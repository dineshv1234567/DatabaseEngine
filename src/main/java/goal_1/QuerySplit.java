package goal_1;

import java.util.Scanner;
import java.util.regex.Pattern;
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
	
	public String[] split1(String query) throws Exception{
		//splitting by white space
		String queryArray[] = query.split(" ");
		for(String val:queryArray) {
			val=val.trim();
			boolean fileName=Pattern.compile("^\\d.*",Pattern.CASE_INSENSITIVE).matcher(val).matches();
			if(fileName==true)
			{
				throw new Exception();
	        }
		}
		return queryArray;
		}
  	}

	

