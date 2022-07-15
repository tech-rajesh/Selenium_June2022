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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonWishListTakeScreenshot extends BaseTest{

	
	@Test
	public void wishList() throws Exception {
		
//		WebElement SignIn = driver.findElement(By.xpath("//*[contains(text(),'Hello, Sign')]"));	
//		
//		
//		WebElement wishList = driver.findElement(By.xpath("//span[contains(text(),'Create a Wish List')]"));
//		act.moveToElement(SignIn).click(wishList).perform();
//		
		
		
		//Take screenshot
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File catured = ts.getScreenshotAs(OutputType.FILE);
		
		
		File target = new File("./IBM_screenshot/wishlist_dateTime.png");
		
		
		FileUtils.copyFile(catured, target);
		
		//File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		
		
		
	}
	
}
