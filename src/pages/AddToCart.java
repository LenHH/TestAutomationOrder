package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCart extends BasePage {
	
public AddToCart(WebDriver dr) {
	this.driver = dr;
}
public void clickLogo() {
	driver.findElement(By.xpath("//img[@class='Header_logo__1gXJa']")).click();;

}

public Checkout clickSecureCheckout() {
	driver.findElement(By.xpath("//button[text()='Secure Checkout']")).click();
	return new Checkout(driver);
}
}
