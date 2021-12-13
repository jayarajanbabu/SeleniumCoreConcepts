package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InputBoxAndgetAttribute {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();		
	}
	
	@Test
	public void inputBox() {
		driver.get("https://demoqa.com/automation-practice-form");
		WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
		System.out.println("The getAttribute() method :" +email.getAttribute("placeholder"));
		System.out.println("The getText() method :" +email.getText());
		
		
		WebElement emailLabel = driver.findElement(By.xpath("//label[@id='userEmail-label']"));
		System.out.println("The Label of Email text box getAttribute() :"+emailLabel.getAttribute("id"));
		System.out.println("The Label of Email text box getText() is :"+ emailLabel.getText());
		
		WebElement pageName = driver.findElement(By.xpath("//div[@class='main-header']"));
		System.out.println("The page Label getAttribute() is :"+pageName.getAttribute("class"));
		System.out.println("The page Label getText() is :"+ pageName.getText());
		email.clear();
		email.sendKeys("sarahjohn@gmail.com");
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
