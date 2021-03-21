package StepDefinition;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObjectModelMMT.LoginPageFactory;
import Util.HelperUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleLoginStepDef {

	WebDriver driver;
	LoginPageFactory obj; //Page Factory object
	HelperUtil utilObj = new HelperUtil();
	
	
	boolean temp;
	String winHandleBefore;
	WebElement err;
	
	public GoogleLoginStepDef() {
		this.obj = new LoginPageFactory();  //invoking Page factory constructor
	}


	@Given("^User on MMT website$")
	public void userOnMMTWebsite() throws IOException{
		//    	obj = new GoogleLoginMMT(driver);
		driver = obj.navigate();
		System.out.println(driver.getTitle());
		assertTrue(driver.getTitle().matches(obj.title));
	}

	@When("^User clicks on Login with Google$")
	public void userClicksOnLoginWithGoogle() {
//		System.out.println("login with google");

		//handling Login Wrapper Element
		try {
			obj.wrapperElement.getTagName();
			temp = true;
		}
		catch (org.openqa.selenium.NoSuchElementException e) {
			temp = false;
//			System.out.println("in catch");
		}
		if(temp)
		{
//			System.out.println("in If");
			//			driver.getPageSource().contains("Login/Signup for Best Prices")
			winHandleBefore = driver.getWindowHandle();
			utilObj.waitVisibilityOf(obj.loginWithGoogleBtn).click();
		}
		else {
//			System.out.println("in else");
//			obj.temp.click();
//			obj.temp2.click();
			
			utilObj.waitVisibilityOf(obj.loginbtn).click();
			
			winHandleBefore = driver.getWindowHandle();
			System.out.println(obj.MMTLoginForm.getText());
			obj.nameField.click();
			
			utilObj.waitVisibilityOf(obj.loginWithGoogleOnForm).click();
		}
		
		//handling google button timeout exception
		try {

			
			driver = utilObj.windowHandler();

			utilObj.waitVisibilityOf(obj.googleNameTextBox);
			
		}
		
		catch(TimeoutException e) {

			utilObj.waitVisibilityOf(obj.loginWithGoogleOnForm).click();
		}
	}

	//Entering gmail account ID
	@And("^User enters the Gmail account ID \"([^\"]*)\"$")
	public void userEntersTheGmailAccountID(String email) {
//		System.out.println("Gmail id entering");

		//changing window 
		driver = utilObj.windowHandler();

		utilObj.waitVisibilityOf(obj.googleNameTextBox).sendKeys(email);
	}

	//Click button to continue after entering gmail ID
	@And("^Gmail account ID is correct$")
	public void gmailAccountIDIsCorrect() {
		
		obj.googleNameButton.click();

		driver = utilObj.windowHandler();
	}


	//Entering Gmail password
	@And ("^User enters the password \"([^\"]*)\"$")
	public void userEntersThePassword(String password){
//		System.out.println("Password entering");

		utilObj.waitVisibilityOf(obj.googlePasswordTextBox).sendKeys(password);

	}
	

	//click button to continue after entering password
	@And ("^Gmail password is correct$")
	public void gmailPasswordIsCorrect(){

		utilObj.waitClickable(obj.googlePasswordButton).click();
//		System.out.println("Logged in");
		driver.switchTo().window(winHandleBefore);
	}

	@Then("^User is logged in$")
	public void userIsLoggedIn(){
//		System.out.println("Logged in");
	}
	
	@But("^User should not see login button$")
	public void userShouldNotSeeLoginButton(){
		try {
			utilObj.waitVisibilityOf(obj.loginButtonOnLandingPage);
		}
		catch(TimeoutException e){
			System.out.println("Login button is not present");
		}
		
	}
	
	//after clicking button of gmail id page, it redirects to next password page
	@Then("^User is redirected to password page$")
	public void userIsRedirectedToPasswordPage(){

		WebElement temp = utilObj.waitVisibilityOf(obj.googlePasswordPage);
		System.out.println("On password page saying: "+ temp.getText());
	}
	
	
	//Entering gmail account ID
	@And("^User enters the Gmail account ID from POI$")
	public void userEntersTheGmailAccountIdPOI() throws IOException {
		
		XSSFSheet ws = utilObj.ReadExcel();
		driver.manage().window().maximize();

		driver = utilObj.windowHandler();
		

		utilObj.waitVisibilityOf(obj.googleNameTextBox).sendKeys(ws.getRow(0).getCell(0).toString());

	}

	//Entered Gmail ID is invalid, displays an error
	@And("^Gmail ID is invalid$")
	public void gmailIdIsInvalid() {
		obj.googleNameButton.click();

		err = utilObj.waitVisibilityOf(obj.errorOnInvalidGoogleName);
		assertTrue(err.getText().matches(obj.invalidGmailIdError));

	}
	
	//Leaving Gmail id field blank, displays an error
	@And("^User leaves the Gmail account ID blank$")
	public void gmailAccountIdBlank() {

		driver = utilObj.windowHandler();

		utilObj.waitVisibilityOf(obj.googleNameButton).click();
		
		err = utilObj.waitVisibilityOf(obj.errorOnBlankGoogleID);
		assertTrue(err.getText().matches(obj.blankGmailIdError));

	}
	

	@Then("^Error message is displayed$")
	public void errorMessageIsDisplayed() {
		
		System.out.println("ERROR: "+err.getText());
	}

	//Entered password is invalid, displays an error
	@And("^password is invalid$")
	public void passwordIsInvalid() {

		utilObj.waitRefreshedClickable(obj.googlePasswordButton).click();
		utilObj.simpleWait();
		err = utilObj.waitVisibilityOf(obj.errorOnInvalidGooglePassword);
		assertTrue(err.getText().matches(obj.invalidGmailPasswordError));
	}
	
	//Leaving Gmail password field blank, it displays an error
	@And("^User leaves the password blank$")
	public void passwordBlank() {
//		System.out.println("Password entering");
		
		utilObj.waitVisibilityOf(obj.googlePasswordTextBox);
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		utilObj.simpleWait();
		utilObj.waitRefreshedClickable(obj.googlePasswordButton).click();
		
		err = utilObj.waitVisibilityOf(obj.errorOnBlankGooglePassword);
		assertTrue(err.getText().matches(obj.blankGmailPasswordError));
	}
}
