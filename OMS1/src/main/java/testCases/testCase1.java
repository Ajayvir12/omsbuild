package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import pageObject.landingPage;


public class testCase1 {

	public WebDriver driver;
	
		// 2 ways to access methods and fields of different class is Composition and inheritance
	    // This is an example of composition
	private landingPage testcase;
	

	
    @BeforeClass
    public void setUp() {
        // Set the path for the ChromeDriver executable
    	System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\ChromeDriver\\chromedriver-win32\\chromedriver.exe");
		  
 	   ChromeOptions ops = new ChromeOptions();
 	   ops.addArguments("--remote-allow-origins=*");
 	   ChromeDriver driver = new ChromeDriver(ops);
 	   
 		driver.manage().window().maximize();
 		driver.switchTo().window(driver.getWindowHandle()); 
 		   driver.get("https://devgenresports.azurewebsites.net/home");
 		   
 		
 		   this.driver=driver;
    }

 @Test
    public void testLandingPage() throws InterruptedException {
   
	 testcase =new landingPage(driver);
	 
	
//       testcase.click_products(); 
//       testcase.click_buynow();
//       testcase.click_selectsize();
	 
//	 WebElement element = driver.findElement(By.tagName("body")); // or any element on the page
	 Actions actions = new Actions(driver);
	 actions.moveByOffset(50, 100).perform();

	actions.contextClick().perform(); // Then click at that position
  
   
    }

//    @AfterClass
//    public void tearDown() {
//        // Close the browser
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}