package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseTest.baseTest;
import pageObject.cartPage;
import pageObject.homePage;
import pageObject.loginPage;
import pageObject.productsPage;

public class practiceTest2 extends baseTest{

	
	@Test
	public void testlogin() {
		
		getUrl("https://devgenresports.azurewebsites.net/auth/login");
		
		// get email element
		loginPage loginpage= new loginPage(driver);
		
		loginpage.getusername("xire9465@yopmail.com");
		loginpage.getpassword("Ajay@123");
		loginpage.clickLogin();		
	}
	
	
	// Test to go to products -> apply a category filter -> check the filtered result.
	
	@Test
	public void FilterTest() throws InterruptedException {
		homePage homepage= new homePage(driver);
		
		Thread.sleep(5000);
		
	    //Go to Products 
		homepage.clickProducts();
		
		// Click products Category 
		productsPage productpage = new productsPage(driver);
		
		productpage.clickCategory();
		
		// Enter text to search field
		productpage.clickSearchCategory("Shirt");
		
	}
	
	
}
