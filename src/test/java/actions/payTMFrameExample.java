package actions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class payTMFrameExample {

	WebDriver driver;
	@BeforeTest
	public void launchApp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://paytm.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(4000);
		driver.close();
		
		
	}
	
	@Test
    public void login() throws Exception {
        
		
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		
		//handle frame
		WebElement myFrame = driver.findElement(By.xpath("//iframe[contains(@src,'api/login')]"));
		
		
		
		//driver.switchTo().frame(0);   //indexing start form 0 
		driver.switchTo().frame(myFrame);
		
		
		//All element inside frame
		
        String heading = driver.findElement(By.cssSelector(".heading")).getText();
        System.out.println(heading);
        
        driver.findElement(By.xpath("//span[contains(text(),'Watch')]")).click();
        
        
        Thread.sleep(3000);
        
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);


        FileUtils.copyFile(screenshotFile, new File("./IBM_screenshot/payTM.png"));
        
        
    }
    
    
	
}
