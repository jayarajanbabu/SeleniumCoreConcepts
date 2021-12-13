package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SizeandLocationOfWebElement {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void locationOfWebElement() {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php");
		WebElement img = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
//Location
//method 1
		System.out.println("The Location(x,y) :"+img.getLocation());
		System.out.println("The Location x :"+img.getLocation().getX());
		System.out.println("The Location y :"+ img.getLocation().getY());
//method 2
		System.out.println("The Location x :"+img.getRect().getX());
		System.out.println("The Location y :"+ img.getRect().getY());

//Size of WebElement
//1
		System.out.println("The Size :"+ img.getSize());
		System.out.println("The Height :"+img.getSize().getHeight());
		System.out.println("The Width :"+img.getSize().getWidth());
//2
		System.out.println("The Height :"+img.getRect().getDimension().getHeight());
		System.out.println("The Width :"+ img.getRect().getDimension().getWidth());
		}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
