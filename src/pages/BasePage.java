package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
public static WebDriver driver;

public void scrollToProduct(WebElement targetElement) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	int count =0;
	while ((!targetElement.isDisplayed()) || count < 4) {
		js.executeScript("window.scrollTo(0, 700)");
		count ++;
	}
		
}

public WebElement getElementByXpath(By inputElement) {
	return driver.findElement(inputElement);
} 

}
