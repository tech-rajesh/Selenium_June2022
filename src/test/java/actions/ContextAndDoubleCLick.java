package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class ContextAndDoubleCLick {

	WebDriver driver;
	@BeforeTest
	public void launchApp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(4000);
		driver.close();
		
		
	}
	
	//@Test
    public void login() throws Exception {
        
    
		Actions act = new Actions(driver);
		
		WebElement rightClickButton = driver.findElement(By.xpath("//span[contains(text(),'right')]"));
		
		act.contextClick(rightClickButton).perform();
		
		WebElement deleteButton = driver.findElement(By.xpath("//span[contains(text(),'Delete')]"));
		deleteButton.click();
		
		
		System.out.println(driver.switchTo().alert().getText());
		
		
		driver.switchTo().alert().accept();
				
	}
	
	@Test
    public void doubleClickTest() throws Exception {
        
    
		Actions act = new Actions(driver);
		
		WebElement doubleClickButton = driver.findElement(By.xpath("//button[contains(text(),'Double')]"));
		
		act.doubleClick(doubleClickButton).perform();
		
		Thread.sleep(4000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
				
	}
	
	
}
