package SeleniumConcepts;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetMethods {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void getMethods() {
		driver.get("http://www.amazon.com");
		String title = driver.getTitle();
		System.out.println("The Page Title is :" +title);
		String url = driver.getCurrentUrl();
		System.out.println("The Current Url is :" +url);
		String pageSource = driver.getPageSource();
		System.out.println("The PageSource is :" +pageSource);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
