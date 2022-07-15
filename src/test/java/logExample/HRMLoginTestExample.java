package logExample;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMLoginTestExample {

	WebDriver driver;
	Actions act;
	Logger log ;
	@BeforeTest
	public void launchApp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		log = Logger.getLogger("IBM_HRM_Login_Module");
		PropertyConfigurator.configure(".\\configFolder\\log4j.properties");
		
		
		log.info("Chrome browser launched....");
		
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		log.info("HRM Application launched successfully.");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		//Object 
		act = new Actions(driver);
		
		
	}
	
	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(4000);
		driver.close();
		log.info("browser closed successfully.");
		
	}

	
	@Test
	public void login() {
		log.info(".......Test Case: Login execution in progress.........");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		log.info("enter username ... Admin"  );
		
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		log.info("enter password ... admin123"  );
		
		driver.findElement(By.name("Submit")).click();
		log.info("click on Login button");
		
		//validate dashboard
		driver.findElement(By.tagName("h1")).isDisplayed();
		String verifyDashboard = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(verifyDashboard, "Dashboard");
		log.info("verification of DashBoard passed.");
		log.info("Text: ==============" + verifyDashboard);
		
		
		
	}
	
	@Test
	public void logout() {
		log.info(".......Test Case: Logout execution in progress.........");
		driver.findElement(By.partialLinkText("Welcome")).click();
		log.info("click on Welcome link");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Logo")));
		
		
		driver.findElement(By.partialLinkText("Logo")).click();
		log.info("click on Logout link");
		
		//validation of application url - https://opensource-demo.orangehrmlive.com/index.php/auth/login
		
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
		log.info("Validation of application url passed !!, applicationURL: " + driver.getCurrentUrl());
	}
}
