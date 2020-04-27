package test.Automation_Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.Automation_Page.DriverContext;

public class AbstractTest {

	public static ExtentReports Report;

	public static ExtentTest TestFixture;

	public static ExtentTest Test;

	@BeforeSuite(alwaysRun = true)
	public static void runBeforeTestSuit() {
		File configPath = new File(System.getProperty("user.home")+"/git/repository/Testauto/extent-config.xml");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String report_name = "Report";// + sdf.format((new Date().getTime()));

		Report = new ExtentReports(System.getProperty("user.home")+"/git/repository/Testauto/test-output/Reports/" + report_name + ".html",true);
		Report.addSystemInfo("Host Name", "Automation").addSystemInfo("Environment", "Automation Test")
			.addSystemInfo("User Name", "Nandkishor Ban").loadConfig(configPath);
	}

	@Parameters({ "browser", "env" })
	@BeforeClass(alwaysRun = true)
	public void runBeforeClass(String browser, String env) throws Exception {
		DriverContext.getDriver(browser);
		String dev3_url = getUrlFromConfig(env);
		DriverContext.Driver.get(dev3_url);
		

		DriverContext.Driver.switchTo().defaultContent();
		waitForAjaxCompleted();
		waitForPageLoadCompleted();
		PageFactory.initElements(DriverContext.Driver, this);

		String testClassName = this.getClass().getSimpleName();
		testClassName = testClassName + " (" + browser + ")";
		TestFixture = Report.startTest(testClassName);
	}

	@BeforeMethod(alwaysRun = true)
	public void runBeforeMethod(Method method) {
		String testName = method.getName();
		Test = Report.startTest(testName);
		Test.log(LogStatus.INFO, "Start Test");
	}

	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result) {
		String message = result.getName() + " is passed";
		String testDescription = result.getMethod().getDescription();
		Test.log(LogStatus.INFO, "End Test");

		if (result.getStatus() == ITestResult.SUCCESS) {
			Test.log(LogStatus.PASS, message);
		}

		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshot = getScreeenshot();

			Test.setDescription(testDescription);
			Test.log(LogStatus.FAIL, result.getThrowable().getMessage());
			Test.log(LogStatus.FAIL, "Screenshot below : " + Test.addScreenCapture(screenshot));
		}
		TestFixture.appendChild(Test);
		Report.endTest(Test);
	}

	@AfterClass(alwaysRun = true)
	public void runAfterClass() {
		Report.endTest(TestFixture);
		DriverContext.Driver.close();
		
	}

	@AfterSuite(alwaysRun = true)
	public void runAfterTestSuit() throws Exception {
		Report.flush();
		Report.close();		
		SendEmail.sendMail();
	}

	public static String getScreeenshot() {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) DriverContext.Driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/test-output/FailedTestsScreenshots/" + "ScreenShot_"
				+ dateName + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destination;
	}

	public String getUrlFromConfig(String env) throws IOException {
		String url = null;
		Properties config = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.home")+"/git/repository/Testauto/src/test/resources/test/Common/config.properties");
			config.load(fis);
			url = config.getProperty(env);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return url;
	}

	void waitForAjaxCompleted() {
		try {
			ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) DriverContext.Driver)
					.executeScript("return jQuery.active") == 0);

			WebDriverWait jsWait = new WebDriverWait(DriverContext.Driver, 10);
			JavascriptExecutor jsExec = (JavascriptExecutor) DriverContext.Driver;
			boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");

			if (!jqueryReady) {
				jsWait.until(jQueryLoad);
			}
		} catch (WebDriverException ignored) {
		}
	}

	void waitForPageLoadCompleted() {
		try {
			WebDriverWait wait = new WebDriverWait(DriverContext.Driver, 30);
			wait.until(d -> ((JavascriptExecutor) DriverContext.Driver).executeScript("return document.readyState")
					.equals("complete"));
		} catch (WebDriverException ignored) {
		}
	}

}
