package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	public WebDriver dr;
	@BeforeMethod
public void openBrowser() {
	System.setProperty("webdriver.chrome.driver","/Users/lenhoang/Documents/TestReact/AutoPrice/driver/chromedriver");
	dr = new ChromeDriver();
	//dr.get("https://store-dev.9prints.com");
	//dr.get("https://store-toanmv-backup.9prints.com/");
	dr.get("http://store-beta.9prints.com/");
	//dr.get("https://store-phucdv.9prints.com");
	//dr.get("https://store-staging2.9prints.com");
	

	dr.manage().window().maximize();
}
	@AfterMethod
	public void closeBrowser() {
		dr.quit();
	}
}
