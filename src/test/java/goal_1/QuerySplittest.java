package goal_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class QuerySplittest {
	QuerySplit query=null;
	@BeforeEach
	void init() {
		query=new QuerySplit();
	}
	@Test
	void testSplit1() throws Exception {
		String[] queryArray = query.split1("Select * from");
		String[] queryArray1= {"Select","*","from"};
		int flag=1;
		if(queryArray.length != queryArray1.length) 
		flag=0;
		
			for(int i=0;i<queryArray.length;i++) {
				if(queryArray[i].equals(queryArray1[i])) {
					flag=1;}
					else
					{
						flag=0;
						break;
					}	
				}
		Assertions.assertEquals(1, flag);
	}
	
	@Test
	void testNegSplit() throws Exception{
		Assertions.assertThrows(Exception.class, ()->{
			query.split1("123");
		});
	}


	@AfterEach
	void clean() {
		query=null;
	}

}
