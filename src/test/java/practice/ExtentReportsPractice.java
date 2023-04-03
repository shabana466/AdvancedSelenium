package practice;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsPractice {

	public static void main(String[] args) throws IOException {
		ExtentReports report=new ExtentReports();
		File file=new File("report.html");
		ExtentSparkReporter spark=new ExtentSparkReporter(file);
		
		spark.config().setReportName("sample Test");
		spark.config().setDocumentTitle("Extent Reporting practice");
		spark.config().setTheme(Theme.STANDARD);
	    report.attachReporter(spark);
	    report.setSystemInfo("Author", "Shabana");
	    report.setSystemInfo("OS", "Windows");
	    ExtentTest test=report.createTest("Test 1");
	    test.log(Status.INFO, "This is sample test");
	    report.createTest("Test 2");
	         //.4 .pass("This test is passed") no need this all things
	          //5.info("This is just an info");
	          //.2 skip("This test is skipped")
	          //.1fail("This test is failed")
	          //..3.warning("Test is test waring");
	   //without flush its not generated report in extentreports folder
	          
	    report.flush();
	    //to open report in browser directly
	    Desktop.getDesktop().browse(new File("report.html").toURI());
	    
		

	}

}
