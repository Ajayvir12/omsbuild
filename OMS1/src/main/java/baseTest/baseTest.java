package baseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class baseTest {
	
	 protected WebDriver driver;
	 
	   @BeforeClass
	    public void setUp() {
		   // Set the path for the ChromeDriver executable
	    	System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\ChromeDriver\\chromedriver-win32\\chromedriver.exe");
			  
	 	   ChromeOptions ops = new ChromeOptions();
	 	   ops.addArguments("--remote-allow-origins=*");
	 	   driver = new ChromeDriver(ops); 
	 		driver.manage().window().maximize();
	 		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 		
	 		 
	    }
	 
	 public void getUrl(String url) {
		 driver.get(url);
	 }
	 
	 
//	  @AfterClass
//	    public void tearDown() {
//	        if (driver != null) {
//	            driver.quit();
//	        }
//	    }
	

}
