package goal_5;

import goal_1.QueryParameters;
import java.util.ArrayList;

public class filterData {

      ArrayList<String> columns=new ArrayList<String>();
    public void filterSelectField(ArrayList<String> columns){
this.columns=columns;
       System.out.println("++++++++++++++++++++"+this.columns);

    }

         ArrayList<String> condition=new ArrayList<String>();
    public void filterWheretField(ArrayList<String> condition){
    this.condition=condition;
       System.out.println("###############@"+this.condition);
    }
}
