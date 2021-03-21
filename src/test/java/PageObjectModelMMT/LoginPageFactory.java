package PageObjectModelMMT;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import StepDefinition.Hooks;

public class LoginPageFactory {


	public WebDriver driver;
	//    public By glogin = By.cssSelector(".googleLoginBtn");
	//    public By pwin = By.cssSelector(".autopop__wrap");
	//    public By temp = By.cssSelector("li.makeFlex:nth-child(7) > div:nth-child(1)");
	//    public By temp2 = By.cssSelector("p.ctryListItem:nth-child(1)");
	//    public By loginbtn = By.cssSelector("li.makeFlex:nth-child(6)");
	//    public By gname = By.name("identifier");
	//    public By gnamebtn = By.cssSelector(".VfPpkd-LgbsSe-OWXEXe-k8QpJ > div:nth-child(3)");
	//    public By gpwd = By.cssSelector("#password > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)");
	//    public By gpwdbtn = By.cssSelector(".VfPpkd-LgbsSe-OWXEXe-k8QpJ > div:nth-child(3)");



	//Login with Google
	@FindBy(css=".googleLoginBtn")
	public WebElement loginWithGoogleBtn; // glogin;
	//	@FindBy(how=How.CSS,using=".googleLoginBtn")
	//	 public WebElement glogin;

	@FindBy(css=".autopop__wrap")
	public WebElement wrapperElement;// pwin;

	@FindBy(css="li.makeFlex:nth-child(7) > div:nth-child(1)")
	public WebElement temp;

	@FindBy(css="p.ctryListItem:nth-child(1)")
	public WebElement temp2;

	@FindBy(css="span.font26")
	public WebElement MMTLoginForm; // temp3;

	@FindBy(css=".modalMain")
	public WebElement nameField;// temp4;

	@FindBy(css="li.makeFlex:nth-child(6)")
	public WebElement loginbtn;

	@FindBy(xpath="//div[@class='makeFlex googleLoginBtn flexOne']")
	public WebElement loginWithGoogleOnForm; //gloginbtn;


	@FindBy(name="identifier")
	public WebElement googleNameTextBox;// gname; 
	//	@FindBy(how=How.NAME,using="identifier")
	//	 public WebElement gname;

	@FindBy(css=".VfPpkd-LgbsSe-OWXEXe-k8QpJ > div:nth-child(3)")
	public WebElement googleNameButton;// gnamebtn;

	@FindBy(css="#password > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")
	public WebElement googlePasswordTextBox;//gpwd;

	//	@FindBy(css=".VfPpkd-LgbsSe-OWXEXe-k8QpJ > div:nth-child(3)")
	//	public WebElement gpwdbtn;
	//	
	@FindBy(xpath="//div[@class='VfPpkd-RLmnJb']")
	public WebElement googlePasswordButton;// gpwdbtn;

	@FindBy(css="#view_container > div > div > div.pwWryf.bxPAYd > div > div.WEQkZc > div > form > span > section > div > div > div.d2CFce.cDSmF.cxMOTc > div > div.LXRPh > div.dEOOab.RxsGPe > div")
	public WebElement errorOnInvalidGoogleName;// errnm;

	@FindBy(css="#view_container > div > div > div.pwWryf.bxPAYd > div > div.WEQkZc > div > form > span > section > div > div > div.SdBahf.VxoKGd.Jj6Lae > div.OyEIQ.uSvLId > div:nth-child(2) > span")
	public WebElement errorOnInvalidGooglePassword; //errpw

	@FindBy(css="#headingText > span:nth-child(1)")
	public WebElement googlePasswordPage;//googlepwdpg;

	@FindBy(xpath="//div[@class='o6cuMc']")
	public WebElement errorOnBlankGoogleID;//blankgid;

	@FindBy(css="#view_container > div > div > div.pwWryf.bxPAYd > div > div.WEQkZc > div > form > span > section > div > div > div.SdBahf.VxoKGd.Jj6Lae > div.OyEIQ.uSvLId > div:nth-child(2) > span")
	public WebElement errorOnBlankGooglePassword;//blankgpwd;

	
	
	//Login with email
	@FindBy(css=".login__card")
	public WebElement loginCard;//logcard;

	@FindBy(css="#username")
	public WebElement username;

	@FindBy(css="button.capText")
	public WebElement contiuneButton;// usrbtn;

	@FindBy(css="#password")
	public WebElement password;

	@FindBy(css=".crossIcon")
	public WebElement crossIcon;

	@FindBy(css="#otp")
	public WebElement emailOtpTextField;//otp;

	@FindBy(xpath="//span[text()='Either Username or Password is incorrect.']")
	public WebElement emailPasswordError;//emailpassErr;

	@FindBy(xpath="//p[@class='validity font12 redText appendTop5 makeFlex']")
	public WebElement emailError;//emailErr;

	@FindBy(css="#SW > div.landingContainer > div.headerOuter > div.modal.displayBlock.modalLogin.modalResetPass.personal > section > form > div.btnContainer.appendBottom25.disabled > button")
	public WebElement emailBlnkotpBtn;
	
	
	
	//Login with phone


	@FindBy(id="otp")
	public WebElement mobileOTPTextField;//mobotp;

	@FindBy(xpath="//button[@class='capText font16']")
	public WebElement mobileOTPButton;// mobotpbtn;

	@FindBy(css=".redText > span:nth-child(2)")
	public WebElement mobilePhoneError;//phoneerr;

	@FindBy(xpath="//p[@class='validity font12 redText appendTop5 makeFlex']")
	public WebElement phoneOTPError;// phoneotperr;

	@FindBy(css=".drop-down")
	public WebElement countryCodeDropDown;// ccdrpdwn;

	@FindBy(id="enterCountry")
	public WebElement countryCodeTextField;// entrcc;

//	@FindBy(css="#SW > div.landingContainer > div.headerOuter > div.modal.displayBlock.modalLogin.dynHeight.personal > section > form > div.modalField.makeFlex.column.appendBottom20 > div > div > div > div > div:nth-child(5)")
//	public WebElement cntry;
	
	@FindBy(xpath="//span[text()='United States']")
	public WebElement country;//cntry;

	//Login with FB

	@FindBy(css=".fbLoginBtn")
	public WebElement loginWithFBButton;// fbbtn;

	@FindBy(xpath="//div[@class='makeFlex fbLoginBtn flexOne appendRight20']")
	public WebElement loginWithFBButtonOnForm;//fbbtn1;
	
	@FindBy(id="u_0_0")
	public WebElement FbLoginButton;//fbloginbtn;

	//	@FindBy(xpath="//span[text()='Login with Facebook']")
	//	public WebElement fbbtn1;

	@FindBy(id="email")
	public WebElement FBEmailTextBox;// fbemail;

	@FindBy(id="pass")
	public WebElement FBPasswordTextBox;//fbpass;

	@FindBy(xpath="//div[@class='fsl fwb fcb']")
	public WebElement FBEmailError;//femailerr;


	//Username on Home page after login
	@FindBy(css="p.truncate")
	public WebElement loggedin;
	
	//login button on landing page
	@FindBy(xpath="//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser']")
	public WebElement loginButtonOnLandingPage;
	
	//title
	public String title = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
	
	//
//	gmail id invalid error
	public String invalidGmailIdError = "Enter a valid email or phone number";
	
	//blank gmail id error
	public String blankGmailIdError = "Enter an email or phone number";
	
	//invalid gmail password error
	public String invalidGmailPasswordError = "Wrong password. Try again or click Forgot password to reset it.";
	
	//blank gmail password error
	public String blankGmailPasswordError = "Enter a password";
	
	//email Id invalid error;
	public String emailInvalidError = "Please enter a valid Email Id or Mobile Number.";
	
	//facebook email id invalid error
	public String invalidFbIdError = "Incorrect email address or phone number"; //Wrong credentials
	
	//facebook password invalid error
	public String invalidFbPasswordError = "Please re-enter your password";
	
	//Mobile OTP invalid error
	public String invalidOtpError = "Incorrect OTP! Please enter the OTP delivered to you.";
	
	//invalid Mobile error
	public String invalidMobileError = "Invalid phone number";
	
	//initialising driver
	public LoginPageFactory(){
		this.driver = Hooks.driver;
		PageFactory.initElements(driver, this);

	}
	

	//get Application URL
	public WebDriver navigate() {
		driver.get("https://www.makemytrip.com/"); 
		System.out.println("Launching MMT Application");
		return driver;
	}
	
	public void country(String cntry) {
		driver.findElement(By.xpath("//span[text()='"+cntry+"']")).click();
	}
}







//FB ---- +4407410583715
