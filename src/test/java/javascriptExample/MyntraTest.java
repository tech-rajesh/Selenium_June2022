package javascriptExample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MyntraTest extends BaseTest {

	
	@Test
	public void wishList() {
		
		WebElement return30Days = driver.findElement(By.xpath("//strong[contains(text(),'within 30days')]"));	
		
		
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		
		JS.executeScript("arguments[0].scrollIntoView()", return30Days);
		
		
		
		
	}
	
}
