package StepDefinition;

import static org.junit.Assert.assertTrue;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObjectModelMMT.LoginPageFactory;
import Util.HelperUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FBLoginStepDef {

	WebDriver driver;
	LoginPageFactory obj;

	boolean temp;
	String winHandleBefore;
	WebElement err; 
	HelperUtil utilObj = new HelperUtil();

	public FBLoginStepDef() {
		this.obj = new LoginPageFactory();
	}


	@Given("^User on MMT website for FB Login$")
	public void userOnMmtWebsiteFB() throws IOException{
		//    	obj = new GoogleLoginMMT(driver);
		driver = obj.navigate();
		System.out.println(driver.getTitle());
		assertTrue(driver.getTitle().matches(obj.title));
	}

	@When("^User clicks on Login with Facebook$")
	public void userClicksOnLoginWithFacebook() {
//		System.out.println("login with FB");

		//handling login wrapper element
		try {
			obj.wrapperElement.getTagName();
			temp = true;
		}
		catch (org.openqa.selenium.NoSuchElementException e) {
			temp = false;
		}
		if(temp)
		{
//			System.out.println("in If");
			winHandleBefore = driver.getWindowHandle();	
			utilObj.waitVisibilityOf( obj.loginWithFBButton).click();
			
		}
		else {
			System.out.println("in else");
//			obj.temp.click();
//			obj.temp2.click();
			obj.loginbtn.click();
			winHandleBefore = driver.getWindowHandle();
//			System.out.println(obj.MMTLoginForm.getText());
			obj.nameField.click();
//			boolean te = driver.findElement(By.cssSelector(".modalMain")).isDisplayed();
//			System.out.println(te);
			WebElement btn = utilObj.waitVisibilityOf( obj.loginWithFBButtonOnForm);
			btn.click();
			
		}
		
		try {

			driver = utilObj.windowHandler();			
			utilObj.waitVisibilityOf( obj.FBEmailTextBox);
		}
		
		catch(TimeoutException e) {	
			utilObj.waitClickable( obj.loginWithFBButtonOnForm).click();
		}
	}

	//user enters Facebook ID and password
	@And("^User enters the FB ID \"([^\"]*)\" and FB password \"([^\"]*)\"$")
	public void userEntersTheFbId(String email, String password) throws IOException {
//		System.out.println("FB id entering");
		driver = utilObj.windowHandler();		
		utilObj.waitVisibilityOf( obj.FBEmailTextBox).sendKeys(email);
		utilObj.waitVisibilityOf(obj.FBPasswordTextBox).sendKeys(password);		
	}

	//Click button to continue after entering correct credentials.
	@And("^Both are correct$")
	public void bothAreCorrect() {
		obj.FbLoginButton.click();
		driver = utilObj.windowHandler();
	}

	//User is logged in after correct credentials
	@Then("^User is logged in via FB$")
	public void userIsLoggedInViaFb(){
//		try {
////			WebDriverWait wait3=new WebDriverWait(driver, 50);
////			WebElement frm = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]/section")));
////			frm.click();
//			driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]/section"));
//			driver.findElement(By.cssSelector(".crossIcon")).click();
//		}
//		catch (org.openqa.selenium.NoSuchElementException e) {
//			temp = false;
//		}
		driver.switchTo().window(winHandleBefore);
		WebElement uname = utilObj.waitRefreshedClickable( obj.loggedin);
    	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
    	
		System.out.println("Logged in" + uname.getText());
//		WebDriverWait wait3=new WebDriverWait(driver, 20);
//		
//		WebElement frm = wait3.until(ExpectedConditions.elementToBeClickable(By.id("fromCity")));
//		frm.click();
//		driver.findElement(By.cssSelector("#fromCity")).click();
//		
//		driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div[2]/div/div/div/div/div/div/input")).sendKeys("Indore");
//
//		driver.findElement(By.xpath("//p[text()='Indore, India']")).click();
//		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/input")).sendKeys("Mumbai");
//		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
//		driver.findElement(By.cssSelector("div.DayPicker-Week:nth-child(6) > div:nth-child(1) > div:nth-child(1) > p:nth-child(1)")).click();
//		System.out.println("Entered Depart date");
//		driver.findElement(By.cssSelector(".primaryBtn")).click();
//		System.out.println("Navigated to next page");
	}

	//Entered Facebook ID is incorrect, displays an error message
	@And("^FB Email ID is incorrect$")
	public void emailIdIsIncorrect() {
//		driver.findElement(By.id("u_0_0")).click();
		obj.FbLoginButton.click();
		err=utilObj.waitVisibilityOf(obj.FBEmailError);
		//validating error message
		assertTrue(err.getText().matches(obj.invalidFbIdError));
//		assertTrue(err.getText().matches("Wrong credentials"));
	}

	@Then("^Error message is displayed for FB$")
	public void errorMessageIsDisplayed() {
		System.out.println("ERROR: "+err.getText());
	}

	//Entered password is incorrect, displays an error message
	@And("^FB password is incorrect$")
	public void fbPasswordIsInvalid() {
//		driver.findElement(By.id("u_0_0")).click();
		obj.FbLoginButton.click();
		err = utilObj.waitVisibilityOf(obj.FBEmailError);		
		//asserting error message
		assertTrue(err.getText().matches(obj.invalidFbPasswordError));
//		assertTrue(err.getText().matches("Wrong credentials"));
	}
	
	//leaving Facebook ID field blank, gets an error message
	@And("^User leaves the FB ID blank and enter FB password")
	public void userEntersTheFbId() throws IOException {
//		System.out.println("FB id entering");

		XSSFSheet ws = utilObj.ReadExcel();

		driver = utilObj.windowHandler();
		utilObj.waitVisibilityOf( obj.FBEmailTextBox);
		
		utilObj.waitVisibilityOf( obj.FBPasswordTextBox).sendKeys(ws.getRow(2).getCell(0).toString());
		
		obj.FbLoginButton.click();

		driver = utilObj.windowHandler();
		err = utilObj.waitVisibilityOf( obj.FBEmailError);
		//asserting error message
		assertTrue(err.getText().matches(obj.invalidFbIdError));
//		assertTrue(err.getText().matches("Wrong credentials"));
	}
	
	//leaving Facebook password field blank, gets an error message.
	@And("^User enters the FB ID and FB password left blank$")
	public void userLeavesFBpasswordBlank() throws IOException {
//		System.out.println("FB id entering");
		XSSFSheet ws = utilObj.ReadExcel();		
		driver = utilObj.windowHandler();
		
		utilObj.waitVisibilityOf( obj.FBEmailTextBox).sendKeys(ws.getRow(2).getCell(1).toString());
		
		utilObj.waitVisibilityOf( obj.FBPasswordTextBox);
		
		obj.FbLoginButton.click();
		err = utilObj.waitVisibilityOf( obj.FBEmailError);
		assertTrue(err.getText().matches(obj.invalidFbPasswordError));
//		assertTrue(err.getText().matches("Wrong credentials"));
	}
}
