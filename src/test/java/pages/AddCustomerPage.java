package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCustomerPage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {

		this.driver = driver;

	}

	// Identification locator

	By txt_email = By.name("Email");
	By txt_password = By.cssSelector("input#Password");
	By btn_Login = By.xpath("//button[text()='Log in']");
	
	
	
	
	
	// Methods/Actions

	public void enterUserName(String email) {
		driver.findElement(txt_email).clear();
		driver.findElement(txt_email).sendKeys(email);

	}

	
	public void enterPassword(String pwd) {
		driver.findElement(txt_password).clear();
		driver.findElement(txt_password).sendKeys(pwd);

	}
	
	public void clickLoginButton() {
		
		driver.findElement(btn_Login).click();
		
	}

}
