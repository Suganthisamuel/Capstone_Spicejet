package utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReports {
	
private ExtentReports extent;

public static ExtentReports getExtentReport() {
		
		// define the path where ectentreport will be generated
		String extentReportPath=System.getProperty("user.dir")+"\\Reports\\extentreport.html";
		
		//Create an object for ExtentSparkReport
		ExtentSparkReporter reporter= new ExtentSparkReporter(extentReportPath);
		
		//set the report name and document title
		reporter.config().setReportName("Spicejet Automation Result");
		reporter.config().setDocumentTitle("Spicejet Automation Test Result");
		
		//create an object of ExtentReport
		ExtentReports extentReport=new ExtentReports();
		
		 extentReport.attachReporter(reporter);
		 
		
		return extentReport;
		
	}

@SuppressWarnings("null")
private void attachReporter(ExtentSparkReporter reporter) {
	// TODO Auto-generated method stub
	ExtentSparkReporter reporter1 = new ExtentSparkReporter("extent-report.html");
	ExtentReports extentReport = null;
	extentReport.attachReporter(reporter1);

	
}

public static ExtentTest createTest(String name) {
	ExtentTest test = createTest("My Test");
	return test;




}

public void flush() {
	extent = null;
	// TODO Auto-generated method stub
	extent.flush();

}

}
