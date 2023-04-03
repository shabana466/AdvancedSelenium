package generivUtilities;



import java.io.File;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mysql.jdbc.Driver;

public class ListnerImplementation implements ITestListener{
	private ExtentReports report;
	private ExtentTest test;
	public static ExtentTest stest;
	@Override
	public void onStart(ITestContext context) {
		//File file=new File("reports.html");
		ExtentSparkReporter spark=new ExtentSparkReporter("./VtigerExtentReports/extentReports.html");
		//System.err.println("onStart");
		spark.config().setReportName("VtigerCRM Extent Reports");
		spark.config().setDocumentTitle("VtigerCRM Extent Reports");
		spark.config().setTheme(Theme.STANDARD);
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Author", "Shabana");
	    report.setSystemInfo("OS", "Windows");
	    report.setSystemInfo("Java Version",System.getProperty("java.version"));
	   
	   
	    
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		//after before class capabilites 
		 Capabilities cap = ((RemoteWebDriver)BaseClass.Sdriver).getCapabilities();
		   report.setSystemInfo("Browser", cap.getBrowserName()+" "+cap.getVersion());
		//System.err.println("onTestStart");
		test=report.createTest(result.getMethod().getMethodName());
		stest=test;
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//System.err.println("onTestSuccess");
		test.log(Status.PASS,result.getMethod().getMethodName()+"Pass");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//System.err.println("onTestFailure");
		test.fail(result.getThrowable());//to catch exception
		test.fail(result.getMethod().getMethodName()+"Fail");//print msg after fail
		//this is different thread thats why we create another instance webdriverutility& driver and different reference for listeners
		Webdriverutility web=new Webdriverutility();
		
		String path = web.getScreenShot(BaseClass.SjavaUtil,result.getMethod().getMethodName(), BaseClass.Sdriver);
		test.addScreenCaptureFromPath(path);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//System.err.println("onTestSkipped");
		test.skip(result.getMethod().getMethodName()+"Skipped");
		test.skip(result.getThrowable());
		
	}
     @Override
	public void onFinish(ITestContext context) {
		//System.err.println("onFinish");
    	 report.flush();//to generate report
		
	}
	
	
}
