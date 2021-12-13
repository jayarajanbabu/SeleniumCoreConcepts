package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleSlider {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	@Test
	public void sliders() {
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		WebElement min = driver.findElement(By.xpath("//span[1]"));
		WebElement max = driver.findElement(By.xpath("//span[2]"));
		System.out.println("The Location of Min is :"+min.getLocation());
		System.out.println("The Size of Min is :"+min.getSize());
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(min, 200, 0).perform();
		action.dragAndDropBy(max, -200, 0).perform();
		System.out.println("The Location of Min is :"+min.getLocation());
	}
	
	@AfterMethod
	public void tearDown() {
		
	}
}
