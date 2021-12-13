package SeleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitGenericMethod {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void explicitWait() {
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("selenium webdriver");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		By elelocator = By.xpath("//h3[contains(text(),'Selenium WebDriver')]");
		presenceofWebElement(driver,elelocator,10).click();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		
	}
	
	public static WebElement presenceofWebElement (WebDriver driver, By locator, int timeout ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator);
	}
}
