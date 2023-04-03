

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generivUtilities.SampleBaseClass;

//@Listeners(generivUtilities.ListnerImplementation.class)

public class ListnerPracticeTest extends SampleBaseClass {
	@Test
	public void test1() {
		System.out.println("test1");
	}
	
	//@Test(retryAnalyzer=generivUtilities.RetryImplemntation.class)
	@Test
	public void test2() {
		System.out.println("test2");
		Assert.fail();
	}

}
