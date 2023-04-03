package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class BatchExcuetion {
	@Test
	
	public void TestA() {
		Reporter.log("hi........",true);
	}

}
