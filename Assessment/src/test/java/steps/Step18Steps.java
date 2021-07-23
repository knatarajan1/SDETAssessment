package steps;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilitiesForCucumber.DriverInstanceforCucumber;

public class Step18Steps extends DriverInstanceforCucumber{

	
@When("User enters the username as {string}")
public void enterUserName(String userName) {
	driver.findElement(By.cssSelector("input#txtUsername")).sendKeys(userName);
}
@When("User enters the password as {string}")
public void enterUserPassword(String password) {
	driver.findElement(By.cssSelector("input#txtPassword")).sendKeys(password);
}
@And("User clicks the login button")
public void clickLoginButton() {
	driver.findElement(By.cssSelector("input#btnLogin")).click();
}
@Then("Validate login")
public void validateLogin() {
	boolean status =false;
			try {
				status = driver.findElement(By.xpath("//h1[text()='Dashboard']")).isDisplayed();
			}
			catch(Exception ex) {
				status=false;
			}

		if(status)
			System.out.println("Login Successfull");
		else
			System.out.println("Login UnSuccessfull");
	
}
}
