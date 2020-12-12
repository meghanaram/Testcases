package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Airbnbtestcases {
	public static WebDriver driver;
	
	@BeforeTest
	public void setup() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	

    
	//Error Validation for firstName field and invalid characters
    @Test(priority=1)
	public void testcase1() throws InterruptedException {
    	driver.get("https://www.airbnb.co.in/");
		driver.findElement(By.className("_1sfnwgq")).click();
		driver.findElement(By.partialLinkText("Sign up")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("_bc4egv")).click();
		driver.findElement(By.id("email-signup-user[last_name]")).sendKeys("ghdf");
		driver.findElement(By.id("date")).sendKeys("01-30-1990");
		driver.findElement(By.id("email-signup-email")).sendKeys("abc@yopmail.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.className("_m9v25n")));	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String expected = "First name is required.";
		String actual = driver.findElement(By.id("email-signup-email__error")).getText();
		Assert.assertEquals(actual,expected);
		Thread.sleep(3000);
		
		driver.findElement(By.id("email-signup-user[first_name]")).sendKeys("123");
		js.executeScript("arguments[0].click();", driver.findElement(By.className("_m9v25n")));
		String expected1 = "Please use valid characters for your name.";
		String actual1 = driver.findElement(By.className("_1yhfti2")).getText();
		Assert.assertEquals(actual1,expected1);
		
		
		
	}
    
  //Error Validation for lastName field and invalid characters
    @Test(priority=2)
	public void testcase2() throws InterruptedException {
    	
    	driver.findElement(By.id("email-signup-user[last_name]")).clear();
		driver.findElement(By.id("email-signup-user[first_name]")).clear();
		driver.findElement(By.id("email-signup-user[first_name]")).sendKeys("anju12");
		driver.findElement(By.id("date")).sendKeys("01-30-1990");
		driver.findElement(By.id("email-signup-email")).sendKeys("abc@yopmail.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.className("_m9v25n")));	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String expected2 = "Last name is required.";
		String actual2 = driver.findElement(By.className("_1yhfti2")).getText();
		Assert.assertEquals(actual2,expected2);
		Thread.sleep(3000);
		
		driver.findElement(By.id("email-signup-user[last_name]")).sendKeys("123");
		js.executeScript("arguments[0].click();", driver.findElement(By.className("_m9v25n")));
		String expected3 = "Please use valid characters for your name.";
		String actual3 = driver.findElement(By.className("_1yhfti2")).getText();
		Assert.assertEquals(actual3,expected3);
		
	}
	
  //Error Validation for email field and invalid inputs
	@Test(priority=3)
	public void testcase3() throws InterruptedException {

		driver.findElement(By.id("email-signup-user[last_name]")).clear();
		driver.findElement(By.id("email-signup-user[last_name]")).sendKeys("megha12");
		driver.findElement(By.id("date")).sendKeys("01-30-1990");
		driver.findElement(By.id("email-signup-email")).clear();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.className("_m9v25n")));	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String expected2 = "Email is required.";
		String actual2 = driver.findElement(By.className("_1yhfti2")).getText();
		Assert.assertEquals(actual2,expected2);
		Thread.sleep(3000);
		
		driver.findElement(By.id("email-signup-email")).sendKeys("123");
		js.executeScript("arguments[0].click();", driver.findElement(By.className("_m9v25n")));
		String expected3 = "Enter a valid email.";
		String actual3 = driver.findElement(By.className("_1yhfti2")).getText();
		Assert.assertEquals(actual3,expected3);
		
	}
	
	//Error Validation for password field and invalid inputs 
	@Test(priority=4)
	public void testcase4() throws InterruptedException {
	    driver.findElement(By.id("email-signup-email")).clear();
		driver.findElement(By.id("email-signup-email")).sendKeys("anju12@yopmail.com");	
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.findElement(By.id("email-signup-password")).clear();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.className("_m9v25n")));	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String expected2 = "Password is required.";
		String actual2 = driver.findElement(By.className("_1yhfti2")).getText();
		Assert.assertEquals(actual2,expected2);
		Thread.sleep(3000);
		
		driver.findElement(By.id("email-signup-password")).sendKeys("anna");
		js.executeScript("arguments[0].click();", driver.findElement(By.className("_m9v25n")));	
		String expected3 = "Your password must be at least 8 characters. Please try again.";
		String actual3 = driver.findElement(By.className("_1yhfti2")).getText();
		Assert.assertEquals(actual3,expected3);
		Thread.sleep(3000);
        
		driver.findElement(By.id("email-signup-password")).clear();
		driver.findElement(By.id("email-signup-password")).sendKeys("bella");
		js.executeScript("arguments[0].click();", driver.findElement(By.className("_m9v25n")));
		String expected4 = "Your password isn’t strong enough. Try making it longer or adding symbols, like !, #, or %.";
		String actual4 = driver.findElement(By.className("_1yhfti2")).getText();
		Assert.assertEquals(actual4,expected4);
		Thread.sleep(8000);
		
	}
	
	//Error Validation for date field and invalid inputs
	@Test(priority=5)
	public void testcase5() throws InterruptedException {
		driver.findElement(By.id("date")).sendKeys("01-30-yyyy");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.className("_1wzgqhq")));	
		String expected6 = "Date of birth is invalid.";
		String actual6 = driver.findElement(By.className("_1yhfti2")).getText();
		Assert.assertEquals(actual6,expected6);
		Thread.sleep(3000);
	
		driver.findElement(By.id("date")).clear();
		driver.findElement(By.id("date")).sendKeys("2016");
		js.executeScript("arguments[0].click();", driver.findElement(By.className("_1wzgqhq")));	
		String expected7 = "You must be 18 or older to use Airbnb. Other people won’t see your birthday.";
		String actual7 = driver.findElement(By.className("_1yhfti2")).getText();
		Assert.assertEquals(actual6,expected6);
		Thread.sleep(3000);
		
		driver.findElement(By.id("date")).clear();
		js.executeScript("arguments[0].click();", driver.findElement(By.className("_1wzgqhq")));	
     	String expected8 = "Select your date of birth to continue.";
		String actual8 = driver.findElement(By.className("_1yhfti2")).getText();
		Assert.assertEquals(actual6,expected6);
    	Thread.sleep(8000);	
	
		
}
	
	//Validating Successful SignUp using yopmail
	    @Test(priority=6)
		public void testcase6() throws InterruptedException {
	    	driver.findElement(By.id("email-signup-email")).clear();
	    	driver.findElement(By.id("email-signup-email")).sendKeys("anju@yopmail.com");
			driver.findElement(By.id("date")).sendKeys("01-30-1990");
			driver.findElement(By.id("email-signup-password")).sendKeys("12&");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", driver.findElement(By.className("_1wzgqhq")));	
			Thread.sleep(8000);
			
			//validating to dignup
			driver.findElement(By.className("_fmle54")).isDisplayed();
		}
    

    @AfterTest
	public void teardown() throws Exception {
		driver.quit();
	}

}
