package testCases;


import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseTest.baseTest;
import pageObject.cartPage;
import pageObject.categoryPage;
import pageObject.homePage;
import pageObject.loginPage;
import pageObject.productsPage;

public class allCruds extends baseTest{
	
	@Test(priority =  1)
	public void testlogin() {
		
		getUrl("https://devgenresports.azurewebsites.net/auth/login");
		
		// get email element
		
		loginPage loginpage= new loginPage(driver);
		
		loginpage.getusername("admin@oms.com");
		loginpage.getpassword("Pass@123");
		loginpage.clickLogin();		
	}
	
	
	// Test to add Categories then add Size then Range then Tags then Fabric then Gender 
	@Test(priority =  2)
	public void addCategory() throws InterruptedException {
		
		driver.get("https://devgenresports.azurewebsites.net/order-management/products");
		
		productsPage productpage = new productsPage(driver);
		
		categoryPage categorypage = new categoryPage(driver);
		
		productpage.clickSpecifications();
		
		productpage.clickSpecificationCategory();
		
		categorypage.addCategory("Auto Category 1");
		
		categorypage.clickAdd();
		
		// assert if category is added in list 
		
		Thread.sleep(5000);
		
		String firstrow = categorypage.getTable();
		
		Assert.assertEquals(firstrow, "Auto Category 1" , "Row is not added");
		
	}
	
	 @Test (dependsOnMethods = { "addCategory" })
	 public void updateCategory() throws InterruptedException {
		 
			categoryPage categorypage = new categoryPage(driver);
			
			categorypage.clickUpdate();
			
			categorypage.addCategory("Auto Category 2");
			categorypage.clickAdd();
			
			Thread.sleep(2000);
			
			String firstrow = categorypage.getTable();
			
			Assert.assertEquals(firstrow, "Auto Category 2" , "Row is not updated"); 	 
	 }
	 
	 
	 @Test 
	 public void addSize() {
		 
	 }
	 
	 @Test 
	 public void updateSize() {
		 
	 }
	 
	 
	 
	
	
	

}
