package dataDrivenTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HRMLogin_DDT extends BaseTest{

	
	@Test(dataProvider = "RegressionData")
	public void verifyLoginFeatureWithInavlidCred(String user, String pass) throws Exception {
		
		
		System.out.println("user and password deatils: " + user + " : " + pass);
		Thread.sleep(2000);
		driver.findElement(By.name("txtUsername")).clear();
		driver.findElement(By.name("txtUsername")).sendKeys(user);
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("txtPassword")).clear();
		driver.findElement(By.name("txtPassword")).sendKeys(pass);
		
		driver.findElement(By.name("Submit")).click();
		
		
		//validation error message
		Boolean errorMessage = driver.findElement(By.id("spanMessage")).isDisplayed();
		Assert.assertTrue(errorMessage);
		
	}
	
	@DataProvider(name="sampleData")
	public Object [][] smokeTest() {
		
		Object [][] data = { {"user1", "password1"}, {"user2", "password2"}, {"user3", "password3"}};  //data - fetch - DB -number
		return data;
	}


	@DataProvider(name="RegressionData")
	public Object [][] dataTest() {
		
		Object [][] data = { {"userRegression1", "password1"}, {"userRegression2", "password2"}, {"userRegression3", "password3"}, {"userRegression4", "password4"}};  //data - fetch - DB -number
		return data;
	}
	
}
