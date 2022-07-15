package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMLOginTest {

	WebDriver driver;
	@BeforeTest
	public void launchApp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@AfterTest
	public void closeApp() {
		
		driver.close();
		
		
	}
	
	@Test
    public void login() {
        
        
        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.className("button")).click();
    }
    
    @Test
    public void logout() throws InterruptedException {
        
        driver.findElement(By.partialLinkText("Welcome")).click();;
        
        //Delay
        //Thread.sleep(4000);
        
        //conditional wait
        
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
        
        
        
        
        driver.findElement(By.linkText("Logout")).click();;
        Thread.sleep(4000);
    }
    
//    @Test
//    public void verifyAppTitle() {
//        System.out.println("Application title: " +driver.getTitle());
//        Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));
//    }
	
}
