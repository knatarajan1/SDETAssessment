package seleniumAssessment.Utilities.CommonIUtilities;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import seleniumAssessment.Utilities.GlobalVaraiabales;

public class CommonFunctions extends GlobalVaraiabales {
	/**
	 * Retrieves Web Element 
	 * @param locator - Locator Type
	 * @param value - Locator Value
	 * @return WebElement
	 */
		public WebElement getWebElement(String locator , String value) {
			WebElement element =null;
			try {
				switch (locator.toLowerCase()) {
				case "id":
					element =  driver.findElement(By.id(value));
					break;
				case "name":
					 element = driver.findElement(By.name(value));
					break;
				case "xpath":
					element =  driver.findElement(By.xpath(value));
					break;
				case "partiallinktext":
					element =  driver.findElement(By.partialLinkText(value));
					break;
				case "tag":
					element =  driver.findElement(By.tagName(value));
					break;
				case "css":
					element =  driver.findElement(By.cssSelector(value));
					break;
				case "linktext":
					element =  driver.findElement(By.linkText(value));
					break;
				default:
					throw new NoSuchElementException();
				}
			}
			catch(NoSuchElementException e) {
				element = null;
				System.out.println(e);
			}
			catch (StaleElementReferenceException e) {
				element = null;
				System.out.println(e);
			}
			catch (Exception e) {
				element = null;
				System.out.println(e);
			}
			return element;
		}
		/**
		 * Validate whether the element is visible in ,
		 * @param element
		 * @return
		 */
		public boolean validateVisibility(WebElement element) {
			boolean result =false;
			try {
				result = element.isDisplayed();
			}
			catch (NoSuchElementException e) {
				result=false;
				System.out.println(e);
			}
			catch (StaleElementReferenceException e) {
				result = true;
				System.out.println(e);
			}
			catch (Exception e) {
				System.out.println(e);
			}
			return result;
		}

}
