package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
	
	
public HomePage(WebDriver dr) {
	this.driver = dr;
}
//
//public By getProductElementByTitle(String productTitle) {
//	return By.xpath("//a[@title='" + productTitle +"']");
//	
//}

public PageSearch searchCampaign(String productTitle) {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement searchInput =  driver.findElement(By.xpath("//div[@class='l:col-span-5 xl:col-span-6 my-hidden l:block']//input[@name='searchValue']"));
	searchInput.sendKeys(productTitle);
	searchInput.submit();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//div[@class='l:col-span-5 xl:col-span-6 my-hidden l:block']//button[@type='submit']")).click();
	return new PageSearch(driver);
}
//public ProductDetail clickOnProductName(String productTitle) {
//	By productElementXpath = getProductElementByTitle(productTitle);
//	driver.findElement(productElementXpath).click();
//	return new ProductDetail(driver);
//}

}
