package goal_1;
import goal_5.filterData;
import java.util.ArrayList;
import java.util.regex.*;

public class ExtractWords {

	public QueryParameters find(String query) {
		String queryWords[] = query.split(" ");
		QueryParameters param=new QueryParameters();
		
		System.out.println("---------------");
		//Check file name
		for(String val:queryWords) {
		boolean fileName=Pattern.compile(".+csv",Pattern.CASE_INSENSITIVE).matcher(val).matches();
		if(fileName==true)
		{System.out.println("Filename:"+val);
                param.setFileName(val);
                break;
        }
		}
		
		//Before where part
		if(query.contains("where")) {
                    String beforeWhere = query.substring(0, query.indexOf("where")-1);
		System.out.println("Before \"where\" part:"+beforeWhere);
                param.setBeforeWhere(beforeWhere);
		}
		
		//After where part     
		if(query.contains("where")) {
			String afterWherePart=query.substring(query.lastIndexOf("where")+6);
		System.out.println("After \"where\" part:"+afterWherePart);
                param.setAfterWhere(afterWherePart);
		}
		
		//Check conditions
		if(((query.contains("and")) || (query.contains("or"))) && (query.contains("where"))) {
			String afterWherePart=""; 
			if(query.contains("group by"))
			afterWherePart=query.substring(query.lastIndexOf("where")+6,query.indexOf("group by")-1);
			else
			afterWherePart=query.substring(query.lastIndexOf("where")+6);	
        String[] separateByAnd = afterWherePart.split("and");
		for(String val:separateByAnd)
		{
			String[] separateByOr = val.split("or");
			{
			for(String val1:separateByOr) {
				System.out.println(val1); 
                      param.addConditions(val1);
			}
			}
		}
		}
		
		//checks logical operators
		if(query.contains("and")) 
		System.out.println("Conditional Operator: and");
		if(query.contains("or")) 
		System.out.println("Conditional Operator: or");
		
		//Checks column selected
		String[] temp;
		if((query.contains("select")) && (query.contains("from")) && !(query.contains("*"))) {
		
		temp=query.split("from");
		String[] temp1=temp[0].split("select");
		if(temp1[1].length()>1) {
			System.out.println("Columns:");
		String[] temp2=temp1[1].split(",");
		for(String val:temp2) {
			System.out.println(val);
                   param.addColumns(val);
		}
		}
		}
		
		//Select all
		if((query.contains("select")) && (query.contains("from")) && (query.contains("*"))) {
		//To be added	
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
                param.addColumnsOrderBy(val);
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
               param.addColumnsGroupBy(val);
			}
		}
		
		//Check aggregate functions
		if((query.contains("avg")) || (query.contains("sum")) || (query.contains("max")) || (query.contains("min")) || (query.contains("count"))) {
		AggregateFunction aggFnc=new AggregateFunction();
         System.out.println("Aggregate functions:");
			for(String val:queryWords) {
			boolean agg=Pattern.compile("(.*avg.*|.*min.*|.*max.*|.*count.*|.*sum.*)",Pattern.CASE_INSENSITIVE).matcher(val).matches(); 	
			if(agg==true){
			System.out.println(val);
            aggFnc.setAgg(val);
             }
		}
		}
		return param;
	}

}
