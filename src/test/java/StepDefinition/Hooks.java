package StepDefinition;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Util.HelperUtil;
//import PageObjectModelMMT.LoginMMT;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	//Hey 2nd commit
	public static WebDriver driver;
	//	GoogleLoginMMT obj = new GoogleLoginMMT(driver);

	HelperUtil utilObj = new HelperUtil();
	//For launching web driver
	@Before()
	public void setUp() throws IOException{ 
		Properties prop = utilObj.readPropertyFile();
		String driverPath = prop.getProperty("driverPath");
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver(); 
		System.out.println("Launching browser"); 
	} 

	//For closing Web Driver
	@After()
	public void close() {
		//		driver.close();
		System.out.println("driver closed successfully");
	}
}









//https://github.com/luciemars/cucumber-java-selenium-webdriver-example
