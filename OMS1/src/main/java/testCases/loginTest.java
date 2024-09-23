package testCases;

import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseTest.baseTest;
import pageObject.cartPage;
import pageObject.homePage;
import pageObject.loginPage;
import pageObject.productsPage;

public class loginTest extends baseTest{
	

	
	@Test(priority =  1)
	public void testlogin() {
		
		getUrl("https://devgenresports.azurewebsites.net/auth/login");
		
		// get email element
		
		loginPage loginpage= new loginPage(driver);
		
		
		
		loginpage.getusername("xire9465@yopmail.com");
		loginpage.getpassword("Ajay@123");
		loginpage.clickLogin();		
		
	}
	
	// Place order with Product discount, Customer discount, Delivery at Manufacturing Unit (No delivery charges),Pay method -> Pay with Cash, Pay Term -> Pay Now 
	
	@Test(priority =  2)
	public void addproduct() {
		
		homePage homepage= new homePage(driver);
		homepage.clickProducts();
		productsPage productpage = new productsPage(driver);
		productpage.clickFirstProduct();
		
		
	    // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);

        // Switch to the second tab
        driver.switchTo().window(tabs.get(1));
        productpage.ordername().sendKeys("order name");	
        
        productpage.addToCart();
        
        cartPage cartpage =new cartPage(driver);
       String ProductPrice = cartpage.getCardContent();
       String SummaryPrice = cartpage.getSummaryPrice(); 
       
       
        // Assert that price of product in summary is same as price shown on left content multiplied by quantity
        
       Assert.assertEquals(ProductPrice, SummaryPrice, "Price is not equal!");
       
       // Click checkout code
       
       
       
       // Select first shipping address card
       
       // select minimum delivery method
       
       
       // get order summary total price, get total amount on right side
       
       // assert that total price should be added with delivery charges 
       
       // Click on payment methods accordian if expanded is false, otherwise its true
       
       // Click on pay by cash
       
       // Click on pay now 
       
       // Asset payment by cash amount is same as on previous total price
       
       // Click on pay 
       // Click on Go to orders
       
       
       
       
        // Assert that price of product in summary is added with 25% of total price
        
       // Apply rush production
//        cartpage.change_order_date();
//        
//        
//        
//        String UpdatedSummaryPrice = cartpage.getSummaryPrice();  
//        
//        Assert.assertEquals(ProductPrice, UpdatedSummaryPrice, "Strings are not equal!");
        
	}
	
}
