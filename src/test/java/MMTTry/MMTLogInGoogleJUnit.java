package MMTTry;

//import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MMTLogInGoogleJUnit {

	@Test
	public void main1() throws TimeoutException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","C:\\Geckodriver\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.navigate().to("https://www.makemytrip.com/");
//		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		boolean temp;
		try {
		    driver.findElement(By.cssSelector(".autopop__wrap"));
		    temp = true;
		  }
		catch (org.openqa.selenium.NoSuchElementException e) {
		    temp = false;
		  }
		if(temp)
		{
			System.out.println("in If");
//			driver.getPageSource().contains("Login/Signup for Best Prices")
			String winHandleBefore = driver.getWindowHandle();
			WebDriverWait wait=new WebDriverWait(driver, 100);
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".googleLoginBtn")));
			driver.findElement(By.cssSelector(".googleLoginBtn")).click();
//			System.out.println(driver.findElement(By.cssSelector("span.font26")).getText());
			driver.manage().window().maximize();
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			WebDriverWait wait3=new WebDriverWait(driver, 100);
	    	wait3.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
			
			driver.findElement(By.name("identifier")).sendKeys("test.mmt.test.test");
			driver.findElement(By.cssSelector(".VfPpkd-LgbsSe-OWXEXe-k8QpJ > div:nth-child(3)")).click();
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			WebDriverWait wait1=new WebDriverWait(driver, 100);
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")));
			driver.findElement(By.cssSelector("#password > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")).sendKeys("Test@test.test");
			WebDriverWait wait2=new WebDriverWait(driver, 100);
			WebElement lbtn = wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".VfPpkd-LgbsSe-OWXEXe-k8QpJ > div:nth-child(3)")));
	    	lbtn.click();
//			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/div[2]")).click();
			System.out.println("Logged in");
			driver.switchTo().window(winHandleBefore);
			
		}
		else {
			System.out.println("in else");
		driver.findElement(By.cssSelector("li.makeFlex:nth-child(7) > div:nth-child(1)")).click();
		driver.findElement(By.cssSelector("p.ctryListItem:nth-child(1)")).click();
//		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.cssSelector("li.makeFlex:nth-child(6)")).click();
		String winHandleBefore = driver.getWindowHandle();
		System.out.println(driver.findElement(By.cssSelector("span.font26")).getText());
		driver.findElement(By.cssSelector(".modalMain")).click();
		WebDriverWait wait=new WebDriverWait(driver, 100);
		WebElement gbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".googleLoginBtn")));
		gbtn.click();
		
		driver.manage().window().maximize();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		WebDriverWait wait3=new WebDriverWait(driver, 100);
		WebElement name = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		name.sendKeys("test.mmt.test.test");
		
		driver.findElement(By.cssSelector(".VfPpkd-LgbsSe-OWXEXe-k8QpJ > div:nth-child(3)")).click();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		WebDriverWait wait1=new WebDriverWait(driver, 100);
		WebElement pwd = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")));
		pwd.sendKeys("Test@test.test");
		WebDriverWait wait2=new WebDriverWait(driver, 100);
    	WebElement lbtn = wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".VfPpkd-LgbsSe-OWXEXe-k8QpJ > div:nth-child(3)")));
    	lbtn.click();
		
//		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/div[2]")).click();
		System.out.println("Logged in");
		driver.switchTo().window(winHandleBefore);
		}
		
		driver.close();
		
	}
}
