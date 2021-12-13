package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTip {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void tooltip() {
		driver.get("https://jqueryui.com/tooltip/");
		driver.switchTo().frame(0);
		WebElement age = driver.findElement(By.xpath("//input[@id='age']"));
		String tooltip = age.getAttribute("title");
		System.out.println(tooltip);
	}
	
	@AfterMethod
	public void tearDown() {
		
	}
}
