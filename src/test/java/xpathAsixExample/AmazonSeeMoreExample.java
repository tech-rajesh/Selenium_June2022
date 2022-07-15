package xpathAsixExample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSeeMoreExample {

	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(4000);
		driver.close();

	}

	@Test
	public void SeeMoreTest() throws Exception {

		driver.findElement(
				By.xpath("//h2[contains(text(),'Automotive essentials')]//parent::div//following-sibling::div/a"))
				.click();

		Thread.sleep(4000);
		System.out.println("Title: " + driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Motorbike"));

		Thread.sleep(4000);

		driver.navigate().back(); // home page

		driver.findElement(By.xpath("//h2[contains(text(),'Echo')]//ancestor::div[@data-display-at=\"smws\"]//descendant::a[text()='See More']")).click();

		Thread.sleep(4000);
		System.out.println("Title: " + driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Echo"));

	}
}
