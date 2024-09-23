package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import basePage.baseClass;

public class categoryPage extends baseClass{

	public categoryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void addCategory(String Data) {
		driver.findElement(By.xpath("//input[@name='categoryName']")).clear();
	driver.findElement(By.xpath("//input[@name='categoryName']")).sendKeys(Data);
	}
	
	
	
	public void clickAdd() {
		driver.findElement(By.xpath("//form//div//div[2]//button")).click();
		}
	
	// get table and table first row
	
	public String getTable() {
		return driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(1)")).getText();
	}

	
	// First row update button 
	
	public void clickUpdate() {
		driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(2) button:first-child")).click();
	}
	
	
	
}
