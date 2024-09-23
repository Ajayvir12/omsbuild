package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import pageObject.landingPage2;

public class testCase2 extends landingPage2{



	public WebDriver driver;

	
	// 2 ways to access methods and fields of different class is Composition and inheritance
	// This is an example of Inheritance

	
	 @BeforeClass
	    public void setUp() {
	        // Set the path for the ChromeDriver executable
	    	System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\ChromeDriver\\chromedriver-win32\\chromedriver.exe");
			  
	 	   ChromeOptions ops = new ChromeOptions();
	 	   ops.addArguments("--remote-allow-origins=*");
	 	   ChromeDriver cdriver = new ChromeDriver(ops);
	 	cdriver.manage().window().maximize();
	 	cdriver.get("https://devgenresports.azurewebsites.net/home");
	    cdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 		  
	 		setDriver(cdriver);
	    }
	 
	    @Test
	    public void methodA()
	    {
	  click_products(); 
	        
	    }	
}
