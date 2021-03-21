package StepDefinition;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObjectModelMMT.LoginPageFactory;
import Util.HelperUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class EmailLoginStepDef {

	WebDriver driver;
	LoginPageFactory obj;
	int otp;
	String errText;
	HelperUtil utilObj = new HelperUtil();
	
	boolean temp;
	String winHandleBefore;
	WebElement err;
		
	public EmailLoginStepDef() {
		this.obj = new LoginPageFactory();
	}
	
	@Given("^User on MMT website for email login$")
    public void userOnMmtWebsiteForEmailLogin() throws IOException{
//    	obj = new GoogleLoginMMT(driver);
    	driver = obj.navigate();
    	System.out.println(driver.getTitle());
    	assertTrue(driver.getTitle().matches(obj.title));
    }
	
    @When("^User clicks on Login with Email$")
    public void userClicksOnLoginWithGoogle() {
//    	System.out.println("login with google");
    	
    	//handling login wrapper element
		try {
//			System.out.println("hey 1");
			obj.wrapperElement.getTagName();
//			System.out.println("hey 2");
		    temp = true;
		  }
		catch (org.openqa.selenium.NoSuchElementException e) {
		    temp = false;
		  }
		if(temp)
		{
//			System.out.println("in If");
			winHandleBefore = driver.getWindowHandle();
			
			utilObj.waitVisibilityOf(obj.loginCard).click();
		}
		else {
//			System.out.println("in else");
			obj.temp.click();
			obj.temp2.click();
			
			obj.loginbtn.click();
//			String winHandleBefore = driver.getWindowHandle();
			System.out.println(obj.MMTLoginForm.getText());
			obj.nameField.click();
		}
    }
    
    //Entering email ID from data table
    @And("^User enters the Email ID$")
    public void userEntersTheEmailID(DataTable uc) {
        
    	List<List<String>> ucdata = uc.raw();
        System.out.println(ucdata.get(0).get(0));
    	obj.username.sendKeys(ucdata.get(0).get(0));
		
    }
    
    //click button after entering email id
    @And ("^Email ID is correct$")
    public void emailIDIsCorrect(){
//    	System.out.println("Password entering");
    	obj.contiuneButton.click();
    }
    
    //Entering email password
    @And("^User enters the email password$")
    public void userEntersTheEmailPassword(DataTable uc) {
    	List<List<String>> ucdata = uc.raw();
        System.out.println(ucdata.get(0).get(0));
		utilObj.waitVisibilityOf(obj.password).sendKeys(ucdata.get(0).get(0));
    }
    
    //click button after entering password
    @And ("^Email password is correct$")
    public void emailPasswordIsCorrect(){
//    	System.out.println("Password entering");
    	obj.contiuneButton.click();
    	
    }
    
    //entering otp recieved on email
    @And("^User enters Otp$")
    public void userEntersOtp() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Please enter OTP");
    	otp = sc.nextInt();
    	sc.close();
    	String s=Integer.toString(otp);
    	obj.emailOtpTextField.sendKeys(s);
    	
    }
    
    //Click button after entering otp
    @And("^Otp is valid$")
    public void otpIsValid() {

		WebElement otpt = utilObj.waitVisibilityOf(obj.contiuneButton);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		otpt.click();
    }
    
    //Click button after entering otp then user is logged in
    @Then("^User is logged in via email$")
    public void userIsLoggedInViaEmail(){
    	obj.crossIcon.click();
        System.out.println("Logged in");
    }
    
    //Mail password is invalid, MMT displays an error message
    @And("^mail password is invalid$")
    public void mailPasswordIsInvalid() {
//    	boolean btn = obj.usrbtn.isEnabled();
//    	Assert.assertFalse(obj.usrbtn.isEnabled());
//    	System.out.println("Button is enabled: " + btn);
//    	driver.findElement(By.cssSelector(".modalMain")).click();;
    	obj.contiuneButton.click();
    	
    	err = utilObj.waitVisibilityOf(obj.emailPasswordError);
    	errText = err.getText();
    }
    
    //Email ID is invalid, MMT displays an error message
    @And("^Email ID is invalid$")
    public void emailIDIsInvalid() {
    	boolean btn = obj.contiuneButton.isEnabled();
    	Assert.assertFalse(obj.contiuneButton.isEnabled());
    	System.out.println("Button is enabled: " + btn);
    	driver.findElement(By.cssSelector(".modalMain")).click();
   
		err = utilObj.waitVisibilityOf(obj.emailError);
		errText = err.getText();
		assertTrue(errText.matches(obj.emailInvalidError));
    }
    
    //OTP is invalid, MMT displays an error message
    @And("^User enters Invalid Email Otp$")
    public void emailOtpIsInvalid(DataTable uc) {
    	List<List<String>> ucdata = uc.raw();
    	utilObj.waitVisibilityOf(obj.emailOtpTextField).sendKeys(ucdata.get(0).get(0));
//    	obj.emailOtpTextField.sendKeys(s);
    	String otp1 = ucdata.get(0).get(0);
    	//if length of OTP entered by user is less than 4 digits, 
    	//then button to login is disabled
    	if(otp1.length()<=3) {
    		errText = " ";
    	}
    	else {
    	
			WebElement otpt = utilObj.waitVisibilityOf(obj.contiuneButton);
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			otpt.click();
			err = utilObj.waitVisibilityOf(obj.emailError);
    	}
    }
    
    @Then("^Error message is displayed for Email$")
    public void errorMessageIsDisplayed() {
    	System.out.println("ERROR: "+errText);
    }
    
    //User leaves email ID field blank, button is disabled
    @And("^User leaves the Email ID blank$")
    public void emailIdBlank() {
    	boolean btn = obj.contiuneButton.isEnabled();
    	Assert.assertFalse(obj.contiuneButton.isEnabled());
    	System.out.println("Button is enabled: " + btn);
    }
    
    @Then("^button is disabled$")
    public void buttonDisabled() {
    	System.out.println("Cannot proceed");
    }
    
    //User leaves email password field blank, button is disabled
    @And("^User leaves the email password blank$")
    public void emailPasswordBlank() {

    	utilObj.waitVisibilityOf(obj.password);
    	boolean btn = obj.contiuneButton.isEnabled();
    	Assert.assertFalse(obj.contiuneButton.isEnabled());
    	System.out.println("Button is enabled: " + btn);
    } 
    
    //User leaves email Otp field blank, button is disabled
    @And("^User leaves the Otp blank$")
    public void emailOtpBlank() {

    	WebElement t1 = utilObj.waitVisibilityOf(obj.emailBlnkotpBtn);
    	boolean btn = t1.isEnabled();
    	Assert.assertFalse(obj.contiuneButton.isEnabled());
    	System.out.println("Button is enabled: " + btn);
    } 
}
