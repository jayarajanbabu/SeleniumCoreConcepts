package SeleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class findHeightWidth {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void dynamicWebTable() {
		driver.get("https://www.opencart.com/index.php?route=account/login");
	int height = driver.findElement(By.xpath("//input[@id='input-email']")).getSize().getHeight();
	System.out.println("Height :"+height);
	int width = driver.findElement(By.xpath("//input[@id='input-email']")).getSize().getWidth();
	System.out.println("Width :"+width);

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
