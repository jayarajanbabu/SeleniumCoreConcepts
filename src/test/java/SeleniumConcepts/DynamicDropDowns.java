package SeleniumConcepts;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicDropDowns {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void dynamicDD() throws InterruptedException {
		driver.get("http://www.google.com");
		driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("java tutorial");
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']//div[1]//span"));
		System.out.println("Size of Autosuggestions :"+list.size());
		
		for (WebElement option:list) {
			if (option.getText().contains("beginners")) {
				option.click();
				break;
			}
		} 
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
