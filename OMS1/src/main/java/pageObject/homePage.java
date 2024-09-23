package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import basePage.baseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class homePage extends baseClass{

	public homePage(WebDriver driver) {
		super(driver);
	}
	
	
//	public void clickProducts() {
//	clickProducts();
//	}
	
	 public void clickProducts() {
	    	driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
	    }

}
