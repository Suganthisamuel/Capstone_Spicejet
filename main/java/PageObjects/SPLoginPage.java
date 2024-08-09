package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SPLoginPage {
		// TODO Auto-generated method stub
		public WebDriver driver;
		public Select select;

		//Constructor
		public SPLoginPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver;
			PageFactory.initElements(driver,this);
			InilializeActions();
			//InilializeJavaScriptExecutor();
			InilializeWebDriverWait();
		}

		
		
		private void InilializeWebDriverWait() {
			// TODO Auto-generated method stub
			 @SuppressWarnings("unused")
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		}



		private void InilializeActions() {
			@SuppressWarnings("unused")
			Actions actions = new Actions(driver);
// TODO Auto-generated method stub
			
		}



		@FindBy(xpath = "//div[contains(text(),'Login')]")
		WebElement loginkey;

		@FindBy(xpath = "//div[.='Email']")
		WebElement emailButton;

		@FindBy(xpath = "//input[@type='email']")
		WebElement enterEmail;

		@FindBy(xpath = "//input[@type='password']")
		WebElement enterPassword;

		@FindBy(xpath = "//div[@data-testid='login-cta']")
		WebElement loginButton;

		@FindBy(xpath = "//div[@class='css-1dbjc4n r-1jkjb']/div[starts-with(text(),'Hi')]")
		WebElement accountName;

		@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-1v8vaea r-eqz5dr r-1777fci r-1wyvozj r-1xcajam r-tyizg9 r-70iriu r-1pozq62']")
		WebElement alertMsg;



		//Getters
		public WebElement getAlertMsg() {
			return alertMsg;
		}


		public WebElement getAccountName() {
			return accountName;
		}

		//Methods

		//Click on Login link
		public void loginClick() {
			loginkey.click();	
		}

		//slect Email option
		public void emailClick() {
			emailButton.click();	
		}

		//Enter Valid Email
		public void enterEmail(String EMail) {
			enterEmail.sendKeys(EMail);	
		}

		//Enter Valid Password
		public void enterPassword(String Password) {
			enterPassword.sendKeys(Password);
		}

		//Click on login button
		public void loginButtonClick() throws InterruptedException {
			loginButton.click();	

		}
	

	}


