package pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

	  public WebDriver driver;
	    public WebElement products;
	    public WebElement buynow;
	    public WebElement selectsize;

	    public landingPage(WebDriver driver) {
	        this.driver = driver;
	    //    initializeElements();
	    }
	
	// locators -----
	
	// Products
	    private void initializeElements() {
	        // Initialize web elements after the driver is set
	       
//	        buynow = driver.findElement(By.xpath("(//button[@type='button'])[4]"));
//	        selectsize = driver.findElement(By.xpath("(//button[contains(@type,'button')][normalize-space()='+'])[1]"));
	    }
	    
	    
	    
	// Methods -------
	
	// method to click products
		public void click_products() {
			 products = driver.findElement(By.xpath("//span[normalize-space()='Products']"));
			products.click();
		}
		
		
		
		//method to click buynow 
		public void click_buynow() {
			 buynow = driver.findElement(By.xpath("//body[1]/app-root[1]/app-b2clayout[1]/div[1]/app-b2c-products[1]/div[1]/div[1]/div[2]/div[3]/div[1]/app-product[1]/div[1]/div[1]/div[2]/div[1]/div[1]/app-buy-now-btn[1]/button[1]"));
			buynow.click();
		}
		
		public void click_selectsize() {
			  selectsize = driver.findElement(By.xpath("(//button[contains(@type,'button')][normalize-space()='+'])[1]"));
			selectsize.click();
		}
		
		
		
		

}
