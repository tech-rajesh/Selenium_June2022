package gridExample;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRMLoginTest extends BaseTest{

	
	
	@Test(priority = 1)
	public void login() {
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.name("Submit")).click();
		
	}
	
	

	@Test(priority = 2)
	public void logout() {
		
		
		String actualText = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(actualText, "Dashboard");
		
		
		
		driver.findElement(By.partialLinkText("Welcome")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		
		
		driver.findElement(By.linkText("Logout")).click();
		
		
		
	}
	
}
