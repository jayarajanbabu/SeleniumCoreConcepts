package SeleniumConcepts;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWait {
WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void explicitWait() {
//Fluent Wait Declaration
/*		Wait<WebDriver> mywait = new FluentWait <WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(30))
								.pollingEvery(Duration.ofSeconds(5))
								.Ignoring(NoSuchElementException.class); */
		
		driver.get("https://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("selenium webdriver");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
	
//usage of FluentWait
/*		WebElement foo = mywait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply (WebDriver driver) {
				return driver.findElement(By.xpath("//h3[contains(text(),'Selenium WebDriver')]"));
			}
		}); */
		
	}
	
	@AfterMethod
	public void tearDown() {
		
	}
}


