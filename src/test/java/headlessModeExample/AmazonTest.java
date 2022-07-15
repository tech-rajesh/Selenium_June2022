package headlessModeExample;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest{

	
	@Test
	public void searchTest() throws Exception {
		
		String searchItems = "iphone 14";
		
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(searchItems);
		driver.findElement(By.xpath("//input[@value=\"Go\"]")).click();
		
		
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains(searchItems));
		
		//
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenshotFile, new File("amazonTestHeadless11_error.png"));
		
	}
	
}
