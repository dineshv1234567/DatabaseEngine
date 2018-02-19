
package goal_1;

import java.util.ArrayList;

public class AggregateFunction {

    	public static void main(String args[])
	{
		String str = "sum(a,b)";
		String[] temp = str.split("sum");
		String temp1= temp[1].substring(1, temp[1].length()-1);
                String[] val=temp1.split(",");
		for (String a : val)
			System.out.println(a);
	}
        String[] aggregateFnc={"max","min","avg","sum","count"};
        String[] temp, values;
        String temp1,keyword;
         private ArrayList<String> min=new ArrayList<String>();
         private ArrayList<String> max=new ArrayList<String>();
         private ArrayList<String> count=new ArrayList<String>();
         private ArrayList<String> avg=new ArrayList<String>();
         private ArrayList<String> sum=new ArrayList<String>();

        public void setAgg(String queryPart){
            for(String value:aggregateFnc){
                if(queryPart.contains(value)){
                    keyword=value;
                    temp=queryPart.split(keyword);
                    temp1= temp[1].substring(1, temp[1].length()-1);
                    values=temp1.split(",");
		   for(String col:values){
                      if(keyword.equals("max"))
                          max.add(col);
                      else if(keyword.equals("min"))
                          min.add(col);
                      else if(keyword.equals("avg"))
                          avg.add(col);
                      else if(keyword.equals("count"))
                          count.add(col);
                      else if(keyword.equals("sum"))
                          sum.add(col);
                   }
                }

            }
        }

}
