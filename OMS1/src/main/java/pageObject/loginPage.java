package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basePage.baseClass;

public class loginPage extends baseClass{
	

	public loginPage(WebDriver driver) {
		super(driver);
	}
	
	 // Page Element
	 public void getusername(String username) {
      driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
    }
	 
	 public void getpassword(String password) {
		 driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	 }
	 
	 public WebElement getloginbutton() {
		 WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		 return loginButton;
	 }
	
	// Page Actions
	 
	 public void clickLogin() {
		 getloginbutton().click();
	 }
	 
   
	   public homePage returnDriver() {
	    
	        return new homePage(driver);
	    }
	
	  // Page Actions
	
	
	
}

