package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import basePage.baseClass;

public class cartPage extends baseClass{

	WebElement contentData;
	WebElement PriceSummary;
	
	public cartPage(WebDriver driver) {
		super(driver);
		
		//Product details content - left side
		this.contentData = driver.findElement(By.xpath("//div[@class='content']"));
		
		// Product price summary - right side
		this.PriceSummary = driver.findElement(By.xpath("//div[@class='price']"));
	}
	
	
	
	// Elements
	
//	public void cardContent() {
//		WebElement contentData= driver.findElement(By.xpath("//div[@class='content']"));
//	}
	
	public String getCardContent() {
	List<WebElement> elementsLabel=	contentData.findElements(By.tagName("h6"));
	List<WebElement> elementsValue=	contentData.findElements(By.tagName("p"));
	
	 // Print the text of each child element
    for (WebElement child : elementsValue) {
        System.out.println("Text of child element:");
        System.out.println(child.getText());
    }
    
   String Price_left_content= elementsValue.get(6).getText();
   
   System.out.print("Price" + ":" + Price_left_content);
   
   return Price_left_content;
	}
	
	
//	public void getSummaryContent() {
//	
//		List<WebElement> PriceData= PriceSummary.findElements(By.tagName("div"));
//		 WebElement specificDiv=  PriceData.get(5);
//		 System.out.print(specificDiv.getText());
//		 
//		 System.out.print("Amount" + driver.findElement(By.xpath("//div[@class='price']//div[@class=\"d-flex justify-content-between price-line total\"]//span")).getText());
//	}
//	
	public String getSummaryPrice() {
		return driver.findElement(By.xpath("//div[@class='price']//div[@class=\"d-flex justify-content-between price-line total\"]//span")).getText();
	}
	
	
	// Select Date Picker 
	
	
// click date ->  //div[@class='price']//div[@class='order-form']//div//div[2]//p-calendar
// select date -> //div[contains(@class, "p-datepicker-group-container")]//div[2]//tbody//tr[3]//td[5]
// Click yes -> //button[normalize-space()='Yes']
	
	public void change_order_date() {
		driver.findElement(By.xpath("//div[@class='price']//div[@class='order-form']//div//div[2]//p-calendar")).click();
		driver.findElement(By.xpath("//div[contains(@class, \"p-datepicker-group-container\")]//div[2]//tbody//tr[3]//td[5]")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
		}
	
	
// Element Order Name Field
	
	public void Enter_Order_Name() {
		driver.findElement(By.xpath("//input[@formcontrolname='orderName']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='orderName']")).sendKeys("Auto Order");
	}
	
	// Element checkout
	
	public void Click_CheckOut() {
		driver.findElement(By.xpath("//input[@formcontrolname='orderName']")).click();
	}
	
	// Element select 1st address 
	
	public void click_address() {
		driver.findElement(By.xpath("//div[@id='p-tabpanel-0']//div[1]//div[@class='address']")).click();
	}
	
	
	
	
	

	

}
