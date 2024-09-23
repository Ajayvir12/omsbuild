package pageObject;


import basePage.baseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class productsPage extends baseClass{
	
	
	
	public productsPage(WebDriver driver) {
		super(driver);
	}
	
	// elements
	public WebElement getFirstProduct() {
		return driver.findElement(By.xpath("//div[@class='d-flex gap-4']//div[1]//app-product[1]//div[1]//div[1]//div[2]//div[1]//div[1]//app-buy-now-btn[1]//button[1]"));
	}
	
	// Element order digital mockup name
	public WebElement ordername() {
		return driver.findElement(By.xpath("//input[@id='name']"));
	}
	
	// Element add to cart
	
	public void addToCart() {
		driver.findElement(By.xpath("//button[@class='p-ripple p-element p-button p-component']")).click();
	}
	
	public void clickCategory() {
		driver.findElement(By.xpath("//div[@class='tab-sidebar']//div[3]//p-accordion[@class='p-element']")).click();
	}
	
	public void clickSearchCategory(String Category) {
		driver.findElement(By.xpath("//input[@name='search'][1]")).sendKeys(Category);
	}
	
	
	// methods
	
	public void clickFirstProduct() {
		getFirstProduct().click();;
	}
	
	// specifications 
	
	public void clickSpecifications() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));// 10 seconds timeout
		   
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='btn-group']//button[@type='button']")));

	        // Click the element
	        element.click();
	
	}
	
	// categories 
	
	public void clickSpecificationCategory() {
		driver.findElement(By.xpath("//div[@class='btn-group']//ul//li[1]")).click();
	}
	


	
	
}
