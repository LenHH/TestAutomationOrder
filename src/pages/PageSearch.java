package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageSearch extends BasePage {
	public PageSearch(WebDriver dr) {
		this.driver = dr;
	}
	public By getProductElementByTitle(String productTitle) {
		return By.xpath("//div[@class='truncate text-xs md:text-sm'][text()='"+ productTitle +"']");
	}

	public ProductDetail clickOnProductName(String productTitle) {
		By productElementXpath = getProductElementByTitle(productTitle);
		driver.findElement(productElementXpath).click();
		return new ProductDetail(driver);
	}
}
