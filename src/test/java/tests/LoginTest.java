package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BaseTest{

	
	
	@Test
	public void verifyLoginFeature() throws Exception {
		
		
		lp.enterUserName("admin@yourstore.com");
		lp.enterPassword("admin");
		lp.clickLoginButton();
		
		//validate Step
		lp.verifyAppTitle(driver.getTitle(), "Dashboard / nopCommerce administration");
		
		
//		driver.findElement(By.name("Email")).sendKeys("values to send");
//		Thread.sleep(4000);
//		driver.findElement(By.cssSelector("input#Password")).sendKeys("values to send");
//		driver.findElement(By.tagName("button")).click();
	}
	
}
