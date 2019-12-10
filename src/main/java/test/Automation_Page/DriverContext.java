package test.Automation_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Capabilities;

public class DriverContext {

	public static WebDriver Driver;

	public static Capabilities Capabilities;

	@SuppressWarnings("deprecation")
	public static void getDriver(String browser) throws Exception {
		switch (browser) {
		case "Chrome":
			Driver = new ChromeDriver();
			Driver.manage().window().maximize();
			Driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			break;

		case "Firefox":
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setBrowserName(browser);
			desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			desiredCapabilities.setCapability("marionette", false);
			Driver = new FirefoxDriver(desiredCapabilities);
			Driver.manage().window().maximize();
			Driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			break;

		case "InternetExplorer":
			DesiredCapabilities capabilities2 = new DesiredCapabilities();
			capabilities2.setBrowserName(browser);
			capabilities2.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities2.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			capabilities2.setVersion("11.765.17134.0");

			System.setProperty("webdriver.ie.driver", "D:/Driver/IE/IEDriverServer.exe");
			Driver = new InternetExplorerDriver(capabilities2);

			Driver.manage().deleteAllCookies();
			Driver.manage().window().maximize();
			Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			break;
		default:
			throw new Exception("Invalid browser");
			
		}

		Capabilities = ((RemoteWebDriver) Driver).getCapabilities();
	}

	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	public static void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
}
