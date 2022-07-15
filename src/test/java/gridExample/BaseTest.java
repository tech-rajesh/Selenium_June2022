package gridExample;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.LoginPage_PageFactory;

public class BaseTest {

	Actions act;
	WebDriver driver;
	DesiredCapabilities cap;
	
	
	@Parameters("OS")
	@BeforeTest
	public void launchApp(String OS_Details) throws Exception {
		
		
		System.out.println("Execution of Test Case on platform: " + OS_Details);
		
		String nodeURL_win = "http://192.168.1.5:5566/wd/hub";
		String nodeURL_mac = "http://192.168.1.5:5599/wd/hub";
		
		
		if(OS_Details.equalsIgnoreCase("win")) {
			
			cap = new DesiredCapabilities().chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			
			WebDriverManager.chromedriver().setup();
			driver = new RemoteWebDriver(new URL(nodeURL_win),cap);
			System.out.println("Node details are: " + nodeURL_win);
			
		}
		else if( OS_Details.equalsIgnoreCase("mac")) {
			
			cap = new DesiredCapabilities().edge();
			cap.setBrowserName("MicrosoftEdge");
			cap.setPlatform(Platform.WINDOWS);
			
			WebDriverManager.edgedriver().setup();
			driver = new RemoteWebDriver(new URL(nodeURL_mac),cap);
			System.out.println("Node details are: " + nodeURL_mac);
			
		}
		else {
			
			System.out.println("=========================");
		}

		
		
		
		
		
		
		
		
		//client machine
		//WebDriverManager.chromedriver().setup();
//		WebDriverManager.edgedriver().setup();
//		
//		
//		driver = new RemoteWebDriver(new URL(nodeURL_mac),cap);
//		
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		
		
		
		
	}
	
	@AfterTest
	public void closeApp() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
	}
	
}
