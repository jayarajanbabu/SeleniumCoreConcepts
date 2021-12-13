package SeleniumConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
//ChromeDriver		
		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		//driver = new ChromeDriver();
//FirefoxDriver
		//System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		//driver = new FirefoxDriver();
//MSEdgedriver		
		//System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
		//driver = new EdgeDriver();
//******WebDriverManager**********
//ChromeDriver
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
//Firefoxdriver
		//WebDriverManager.firefoxdriver().setup();
		//driver = new FirefoxDriver();
//EdgeDriver	
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void launchBrowser() {
		driver.get("http://www.amazon.com");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
