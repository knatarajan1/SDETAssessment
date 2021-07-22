package seleniumAssessment.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class GlobalVaraiabales {
	public static WebDriver driver;
	public static String driverPath="./driver/";
	public static String testDataExcelfilePath = "./Data/OHRMTestData.xlsx";
	public static SoftAssert softAssert = new SoftAssert();
	public static String screenShotPath = "./ScreenShots/";
	public static String screenShotPathPassed = screenShotPath+"Passed/";
	public static String screenShotPathFailed = screenShotPath+"Failed/";
}
