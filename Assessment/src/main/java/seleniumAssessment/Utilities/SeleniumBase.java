package seleniumAssessment.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import seleniumAssessment.Utilities.CommonIUtilities.CommonFunctions;

public class SeleniumBase extends CommonFunctions{
	//Changed Before Suite to Before Method since ex3cuting both positive and negative scenarios for testng.xml suite
	@Parameters({"url","browserName"})
	@BeforeSuite
	public void setUp(String url,String browserName) {
		deleteFolder(screenShotPath);
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe");
			 DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			  
			 capabilities.setCapability("ignoreZoomSetting",true);
			 capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			 capabilities.setCapability(InternetExplorerDriver.
			   INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			driver = new InternetExplorerDriver(capabilities);
		default:
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	@AfterSuite
	public void tearDown() {
	driver.quit();	
	}


}
