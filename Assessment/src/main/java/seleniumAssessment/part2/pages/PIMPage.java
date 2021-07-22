package seleniumAssessment.part2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumAssessment.Utilities.CommonIUtilities.Attributes;
import seleniumAssessment.Utilities.CommonIUtilities.CommonFunctions;

public class PIMPage extends CommonFunctions{

	@FindBy(xpath="//h1[text()='Employee Information']")
	private WebElement pimDashboardText;
	@FindBy(xpath="//input[@id='empsearch_employee_name_empName']")
	private WebElement employeeName;
	@FindBy(xpath="//input[@id='searchBtn']")
	private WebElement searchButton;
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr[1]/td[3]/a")
	private WebElement firstName;
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr[1]/td[4]/a")
	private WebElement lastName;
	public PIMPage() {
		PageFactory.initElements(driver, this);
	}
	public void verifyPIMDashboard() {
		String actual = pimDashboardText.getText();
		softAssert.assertEquals(actual, "Employee Information");
	}
	public void validateEmployeeSearch(String firstName, String lastName) {
		String search = firstName+" "+lastName;
		setValue(employeeName, search);
		clickElement(searchButton);
		softAssert.assertEquals(getAttribute(this.lastName, Attributes.text), lastName);
		softAssert.assertEquals(textContains(getAttribute(this.firstName, Attributes.text), firstName), true);
		takeScreenShot(screenShotPath+"validateEmployeeSearch.png");
	}
	
}
