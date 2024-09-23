package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import basePage.baseClass;

public class orderSummary extends baseClass{

	public orderSummary(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// Payment page elements
	
// Card payment details 
	
	WebElement form = driver.findElement(By.xpath("//div[@class='new-address']//form"));
	
	WebElement Fname = form.findElement(By.xpath("//div[2]//div//input[@id='fname']"));
	
	WebElement Email = form.findElement(By.xpath("//div[2]//div//input[@id='email']"));
	
	WebElement City = form.findElement(By.xpath("//div[3]//div//input[@id='city']"));
	
	WebElement Zipcode = form.findElement(By.xpath("//div[3]//div//input[@id='zip']"));
	
	WebElement Address = form.findElement(By.xpath("//div[4]//div//input[@id='address']"));
	
	
	
	public void enterDetails() {
		Fname.sendKeys("Ajay");
	}

}
