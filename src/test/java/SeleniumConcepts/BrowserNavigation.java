package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserNavigation {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}

	@Test
	public void navigationTest() {
		driver.get("https://www.snapdeal.com/");
		driver.navigate().to("http://www.amazon.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}
	
	@Test
	public void refreshTest() {
		driver.get("http://www.amazon.com");
		driver.navigate().to(driver.getCurrentUrl());
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.F5);
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
