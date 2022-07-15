package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
		
		WebElement SignIn = driver.findElement(By.xpath("//*[contains(text(),'Hello, Sign')]"));	
		
		
		WebElement wishList = driver.findElement(By.xpath("//span[contains(text(),'Create a Wish List')]"));
		
//		act.moveToElement(SignIn).perform();
//		
//		act.click(wishList).perform();
		
		act.moveToElement(SignIn).click(wishList).perform();
		
	}
	
}
