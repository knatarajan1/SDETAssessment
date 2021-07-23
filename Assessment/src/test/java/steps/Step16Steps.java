package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utilitiesForCucumber.DriverInstanceforCucumber;

public class Step16Steps extends DriverInstanceforCucumber {
	
	@Given("When I am in OrangeHRP Application")
	public void whenIAmInOrangeHRPApplication() {
		softAssert.assertEquals( driver.findElement(By.cssSelector("img[src*='login/logo']")).isDisplayed(), true);
	}

	@Then("Login to application with credentials {string} and {string}")
	public void loginToApplicationWithCredentialsAnd(String userName, String password) {
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys(userName);
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys(password);
		driver.findElement(By.cssSelector("input#btnLogin")).click();
	}

	@Then("Dashboard Page is available")
	public void dashboardPageIsAvailable() {
		softAssert.assertEquals(driver.findElement(By.xpath("//h1[text()='Dashboard']")).isDisplayed(), true);
	}

	@Then("click on Admin Menu")
	public void clickOnAdminMenu() {
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
		softAssert.assertEquals(driver.findElement(By.xpath("//h1[text()='System Users']")).isDisplayed(), true);
	}

}
