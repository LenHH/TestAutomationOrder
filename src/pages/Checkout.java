package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout extends BasePage{
	
public Checkout(WebDriver dr) {
	this.driver = dr;
}
public void inputOrderInformation() {
	
	driver.findElement(By.id("checkout-email")).sendKeys("testorderdls@gmail.com");
	driver.findElement(By.id("shipping_address-phone")).sendKeys("0123456798");
	driver.findElement(By.id("shipping_address-full_name")).sendKeys("Test Order");
	driver.findElement(By.id("shipping_address-address1")).sendKeys("HaNoi");
	driver.findElement(By.id("shipping_address-city")).sendKeys("HaNoi");
	driver.findElement(By.id("shipping_address-province")).sendKeys("HaNoi");
	driver.findElement(By.id("shipping_address-zip")).sendKeys("10000");
	driver.findElement(By.name("card_cc[number]")).sendKeys("4111111111111111");
	driver.findElement(By.name("card_cc[expire_date]")).sendKeys("04/44");
	driver.findElement(By.name("card_cc[cvc]")).sendKeys("123");
	//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
}

public ThankYou clickPlaceYourOrder() {
	driver.findElement(By.xpath("//div//button[@form='checkout-form']")).click();
	driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	return new ThankYou(driver);
}
}

