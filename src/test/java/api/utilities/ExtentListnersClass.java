package api.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListnersClass implements ITestListener {
	ExtentSparkReporter extentSpark;
	ExtentReports reports;
	ExtentTest test;

	
	public void onStart(ITestContext context) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportName = "Report_" + timeStamp + ".html";

        extentSpark = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/" + reportName);
        extentSpark.config().setDocumentTitle("REST ASSURED AUTOMATION");
        extentSpark.config().setReportName("API Test Report");
        extentSpark.config().setTheme(Theme.DARK);

        reports = new ExtentReports();
        reports.attachReporter(extentSpark);
        reports.setSystemInfo("Machine", "PC");
        reports.setSystemInfo("Environment", "QA");
    }



	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Starts");
		test=reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Test Success", ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("The test is failed" + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Test case failed" + result.getName(), ExtentColor.GREEN));
		String screenShotpath = System.getProperty("user.dir") + "//Screenshots//" + result.getName() + ".jpeg";
		File file = new File(screenShotpath);
		if (file.exists()) {
			test.fail("Capture screen shot below: " + test.addScreenCaptureFromPath(screenShotpath));
		}

	}

	public void onFinish(ITestContext context) {
		System.out.println("On test finish");
		reports.flush();
	}

}
