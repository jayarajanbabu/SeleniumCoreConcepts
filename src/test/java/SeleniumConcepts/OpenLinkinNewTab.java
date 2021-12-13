package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenLinkinNewTab {
WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void openLinkinNewTab() {
		driver.get("https://demo.nopcommerce.com/");
		
		String tab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		driver.findElement(By.linkText("Register")).sendKeys(tab);
	}
	
	@Test
	public void openURLSin2tabs() {
		driver.get("https://demo.nopcommerce.com/");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://www.opencart.com");
	}
	
	@Test
	public void openURLsin2Windows() {
		driver.get("https://demo.nopcommerce.com/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("http://www.opencart.com");
	}
	@AfterMethod
	public void tearDown() {
		
	}
}
