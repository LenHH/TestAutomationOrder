package pages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductDetail extends BasePage {
	
			
	public ProductDetail(WebDriver dr) {
		this.driver = dr;
	}
//	//public By productVariant16 = By.xpath("//div[@title='16 x 16 in']");
	public By productVariant16 = By.xpath("//div[text()='30 x 40 in']");
//	
//	public void clickVariant16() {
//		//driver.findElement(By.xpath("//label[1]//input[@type = 'radio'][1]")).click();
//		driver.findElement(By.xpath("//div[@data-pack-id='7']")).click();
//		
//	}
	public void seclectOption() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//xpath store dev
	//Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[3]/div[2]/div[5]/form/div[1]/div[2]/div/div/select")));
		// //xpath store local
	Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[3]/div[2]/div[5]/form/div[1]/div[2]/div/div/select")));
	dropdown.selectByVisibleText("Please select an option");
	dropdown.selectByIndex(2);
	}
	
	public void clickPersonalized() {
//		Thread.sleep(4000L);
		List<WebElement> el = driver.findElements(By.xpath("//div[@class='grid grid-cols-4 md:grid-cols-5 gap-3']"));
		System.out.println(el.size());
		for ( WebElement e : el ) {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			try {
				e.findElement(By.xpath(".//div")).click();
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
			}
		}
 //driver.getClass("personalized-config-comp__content");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
	}
	
	public void inputQuantity() {
		//int number = new Random().nextInt(5);
		//int number = (int) (Math.random() * 1);

		int[] numbers = new int[] { 1,2,3,4,5};
		
		String numberInput = Integer.toString(numbers[new Random().nextInt(numbers.length)]);
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(numberInput);
	}
		
	public AddToCart clickButtonAddCart() {
		try {
		driver.findElement(By.xpath("//div[@class='mt-4']//button[text()='Add To Cart']")).click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return new AddToCart(driver);
	}
}

