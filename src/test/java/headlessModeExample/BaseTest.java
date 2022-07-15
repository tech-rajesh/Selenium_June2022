package headlessModeExample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.LoginPage_PageFactory;

public class BaseTest {

	Actions act;
	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
		
		WebDriverManager.chromedriver().setup();
		
		
		//headless
		ChromeOptions co = new ChromeOptions();
		//co.addArguments("--headless", "--window-size=1920,1200");
		co.addArguments("ignore-certificate-errors");
		
		
		driver = new ChromeDriver(co);
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		
		
		
		
	}
	
	@AfterTest
	public void closeApp() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
	}
	
}
