package hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilitiesForCucumber.DriverInstanceforCucumber;

public class Hooks extends DriverInstanceforCucumber{
	@Before
	public void beforeScenario(Scenario scenario) {
		System.out.println("Scenario Name: "+scenario.getName());
		System.out.println("Scenario Status: "+scenario.getStatus());
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");		
	}
	@After
	public void afterScenario(Scenario scenario) {
		driver.quit();
		System.out.println("Scenario Status: "+scenario.getStatus());
	}
}
	