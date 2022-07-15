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

public class DragDropTest {

	WebDriver driver;
	@BeforeTest
	public void launchApp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
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
        
    
		Actions action = new Actions(driver);
		
		WebElement dragDropFrame = driver.findElement(By.xpath("//iframe[contains(@data-src,'photo-manager')]"));
		
		
		driver.switchTo().frame(dragDropFrame);
		
		WebElement img3 = driver.findElement(By.xpath("//img[contains(@src,\"high_tatras3\")]"));
		WebElement img4 = driver.findElement(By.xpath("//img[contains(@src,\"high_tatras4\")]"));
		WebElement trash = driver.findElement(By.cssSelector("div#trash"));
		
		
		//method1
//		Thread.sleep(2000);
//		action.dragAndDrop(img3, trash).perform();
//		Thread.sleep(2000);
//		action.dragAndDrop(img4, trash).perform();
//		
		
		
//		Method2
//		A convenience method that performs click-and-hold at the location of the source element, 
//		moves to the location of the target element, then releases the mouse.
		
		action.clickAndHold(img3).moveToElement(trash).release().build().perform();
		action.clickAndHold(img3).moveToElement(trash).release().perform();
		
		
		
	}
	
}
