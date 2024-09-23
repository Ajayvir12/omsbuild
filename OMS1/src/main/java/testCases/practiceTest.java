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

public class practiceTest extends baseTest{
	
	
	
	@Test
	public void testlogin() {
		
		getUrl("https://devgenresports.azurewebsites.net/auth/login");
		
		// get email element
		
		loginPage loginpage= new loginPage(driver);
		
		loginpage.getusername("xire9465@yopmail.com");
		loginpage.getpassword("Ajay@123");
		loginpage.clickLogin();		
	}
	
	
	@Test(dependsOnMethods = "testlogin")
	public void addProduct() {
		getUrl("https://devgenresports.azurewebsites.net/checkout");
		driver.findElement(By.className("driver-popover-close-btn")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("(//div[@class='address'])[1]")).click();
		
		// Click Accordion if state false
		
		String AccState = driver.findElement(By.xpath("//a[@id='p-accordiontab-1']")).getAttribute("aria-expanded");
		
		if(AccState.equals("false")) {
			driver.findElement(By.xpath("//a[@id='p-accordiontab-1']")).click();
		}
		
		
		
		List<WebElement> AllDeliveryMethods = driver.findElements(By.xpath("//div[@id='p-accordiontab-1-content']//app-shipping-options//span"));
		
		double minPrice=Double.MAX_VALUE;
		
		for (WebElement Element : AllDeliveryMethods) {
         
            	String priceString = Element.getText().replace("$","").trim(); 
            	
            	if (priceString.isEmpty()) {
                    continue;
                }
            	
            	double priceInt = Double.parseDouble(priceString);
            
//            	System.out.print(priceInt);
            	
            	 if (priceInt < minPrice) {
                     minPrice = priceInt;
                 }
            	 
     }
		
		System.out.print("Min Price" + minPrice);
		String s=String.valueOf(minPrice);
		driver.findElement(By.xpath("//div[@id='p-accordiontab-1-content']//app-shipping-options//span[contains(text(),'" + s + "')]")).click();
		
		// Expand order summary and get price total
		
//		if(driver.findElement(By.xpath("//div[@id='p-accordiontab-2-content']")).getAttribute("aria-expanded").equals("false")) {
	//		driver.findElement(By.xpath("//p-accordiontab[@id='order-summary']")).click();
//		}
	
//	      String SumPriceString= driver.findElement(By.xpath("//div[@class='summary-card']//div[@class='content']//div[3]//h6")).getText();
	      
//	      System.out.print("Sum price is :" + SumPriceString);
//	      
//	       double SumPriceInt = Double.parseDouble(SumPriceString);
	       
	       
	       
	       // Assert that sumprice should be equal to price on right side summary 
			
			// Price of product on right side 
			
			String SumPriceInt = driver.findElement(By.xpath("//div[@class='price']//div[1]//p")).getText();
			
			System.out.print("Price" + driver.findElement(By.xpath("//div[@class='price']//div[1]//p")).getText());
	       
	       // get price 
	       
	       String FinalPriceString = driver.findElement(By.xpath("//div[@class='price']//div[3]//span")).getText().replace("$", "").trim();
	       double FinalPriceInt = Double.parseDouble(FinalPriceString);
	       
	       Assert.assertNotEquals(SumPriceInt, FinalPriceInt, "Price is not correct");
	       
	       Assert.assertNotEquals(SumPriceInt + minPrice, FinalPriceInt, "Product price + Delivery charges are not same as total price");
	       
	       
	       
	}
	
	@Test(dependsOnMethods = "addProduct")
	public void openPaymentMethods() throws InterruptedException{
		
		// click Payment method tab
		
	//	driver.findElement(By.xpath("//p-accordiontab[@id='payment-methods']")).click();
		
		//  //div//p-accordion//p-accordiontab[@id='payment-methods']
		
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//         WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p-accordiontab[@id='payment-methods']")));

		
//		Actions actions = new Actions(driver);
//		WebElement element = driver.findElement(By.cssSelector("#p-accordiontab-3"));
//		actions.moveToElement(element).click().perform();
//		
//         // Scroll the element into view using JavaScript
//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		Actions actions = new Actions(driver);
		actions.moveByOffset(300, 200).perform();
		Thread.sleep(2000); // Wait for 2 seconds to see where the mouse moves
		actions.click().perform(); // Then click at that position
		
		    
	}
	
	@Test (dependsOnMethods = {"openPaymentMethods()"})
	public void payByCash() throws InterruptedException {
		
	// click on Cash method
		
		// Click on pay button
				Thread.sleep(2000); 
		
		driver.findElement(By.xpath("//div//p-accordion//p-accordiontab[@id='payment-methods']//div//div//div/div//div[3]")).click();	
		
		// Click on Pay now 
		
		driver.findElement(By.xpath("//p-button[@id='pay-now']")).click();	
		
		// Click on pay button
		Thread.sleep(2000); 
		
		
		System.out.print("Price in button Cash:" + driver.findElement(By.xpath("//p-button[@class='p-element']//button")).getText().replace("Pay $", "").trim()); 
		
		String lastPayString = driver.findElement(By.xpath("//p-button[@class='p-element']//button")).getText().replace("Pay $", "").trim();
		
		
		
//		driver.findElement(By.xpath("//p-button[@class='p-element']//button//span")).click();
		
		System.out.print("Price in field :" + driver.findElement(By.xpath("//input[@id='amount']")).getText());
		
		// click on Go to orders
	}
	
	@Test (dependsOnMethods = {"openPaymentMethods()"})
	public void payByACH() throws InterruptedException {
		
		// Click on pay button
				Thread.sleep(2000); 
		
	driver.findElement(By.xpath("//div//p-accordion//p-accordiontab[@id='payment-methods']//div//div//div/div//div[3]")).click();	
		
		// Click on Pay now 
		
		driver.findElement(By.xpath("//p-button[@id='pay-now']")).click();	
		
		// Click on pay button
		Thread.sleep(2000); 
		
		System.out.print("Price in button ACH:" + driver.findElement(By.xpath("//p-button[@class='p-element']//button")).getText().replace("Pay $", "").trim()); 	
	}
	
	
	@Test (dependsOnMethods = {"openPaymentMethods()"})
	public void payByCard() throws InterruptedException {
		
		// Click on pay button
				Thread.sleep(2000); 
		
	driver.findElement(By.xpath("//div//p-accordion//p-accordiontab[@id='payment-methods']//div//div//div/div//div[1]")).click();	
		
		// Click on Pay now 
		
		driver.findElement(By.xpath("//p-button[@id='pay-now']")).click();	
		
		// Enter all card details
		
		
		
		// Click on pay button
		Thread.sleep(2000); 
		
		System.out.print("Price in button ACH:" + driver.findElement(By.xpath("//p-button[@class='p-element']//button")).getText().replace("Pay $", "").trim()); 	
	}
	
	
	@Test (dependsOnMethods = {"openPaymentMethods()"})
	public void payByCheck() throws InterruptedException {
		
		// Click on pay button
				Thread.sleep(2000); 
		
	driver.findElement(By.xpath("//div//p-accordion//p-accordiontab[@id='payment-methods']//div//div//div/div//div[3]")).click();	
		
		// Click on Pay now 
		
		driver.findElement(By.xpath("//p-button[@id='pay-now']")).click();	
		
		// Click on pay button
		Thread.sleep(2000); 
		
		System.out.print("Price in button ACH:" + driver.findElement(By.xpath("//p-button[@class='p-element']//button")).getText().replace("Pay $", "").trim()); 	
	}
  
	
	
	
	

}
