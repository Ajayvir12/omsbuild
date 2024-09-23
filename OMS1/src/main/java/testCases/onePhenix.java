package testCases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class onePhenix {
	
	 protected WebDriver driver;
	
	@Test
	public void login() {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\ChromeDriver\\chromedriver-win32\\chromedriver.exe");
		  
	 	   ChromeOptions ops = new ChromeOptions();
	 	   ops.addArguments("--remote-allow-origins=*");
	 	   driver = new ChromeDriver(ops); 
	 		driver.manage().window().maximize();
	 		
	 		driver.get("https://webstaging.onephenix.com/#/booking/profile");
	 		
	 		
	}

}
