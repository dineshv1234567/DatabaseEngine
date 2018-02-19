package goal_1;
import java.util.regex.*;

public class ExtractWords {

	public void find(String query) {
		String queryWords[] = query.split(" ");
		
		//Check file name
		if(query.contains("csv")) {
		for(String val:queryWords) {
		boolean fileName=Pattern.compile(".*csv",Pattern.CASE_INSENSITIVE).matcher(val).matches(); 	
		if(fileName==true)
		System.out.println("Filename:"+val);
		}
		}
		
		//Before where part
		if(query.contains("where")) {
		System.out.println("Before \"where\" part:"+query.substring(0, query.indexOf("where")-1));
		}
		
		//After where part
		String afterWherePart="";
		if(query.contains("where")) {
		afterWherePart=query.substring(query.lastIndexOf("where")+6);
		System.out.println("After \"where\" part:"+afterWherePart);
		}
		
		//Separate conditions
		String[] separateByAnd = afterWherePart.split("and");
		System.out.println("Conditions:");
		for(String val:separateByAnd)
		{
			String[] separateByOr = val.split("or");
			if(separateByOr.length>1){
			for(String val1:separateByOr) {
				System.out.println(val1);
			}
			}
		}
		
		//checks logical operators
		System.out.println("Conditional Operators:");
		if(query.contains("and")) 
		System.out.println("and");
		if(query.contains("or")) 
		System.out.println("or");
		
		//Checks column selected
		System.out.println("Columns:");
		String[] temp=query.split("from");
		String[] temp1=temp[0].split("select");
		String[] temp2=temp1[1].split(",");
		for(String val:temp2) {
			System.out.println(val);
		}
		
		//Check orderBy field
		String orderBy="";
		if(query.contains("order by")) {
			System.out.println("Order By field:");
			temp=query.split("order by");
			if(temp[1].contains("group by"))
			{
				orderBy=temp[1].substring(0, temp[1].indexOf("group by"));
			}
			else {
				orderBy=temp[1];
			}
			String[] orderByColm=orderBy.split(",");
			for(String val:orderByColm) {
				System.out.println(val);
			}
		}
		
		//Check groupBy field
		String groupBy="";
		if(query.contains("group by")) {
			System.out.println("Group By field:");
			temp=query.split("group by");
			if(temp[1].contains("having"))
			{
				groupBy=temp[1].substring(0, temp[1].indexOf("having"));
			}
			else {
				groupBy=temp[1];
			}
			String[] groupByColm=groupBy.split(",");
			for(String val:groupByColm) {
				System.out.println(val);
			}
		}
		
		//Check aggregate functions
		if((query.contains("avg")) || (query.contains("sum")) || (query.contains("max")) || (query.contains("min")) || (query.contains("count"))) {
		System.out.println("Aggregate functions:");
			for(String val:queryWords) {
			boolean agg=Pattern.compile("(.*avg.*|.*min.*|.*max.*|.*count.*|.*sum.*)",Pattern.CASE_INSENSITIVE).matcher(val).matches(); 	
			if(agg==true)
			System.out.println(val);
		}
		}
	}
	
//Entered Query:select kk,tinder,kk from gurgaon dd.csv where dd and gg or ff order by test,nikhil group by	ff sum(a)
}
