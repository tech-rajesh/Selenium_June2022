package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage_PageFactory {

	WebDriver driver;

	public LoginPage_PageFactory(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Identification locator

//	By txt_email = By.name("Email");
//	By txt_password = By.cssSelector("input#Password");
//	By btn_Login = By.xpath("//button[text()='Log in']");
	
	
	@FindBy(name = "Email")
	WebElement txt_email;
	
	
	@FindBy(css = "input#Password")
	WebElement txt_password;
	
	@FindBy(how = How.CSS, using = "input#Password")
	WebElement txt_password1;
	
	@FindBy(xpath =  "//button[text()='Log in']")
	WebElement btn_Login;
	
	// Methods/Actions

	public void enterUserName(String email) {
		txt_email.clear();
		txt_email.sendKeys(email);

	}

	
	public void enterPassword(String pwd) {
		txt_password.clear();
		txt_password1.sendKeys(pwd);

	}
	
	public void clickLoginButton() {
		
		btn_Login.click();
		
	}
	
	public void verifyAppTitle(String expectedTitle) {
		Assert.assertTrue(driver.getTitle().contains(expectedTitle));
		
	}
	
	public void verifyAppTitle(String actualTitle, String expectedTitle) {
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	

}
