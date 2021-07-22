package seleniumAssessment.Utilities.CommonIUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
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
			}
			catch (StaleElementReferenceException e) {
				result = true;
			}
			catch (Exception e) {
				System.out.println(e);
			}
			return result;
		}
		/**
		 * Set the value in input text Box
		 * @param element
		 * @param text
		 */
		public void setValue(WebElement element, String text) {
			try {
				element.clear();
				element.sendKeys(text);
			}
			catch (Exception e) {
				System.out.println("Unable to Set the value in "+element.toString());
				System.out.println(e);
			}
		}
		/**
		 * Click the element
		 * @param element
		 */
		public void clickElement(WebElement element) {
			try {
				element.click();
			}
			catch (Exception e) {
				System.out.println("Unable to click element "+element.toString());
				System.out.println(e);
			}
		}
		/**
		 * Return test data for the Test Class
		 * @param className
		 * @return String Array of Test Data
		 * Hard coded testData to maximum of 5, If more test data are given it will throw array 
		 * out of bound exception
		 */
		public String[][] getTestData(String className) {
			String[][] testData = new String[5][1]; 
			int tableIndex=0;
			try {
				Workbook workBook = getWorkBook(testDataExcelfilePath);
				Sheet sheet = workBook.getSheet("OHRM_TestMappingMatrix");
				int lastRowNum = sheet.getLastRowNum();
				for(int index=1;index<=lastRowNum;index++) {
					if(index>5)
						break;
					String value = sheet.getRow(index).getCell(0).getStringCellValue();
					if(value.equals(className)) {
						testData[tableIndex][0]=sheet.getRow(index).getCell(1).getStringCellValue();
						tableIndex++;
					}
				}
				tableIndex=0;

			}
			catch(Exception ex) {
				System.out.println(ex);
				testData=null;
			}
			int rows=0;
			for(int i=0;i<4;i++) {
				for(int j=0;j<1;j++) {
					if(!(testData[i][j]==null)) {
						rows++;
					}
				}		
			}
			String newTestData[][] = new String [rows][1];
			try {
				for(int i=0;i<4;i++) {
					for(int j=0;j<1;j++) {
						if(!(testData[i][j]==null))  {
							newTestData[tableIndex][0]=testData[i][j];
							tableIndex++;
						}
					}		
				}
			}
			catch(Exception ex) {
				System.out.println(ex);
				newTestData= null;
			}
			return newTestData;
		}
		/**
		 * To Get excel workBook
		 * @return Excel WorkBook 
		 */
		private Workbook getWorkBook(String testDataExcelfilePath) {
			Workbook workBook = null;
			try {
				File inputFile = new File(testDataExcelfilePath);
				FileInputStream inputStream = new FileInputStream(inputFile);
				String fileName = testDataExcelfilePath.replace("./", "").trim();
			    String fileExtensionName = fileName.substring(fileName.indexOf("."));
			    if(fileExtensionName.equalsIgnoreCase(".xlsx"))
			    	workBook = new XSSFWorkbook(inputStream);
			    else if(fileExtensionName.equalsIgnoreCase(".xlsx"))
			    	workBook = new HSSFWorkbook(inputStream);
			}
			catch (Exception e) {
				System.out.println(e);
				workBook=null;
			}
			return workBook;
		}
		/**
		 * Retrieve Data from the test data 
		 * @param tableName - Sheet Name
		 * @param testCase - Test Row
		 * @param column - Value to be retrieved
		 * @return String value to be retrieved
		 */
		public String getData(String tableName,String testCase,String column){
			String value=null;
			try {
				Workbook workBook = getWorkBook(testDataExcelfilePath);
				Sheet sheet = workBook.getSheet(tableName);
				value = sheet.getRow(getRowIndex(sheet, testCase)).getCell(getColumnIndex(sheet, column)).getStringCellValue();
			}
			catch(Exception e) {
				value=null;
				System.out.println(e);
			}
			return value;
		}
		/**
		 * Retrieve Row Number of the Test Case
		 * @param sheet - Sheet Name
		 * @param testCase - Test Case Name
		 * @return index of the test case row
		 */
		private int getRowIndex(Sheet sheet,String testCase) {
			int index=-1;
			try {
				int lastRowNum= sheet.getLastRowNum();
				for(int i=1;i<=lastRowNum;i++) {
					if(sheet.getRow(i).getCell(0).getStringCellValue().equals(testCase)) {
						index=i;
						break;
					}
						
				}
			}
			catch(Exception e) {
				index=-1;
				System.out.println(e);
			}
			return index;
		}
		/**
		 * Retrieve Column Number of the value to be retrieved
		 * @param sheet - Sheet Name
		 * @param column - Column value to be retrieved
		 * @return index of the column
		 */
		private int getColumnIndex(Sheet sheet, String column) {
			int index=-1;
			try {
				int lastColumnNumber= sheet.getRow(0).getLastCellNum();
				for(int i=1;i<=lastColumnNumber;i++) {
					if(sheet.getRow(0).getCell(i).getStringCellValue().equals(column)) {
						index=i;
						break;
					}	
				}
			}
			catch(Exception e) {
				index=-1;
				System.out.println(e);
			}
			return index;
		}
		/**
		 * minimize the window
		 */
		public void minimizeWindow() {
			Dimension n = new Dimension(360, 592);  
			driver.manage().window().setSize(n);
		}
		/**
		 * To Retrieve attribute of given element
		 * @param element
		 * @param attribute
		 * @return String value of attribute to be retrieved
		 */
		public String getAttribute(WebElement element, Attributes attribute) {
			String result="";
			switch (attribute) {
			case value:
				result = element.getAttribute("value");
				break;
			case text:
				result = element.getAttribute("text");
				break;
			case innerText:
				result = element.getAttribute("innertext");
				break;
			case placeholder:
				result = element.getAttribute("placeholder");
				break;
			default:
				break;
			}
			return result;
		}
		/**
		 * Delete the given folder
		 * @param folderPath
		 */
		public void deleteFolder(String folderPath) {
			try {
				FileUtils.deleteDirectory(new File(folderPath));
				System.out.println(folderPath+ " Deleted");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/**
		 * To check whether the given text contains the word
		 * @param text
		 * @param word
		 * @return boolean true if word is present in text or else false
		 */
		public boolean textContains(String text,String word) {
			return text.contains(word);
		}
		/**
		 * Take Screen shot and place it in folder
		 * @param fileName
		 */
		public void takeScreenShot(String fileName) {
			  TakesScreenshot screenShot = (TakesScreenshot)driver;       
	          File source = screenShot.getScreenshotAs(OutputType.FILE);  
	          File destination = new File(fileName);
	          try {
				FileUtils.copyFile(source, destination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}

}
