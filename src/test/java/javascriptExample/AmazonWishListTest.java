package javascriptExample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonWishListTest extends BaseTest{

	
	@Test
	public void wishList() {
		
		WebElement modal = driver.findElement(By.xpath("//button[contains(text(),'modal')]"));	
		
		
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("arguments[0].click();", modal);
		
		//modal.click();
		
		
		
	}
	
}
