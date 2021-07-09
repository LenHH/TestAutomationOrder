package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.Utils;
import pages.AddToCart;
import pages.Checkout;
import pages.HomePage;
import pages.PageSearch;
import pages.ProductDetail;
import pages.ThankYou;

public class OrderTest extends BaseTest {
	@Test(dataProvider="ProductTitle")
public void creatOrder(String productTitle) {	
	
	HomePage homePage = new HomePage(dr);
	
	PageSearch search = homePage.searchCampaign(productTitle);
	//homePage.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	ProductDetail productDetail = search.clickOnProductName(productTitle);
	productDetail.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	productDetail.scrollToProduct(productDetail.getElementByXpath(By.xpath("//form[@class='mb-6']")));
	productDetail.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	productDetail.seclectOption();
	//productDetail.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	productDetail.clickPersonalized();
	productDetail.seclectOption();
	productDetail.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	//productDetail.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	productDetail.inputQuantity();
	
	AddToCart addToCart = productDetail.clickButtonAddCart();
	Checkout checkout = addToCart.clickSecureCheckout();
	checkout.inputOrderInformation();
	ThankYou thankyou = checkout.clickPlaceYourOrder();
		
}
//	@Test(dataProvider="ProductTitle")
//	public void creatMultiQuantity(String productTitle) {	
//		
//		HomePage homePage = new HomePage(dr);
//		
//		AddToCart cart1 = addProduct(homePage, productTitle);
//		cart1.clickLogo();
//		AddToCart cart2 = addProduct(homePage, productTitle);
//		
//		
//		Checkout checkout = cart2.clickSecureCheckout();
//		checkout.inputOrderInformation();
//		ThankYou thankyou = checkout.clickPlaceYourOrder();
//			
//	}
//	
//	public AddToCart addProduct(HomePage homePage, String productTitle) {
//		//homePage.scrollToProduct(homePage.getElementByXpath(homePage.getProductElementByTitle(productTitle)));
//		PageSearch search = homePage.searchCampaign(productTitle);
//		ProductDetail productDetail = search.clickOnProductName(productTitle);
//		//productDetail.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		//productDetail.scrollToProduct(productDetail.getElementByXpath(By.xpath("//form[@class='mb-6']")));
//		//productDetail.clickVariant16();
//		productDetail.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		productDetail.seclectOption();
//		productDetail.clickPersonalized();
//		productDetail.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		//productDetail.seclectOption();
//		productDetail.inputQuantity();
//		
//		AddToCart addToCart = productDetail.clickButtonAddCart();
//		return addToCart;
//	}
//	
	@DataProvider (name="ProductTitle")
public String[][] getProductNameList(){
		String xlFilePath = "/Users/lenhoang/Documents/TestReact/AutoPrice/DataTest/DataTestLocal.xls";
		//String xlFilePath = "/Users/lenhoang/Documents/TestReact/AutoPrice/DataTest/DataTestDev.xls";
		String sheetName = "ProductData";
		String tableName = "ProductName";
String[][] productNameList = Utils.getDataFromExcel(xlFilePath, sheetName, tableName);
return productNameList;
} 
	
}
