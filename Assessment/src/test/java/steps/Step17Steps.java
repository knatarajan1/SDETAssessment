package steps;

import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utilitiesForCucumber.DriverInstanceforCucumber;

public class Step17Steps extends DriverInstanceforCucumber{

	@Given("Logged into the application using credential as {string} with password as {string}")
	public void loginToTheApplication(String userName, String passsword) {
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys(userName);
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys(passsword);
		driver.findElement(By.cssSelector("input#btnLogin")).click();
	}
	@Then("click on Job Title")
	public void clickJobTitle() {
			driver.findElement(By.xpath("//a[@id='menu_admin_Job']")).click();
			driver.findElement(By.xpath("//a[@id='menu_admin_viewJobTitleList']")).click();
}
	@Then("Verify Job Title")
	public void verifyJobTitle() {
		softAssert.assertEquals(driver.findElement(By.xpath("//h1[text()='Job Titles']")).getText(), "Job Titles");
	}
}
