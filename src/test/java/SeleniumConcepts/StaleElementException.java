package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StaleElementException {
 WebDriver driver;
 
 @BeforeMethod
 public void setUp() {
	 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 
 }
 
 @Test
 public void staleElementExceptionTest() {
	 driver.get("https://pavanonlinetrainings.com/");
	 WebElement link = driver.findElement(By.xpath("//a[contains(text(),'About Me')]"));
	 link.click();
	 driver.navigate().back();
	 link.click();

 }
 
 @Test
 public void staleElementExceptionTest1() {
	 driver.get("https://pavanonlinetrainings.com/");
	 WebElement link = driver.findElement(By.xpath("//a[contains(text(),'About Me')]"));
	 link.click();
	 driver.navigate().back();
	 
	 try {
	 link.click();
	 } catch (StaleElementReferenceException e){
		 link = driver.findElement(By.xpath("//a[contains(text(),'About Me')]"));
		 link.click();

	 }
	 
 }
 
 @Test
 public void staleElementException2() {
	 driver.get("https://classic.freecrm.com/index.html");
	WebElement name =  driver.findElement(By.name("username"));
	name.sendKeys("groupautomation");
	WebElement pass = driver.findElement(By.name("password"));
	pass.sendKeys("admin123");
	driver.navigate().refresh();
	name.sendKeys("groupautomation");
	
 }
 
 @Test
 public void staleElementException3() {
	 driver.get("https://classic.freecrm.com/index.html");
	WebElement name =  driver.findElement(By.name("username"));
	name.sendKeys("groupautomation");
	WebElement pass = driver.findElement(By.name("password"));
	pass.sendKeys("admin123");
	driver.navigate().refresh();
	try {
	name.sendKeys("groupautomation");
	} catch (StaleElementReferenceException e) {
		name =  driver.findElement(By.name("username"));
		name.sendKeys("groupautomation");

	}
	
 }
 @AfterMethod
 public void tearDown() {
	 driver.quit();
 }
}
