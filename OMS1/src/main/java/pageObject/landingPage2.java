package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage2 {
	
	
	
	  public WebDriver driver;
	  
    public WebElement products;
    
    public void setDriver(WebDriver cdriver) {
    	 this.driver=cdriver;
    	
    }
    
    public void click_products() {
		 products = driver.findElement(By.xpath("//span[normalize-space()='Products']"));
		products.click();
    	System.out.print("dsds");
	}
	
	
	
}
