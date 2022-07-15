package logExample;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMLoginTest {
	
	
	WebDriver driver;
	Logger log ;

	@BeforeTest
	public void launchApp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		//COnfig File
		
		log = Logger.getLogger("Org_Automation_Logger");
		PropertyConfigurator.configure("./configFolder/log4j.properties");
		
		
		log.info("Chrome Browser Launch Sucessfully");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		log.info("Orange HRM application Launch Sucessfully in chrome browser");
	
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
		log.info("Closing chrome browser");
		// close/quit

	}
	
	
	@Test(priority = 1)
	public void login() {
		log.info("enter user Name - Admin");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		log.info("enter password  - admin123");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		log.info("click on Login button");
		driver.findElement(By.name("Submit")).click();
		
	}
	
	

	@Test(priority = 2)
	public void logout() {
		log.info("Validate Dashboard after login");
		
		String actualText = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(actualText, "Dashboard");
		
		log.info("click on Welcome");
		
		driver.findElement(By.partialLinkText("Welcome")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		
		log.info("click on Logout");
		driver.findElement(By.linkText("Logout")).click();
		
		
	}

}
