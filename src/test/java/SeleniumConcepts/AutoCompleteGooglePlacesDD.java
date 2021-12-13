package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompleteGooglePlacesDD {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		}
	
	@Test
	public void autoCompleteDD() throws InterruptedException {
		driver.get("https://www.twoplugs.com/newsearchserviceneed");
		WebElement search = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		search.clear();
		Thread.sleep(3000);
		search.sendKeys("Toronto");
		Thread.sleep(3000);

		String text;
		
		do {
			search.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(3000);
			text = search.getAttribute("value");
			if (text.equals("Toronto, OH, USA")) {
				search.sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				break;
			}
			
		}while (!text.isEmpty());
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
