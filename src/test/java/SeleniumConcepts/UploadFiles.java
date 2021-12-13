package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFiles {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void uploadFilesSendKeys() {
		driver.get("https://www.monsterindia.com/");
		driver.findElement(By.xpath("//span[contains(text(),'Upload Resume')]")).click();
		driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\jayar\\Desktop\\Selenium\\SeleniumJava_Course content.pdf");
	}
	
	@Test
	public void uploadFilesRobotClass() {
		driver.get("https://www.monsterindia.com/");
		driver.findElement(By.xpath("//span[contains(text(),'Upload Resume')]")).click();
		WebElement selectBtn = driver.findElement(By.xpath("//input[@id='file-upload']"));
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", selectBtn);
	
		//Robot robot = new Robot();
		
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
