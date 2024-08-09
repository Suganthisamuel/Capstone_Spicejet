package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import listeners.Listeners;
import utilities.SPUtilityPgm;

public class SPBaseclass extends SPUtilityPgm{

	Listeners listeners;
	@BeforeMethod	
	public void startup() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\joesa\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
		driver.get(prop.getProperty("https://www.spicejet.com/"));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
		initializeWebDriverWait();
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}