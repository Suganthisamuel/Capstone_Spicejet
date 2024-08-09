package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SPUtilityPgm {

	public static WebDriver driver;
	
	public Properties prop;
	public Actions action;
	public JavascriptExecutor javascriptExecutor ;
	public WebDriverWait wait;


	
	public WebDriver initializeDriver() throws IOException {

		prop=new Properties();
		
		String propPath=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";

		
		FileInputStream fis=new FileInputStream(propPath);

		
		prop.load(fis);

		
		String browserName="Chrome";
		if(browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browserName.equals("edge")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browserName.equals("safari")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;

	}


	
	public void initializeProp() throws IOException {

		prop=new Properties();
		
		String propPath=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";

		
		FileInputStream fis=new FileInputStream(propPath);

		
		prop.load(fis);
		

	}


	public void initializeActions(){
		action=new Actions(driver);
	}


	public void initializeWebDriverWait(){
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	}

	public void initializeJavaScriptExecutor(){
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.scrollBy(0,600)");
	}

	public void initializeJavaScriptExecutorWindow(){
		javascriptExecutor = (JavascriptExecutor) driver;

	}

	
	public  void SwitchWindow() { 
		String parentWindow=driver.getWindowHandle(); 
		Set<String> windowhandles=driver.getWindowHandles(); windowhandles.size();	  
		for(String childWindow:windowhandles) {
			if(!childWindow.contentEquals(parentWindow)) {
				driver.switchTo().window(childWindow); break; } } }


	public  String takeScreenshot(String testName,WebDriver driver1) throws IOException {
		File srcScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotFilePath=System.getProperty("user.dir")+"/Screenshots/"+testName+".png";
		FileUtils.copyFile(srcScreenShot,new File(screenshotFilePath));		
		return screenshotFilePath;

	}
}