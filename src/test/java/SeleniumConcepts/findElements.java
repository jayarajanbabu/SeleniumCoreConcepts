package SeleniumConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class findElements {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void findElement() {
		driver.get("https://demo.nopcommerce.com/");

// one Element
	WebElement search =	driver.findElement(By.xpath("//input[@id='small-searchterms']"));
	search.sendKeys("xyz");

// multiple Elements
	WebElement footerLinks = driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
	System.out.println(footerLinks.getText());

//NoSuchElementException - element not present
	WebElement searchBtn = driver.findElement(By.xpath("//button[contains(text(),'login')]"));
	}
	
	@Test
	public void findElements1() {
		driver.get("https://demo.nopcommerce.com/");

//one Element
		List<WebElement> logo = driver.findElements(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println("The number of logos are :" + logo.size());
		
//multiple WebElements
		List<WebElement> footerLinks = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println("The number of footer links are :" + footerLinks.size());
		for (int i=0; i<footerLinks.size();i++) {
			System.out.println(footerLinks.get(i).getText());
		}
		
//element not present
		List<WebElement> searchBtn1 = driver.findElements(By.xpath("//button[contains(text(),'login')]"));
		System.out.println("The number of elements are :"+searchBtn1.size());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
