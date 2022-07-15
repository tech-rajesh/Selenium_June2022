package xpathAsixExample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HYRExample {

	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(4000);
		driver.close();
	
		
	}
	
	@Test
	public void dynamicTableCOntentTest() throws Exception {
		
		driver.findElement(By.xpath("//td[text()='Helen Bennett']//preceding-sibling::td/input")).click();	
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//td[text()='Yoshi Tannamuri']//preceding-sibling::td/input")).click();	
	}
}
