package seleniumAssessment.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAssessmentPartOne {

	

	public static void main(String[] args) {
		/*	Website URL - https://opensource-demo.orangehrmlive.com/
		User Name - Admin
		Password - admin123
		1- Open the above URL in Chrome browser.
		2- Print the title of this application.
		3- Write Xpath and CssSelector of login page for following web objects - All Text box’s,
		All - Hyperlinks, All Images.
		4- Login with given User Name and Password and validate Dashboard. 5- Click on Admin Link in Home Page and validate following text -
					• User Management
					• Job
					• Organization
					• Qualifications
		*/
	String url= "https://opensource-demo.orangehrmlive.com/";
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(url);
	System.out.println("Title of the application is "+driver.getTitle());
	//XPATH
	WebElement userNameXPATH = driver.findElementByXPath("//input[@id='txtUsername']");
	WebElement passwordXPATH = driver.findElementByXPath("//input[@id='txtPassword']");
	WebElement loginButtonXPATH = driver.findElementByXPath("//input[@id='btnLogin']");
	WebElement logoXPATH = driver.findElementByXPath("//div[@id='divLogo']//img");
	WebElement linkedinImgXPATH = driver.findElementByXPath("//a[contains(@href,'linkedin')]//img");
	WebElement facebookImgXPATH = driver.findElementByXPath("//a[contains(@href,'facebook')]//img");
	WebElement twitterImgXPATH = driver.findElementByXPath("//a[contains(@href,'twitter')]//img");
	WebElement youtubeImgXPATH = driver.findElementByXPath("//a[contains(@href,'youtube')]//img");
	WebElement forgotPasswordLinkXPATH = driver.findElementByXPath("//a[text()='Forgot your password?']");
	WebElement orangeHRMLinkXPATH = driver.findElementByXPath("//a[text()='OrangeHRM, Inc']");
	WebElement linkedinLinkXPATH = driver.findElementByXPath("//a[contains(@href,'linkedin')]");
	WebElement facebookLinkXPATH = driver.findElementByXPath("//a[contains(@href,'facebook')]");
	WebElement twitterLinkXPATH = driver.findElementByXPath("//a[contains(@href,'twitter')]");
	WebElement youtubeLinkXPATH = driver.findElementByXPath("//a[contains(@href,'youtube')]");
	//CSS
	WebElement userNameCSS = driver.findElementByCssSelector("input#txtUsername");
	WebElement passwordCSS = driver.findElementByCssSelector("input#txtPassword");
	WebElement loginButtonCSS = driver.findElementByCssSelector("input#btnLogin");
	WebElement forgotPasswordCSS = driver.findElementByCssSelector("a[href*='PasswordResetCode']");
	WebElement orangeHRMLinkCSS = driver.findElementByCssSelector("a[href*='orangehrm']");
	WebElement logoCSS = driver.findElementByCssSelector("img[src*='login/logo']");
	WebElement linkedinImgCSS = driver.findElementByCssSelector("img[alt*='LinkedIn']");
	WebElement facebookCSS = driver.findElementByCssSelector("img[alt*='Facebook']");
	WebElement twitterImgCSS = driver.findElementByCssSelector("img[alt*='twitter']");
	WebElement youtubeImgCSS = driver.findElementByCssSelector("img[alt*='youtube']");
	WebElement linkedinLinkCSS = driver.findElementByCssSelector("a[href*='linkedin']");
	WebElement facebookLinkCSS = driver.findElementByCssSelector("a[href*='facebook']");
	WebElement twitterLinkCSS = driver.findElementByCssSelector("a[href*='twitter']");
	WebElement youtubeLinkCSS = driver.findElementByCssSelector("a[href*='youtube']");
	
	userNameCSS.sendKeys("Admin");
	passwordCSS.sendKeys("admin123");
	loginButtonCSS.click();
	
	WebElement adminLinkCSS = driver.findElementByCssSelector("a#menu_admin_viewAdminModule");
	WebElement dashboard = driver.findElementByXPath("//h1[text()='Dashboard']");
	if(dashboard.isDisplayed()) {
		adminLinkCSS.click();
		System.out.println("Dashboard is Visible");
		List<WebElement> adminOptions = driver.findElementsByXPath("(//a[@class='firstLevelMenu'])[1]//following-sibling::ul//following-sibling::li//a[@class='arrow']");
		
		List<String> adminOptionsText = new ArrayList<>();
		for (WebElement option : adminOptions) {
			adminOptionsText.add(option.getText());
		}
		
		boolean condition=false;
		if(		adminOptionsText.contains("User Management")&&
				adminOptionsText.contains("Job")&&
				adminOptionsText.contains("Organization")&&
				adminOptionsText.contains("Qualifications")		
		) 
			condition=true;
		if (condition) 
			System.out.println("Expected Options are visible");
		else
			System.err.println("Expected Options are not visible");

	}
	else
		System.err.println("Unable to login , Dashboard is not visible");

	driver.quit();
		
	}
}
