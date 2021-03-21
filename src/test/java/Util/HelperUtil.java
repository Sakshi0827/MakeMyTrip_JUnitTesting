package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefinition.Hooks;

public class HelperUtil {

	WebDriver driver = Hooks.driver;


	public Properties readPropertyFile() throws IOException {
		// to access property file
		File src= new File("src\\test\\resources\\DataResources\\config.property");
		FileInputStream fis = new FileInputStream(src);
		//to read the property file create an object of properties class
		Properties obj= new Properties();
		//to load property file
		obj.load(fis);
		return obj;
	}
	//Read Data from Excel Sheets
	public XSSFSheet ReadExcel() throws IOException {
		Properties obj = readPropertyFile();
		XSSFWorkbook workbook;
		System.out.println("Gmail id entering");

		FileInputStream fis = new FileInputStream(obj.getProperty("excelSheetPath"));
		workbook = new XSSFWorkbook (fis);
		XSSFSheet ws = workbook.getSheetAt(0);
		return ws;
	}

	//Wait for visibility of Element
	public WebElement waitVisibilityOf(WebElement we) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(we));
		return ele;

	}

	//Wait for clickability of Element
	public WebElement waitClickable(WebElement we) {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(we));
		return btn;

	}

	//	Wait for Refreshed and clickability of Element
	public WebElement waitRefreshedClickable(WebElement we) {
		WebDriverWait wait2=new WebDriverWait(driver, 10);
		WebElement btn = wait2.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(we)));
		return btn;

	}

	//Window Handler
	public WebDriver windowHandler() {
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		return driver;
	}

	//Disabled Button
	public void buttonDisable() {
		System.out.println("Cannot proceed");
	}
	
	//simple wait
	public void simpleWait() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
}
