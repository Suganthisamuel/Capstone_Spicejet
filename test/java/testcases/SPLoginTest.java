

package testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.SPBaseclass;
import PageObjects.SPLoginPage;


public class SPLoginTest extends SPBaseclass {

	//Login with valid credentials
	@Test (priority = 1)
	public void LoginwithValidCredentials() throws InterruptedException {

		//Create an object
		SPLoginPage splogin=new SPLoginPage(driver);

		//Click on Login link
		splogin.loginClick();

		//Select Email option to login
		splogin.emailClick();

		//Enter a valid Email and valid password
		splogin.enterEmail(prop.getProperty("EMail"));
		splogin.enterPassword(prop.getProperty("Password"));

		//Click on Login button
		splogin.loginButtonClick();

		//Validate the account Login 
		wait.until(ExpectedConditions.visibilityOf(splogin.getAccountName()));
		Thread.sleep(2000);
		String actualValue=splogin.getAccountName().getText();
		String expectedValue="Hi "+(prop.getProperty("FirstName"));
		Assert.assertEquals(actualValue,expectedValue);
	}


	//Login with invalid password
	@Test(priority = 2)
	public void LoginwithInValidPassword() throws InterruptedException {

		//create an object
		SPLoginPage splogin=new SPLoginPage(driver);

		//Click on Login 
		splogin.loginClick();

		/// Select an Email option to login
		splogin.emailClick();

		//Enter valid Email and invalid password
		splogin.enterEmail(prop.getProperty("EMail"));
		splogin.enterPassword(prop.getProperty("InvalidPassword"));

		//Click on login button
		splogin.loginButtonClick();		
		Thread.sleep(2000);

		//Validate the account Login 
		wait.until(ExpectedConditions.visibilityOf(splogin.getAlertMsg()));
		Thread.sleep(2000);
		String expectedValue=splogin.getAlertMsg().getText().concat("Invalid Username/Password");
		Assert.assertTrue(true, expectedValue);
	}

	//Login with invalid Email
	@Test(priority = 3)
	public void LoginwithInValidEMail() throws InterruptedException {
		//create an object
		SPLoginPage splogin=new SPLoginPage(driver);

		//Click on Login 
		splogin.loginClick();

		/// Select an Email option to login
		splogin.emailClick();

		//Enter valid Invalid Email and valid password
		splogin.enterEmail(prop.getProperty("InvalidEmail"));
		splogin.enterPassword(prop.getProperty("Password"));

		//Click on login button
		splogin.loginButtonClick();			
		Thread.sleep(2000);

		//Validate the account Login 
		wait.until(ExpectedConditions.visibilityOf(splogin.getAlertMsg()));
		Thread.sleep(2000);
		String expectedValue=splogin.getAlertMsg().getText().concat("Invalid Username/Password");
		Assert.assertTrue(true, expectedValue);
	}

	//Login with invalid Email and invalid password
	@Test(priority = 4)
	public void LoginwithInValidCredentials () throws InterruptedException {
		//create an object
		SPLoginPage splogin=new SPLoginPage(driver);

		//Click on Login 
		splogin.loginClick();

		/// Select an Email option to login
		splogin.emailClick();

		//Enter valid Invalid Email and Invalid password
		splogin.enterEmail(prop.getProperty("InvalidEmail"));
		splogin.enterPassword(prop.getProperty("InvalidPassword"));

		//click on login button
		splogin.loginButtonClick();	
		Thread.sleep(2000);

		//Validate the account Login 
		wait.until(ExpectedConditions.visibilityOf(splogin.getAlertMsg()));
		Thread.sleep(2000);
		String expectedValue=splogin.getAlertMsg().getText().concat("Invalid Username/Password");
		Assert.assertTrue(true, expectedValue);
	}
}