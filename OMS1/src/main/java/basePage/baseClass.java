package basePage;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class baseClass {
	
	public WebDriver driver;

	public baseClass(WebDriver driver) {
	  this.driver=driver;
//	  PageFactory.initElements(driver, this);
	}
	
	
	
	// Common methods for all pages
    public String getPageTitle() {
        return driver.getTitle();
    }
    
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    // navbar button product
    public void clickProducts() {
    	driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
    }
    
    public void clickHome() {
    	driver.findElement(By.xpath("//span[normalize-space()='Home']")).click();
    }
    
    
    


}
