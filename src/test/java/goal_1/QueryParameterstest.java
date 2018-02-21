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
class QueryParameterstest {
	QueryParameters query=null;
	
	@BeforeEach
	void init() {
		query=new QueryParameters();
	}
	
	@Test
	void testsetFilename() throws Exception{
		query.setFileName("ipl.csv");
		String val=query.getFileName();
		Assertions.assertEquals("ipl.csv", val);
	}
	
	@Test
	void NegtestsetFilename() throws Exception{
		Assertions.assertThrows(Exception.class, ()->{
			query.setFileName("1.csv");
		});
		
	}
	


	@AfterEach
	void clean() {
		query=null;
	}

}
