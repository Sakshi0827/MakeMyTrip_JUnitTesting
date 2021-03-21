package StepDefinition;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObjectModelMMT.LoginPageFactory;
import Util.HelperUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MobileLoginStepDef {

	WebDriver driver;
	LoginPageFactory obj;
	HelperUtil utilObj = new HelperUtil();

	boolean temp;
	String winHandleBefore;
	WebElement err;

	public MobileLoginStepDef() {
		this.obj = new LoginPageFactory();
	}

	@Given("^User on MMT website for Phone Number login$")
	public void userOnMmtWebsiteForPhoneNumberLogin() throws IOException {
		//    	obj = new GoogleLoginMMT(driver);
		driver = obj.navigate();
		System.out.println(driver.getTitle());
		assertTrue(driver.getTitle().matches(obj.title));
	}

	@When("^User clicks on Login with Phone Number$")
	public void userClicksOnLoginWithPhoneNumber() {
		System.out.println("login with phone number");

		//Handling login wrapper
		try {
			//			System.out.println("hey 1");
			obj.wrapperElement.getTagName();
			//			System.out.println("hey 2");
			temp = true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			temp = false;
		}
		if (temp) {
			//			System.out.println("in If");
			winHandleBefore = driver.getWindowHandle();
			utilObj.waitVisibilityOf(obj.loginCard).click();
		} else {
			//			System.out.println("in else");
			obj.temp.click();
			obj.temp2.click();
			obj.loginbtn.click();
			//			String winHandleBefore = driver.getWindowHandle();
			System.out.println(obj.MMTLoginForm.getText());
			obj.nameField.click();
		}
	}

	//Entering phone number
	@And("^User enters the phone number$")
	public void userEntersThePhoneNumber(DataTable uc) {

		List<List<String>> ucdata = uc.raw();
		System.out.println(ucdata.get(0).get(2));
		obj.username.sendKeys(ucdata.get(0).get(2));
		// country code
		obj.countryCodeDropDown.click();
		obj.countryCodeTextField.sendKeys(ucdata.get(0).get(0));
		// select country code
		obj.country(ucdata.get(0).get(1));

	}

	//Entered phone number is valid, click button to continue
	@And("^phone number is valid$")
	public void phoneNumberIsValid() {
		obj.contiuneButton.click();
	}

	//Entering mobile Otp
	@And("^User enters mobile Otp$")
	public void userEntersMobileOtp() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter OTP");
		int otp = sc.nextInt();
		String s = Integer.toString(otp);
		utilObj.simpleWait();
		obj.mobileOTPTextField.sendKeys(s);
		sc.close();
	}

	//Entered Otp is valid, click button to continue
	@And("^Mobile Otp is valid$")
	public void mobileOtpIsValid() {

		WebElement otpt = utilObj.waitVisibilityOf(obj.mobileOTPButton);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		otpt.click();
	}

	@Then("^User is logged in via Mobile$")
	public void userIsLoggedInViaMobile() {

		WebElement uname = utilObj.waitVisibilityOf(obj.loggedin);
		System.out.println("User" + uname.getText() + "Logged in");

		//		WebDriverWait wait3=new WebDriverWait(driver, 20);
		//		WebElement frm = wait3.until(ExpectedConditions.elementToBeClickable(By.id("fromCity")));
		//		frm.click();
		//		driver.findElement(By.cssSelector("#fromCity")).click();
		//		String dd= driver.findElement(By.cssSelector("#root > div > div.minContainer > div > div > div.makeFlex > ul > li.selected")).getAttribute("checked");
		//		
		//		System.out.println(dd);
		//		driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div[2]/div/div/div/div/div/div/input")).sendKeys("idr");
		//
		//		driver.findElement(By.xpath("//p[text()='Indore, India']")).click();
		//		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//		driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/input")).sendKeys("bom");
		//		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		//		driver.findElement(By.cssSelector("div.DayPicker-Week:nth-child(6) > div:nth-child(1) > div:nth-child(1) > p:nth-child(1)")).click();
		//		System.out.println("Entered Depart date");
		//		driver.findElement(By.cssSelector(".primaryBtn")).click();
		//		System.out.println("Navigated to next page");
		//		
		//		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		//		WebElement nxt = wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.wdh_half:nth-child(1) > label:nth-child(2) > span:nth-child(1)")));
		//		nxt.click();
		//		
		//		WebDriverWait wait2=new WebDriverWait(driver, 20);
		//		WebElement nxt1 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='View Prices']")));
		//		nxt1.click();
		//		driver.findElement(By.xpath("//button[text()='Book Now']")).click();
	}


	//

	//Entered Mobile otp is invalid, it displays an error
	@And("^User enters invalid mobile Otp$")
	public void invalidOtp(DataTable uc) {
		List<List<String>> ucdata = uc.raw();
		utilObj.waitVisibilityOf(obj.mobileOTPTextField).sendKeys(ucdata.get(0).get(0));;
		//		obj.mobileOTPTextField.sendKeys(s);

		obj.contiuneButton.click();


		err = utilObj.waitVisibilityOf(obj.phoneOTPError);

		assertTrue(err.getText().matches(obj.invalidOtpError));
	}
	
//	@And("^Mobile Otp is invalid$")
//	public void mobileOtpIsInvalid() {
//		//    	boolean btn = obj.usrbtn.isEnabled();
//		//    	Assert.assertFalse(obj.usrbtn.isEnabled());
//		//    	System.out.println("Button is enabled: " + btn);
//		//    	driver.findElement(By.cssSelector(".modalMain")).click();;
//		obj.contiuneButton.click();
//
//
//		err = utilObj.waitVisibilityOf(obj.phoneOTPError);
//
//		assertTrue(err.getText().matches(obj.invalidOtpError));
//	}

	//Entered phone number is invalid, it displays an error
	@And("^phone number is invalid$")
	public void phoneNumberIsInvalid() {

		utilObj.waitClickable(obj.contiuneButton).click();


		err = utilObj.waitVisibilityOf(obj.mobilePhoneError);
		assertTrue(err.getText().matches(obj.invalidMobileError));
	}

	//User leaves phone number field blank, button is disabled
	@And("^User leaves the phone number blank$")
	public void phoneNoBlank() {
		boolean btn = obj.contiuneButton.isEnabled();
		Assert.assertFalse(obj.contiuneButton.isEnabled());
		System.out.println("Button is enabled: " + btn);
	}

	//User leaves mobile OTP field blank, button is disabled
	@And("^User leaves mobile Otp blank$")
	public void phoneOtpBlank() {

		utilObj.waitVisibilityOf(obj.mobileOTPButton);
		boolean btn = obj.mobileOTPButton.isEnabled();
		//    	Assert.assertFalse(obj.mobotpbtn.isEnabled());
		System.out.println("Button is enabled: " + btn);
	}

	@Then("^Error message is displayed for phone$")
	public void errorMessageIsDisplayedForPhone() {
		System.out.println("Error during invalid credential: \"" + err.getText() + "\"");
	}

	@Then("^button to continue with blank phone number is disabled$")
	public void phoneButtonDisabled() {
		utilObj.buttonDisable();
	}

	@Then("^button to continue with blank otp is disabled$")
	public void buttonToContinueWithBlankOtpIsDisabled() {
		utilObj.buttonDisable();
	}

}
