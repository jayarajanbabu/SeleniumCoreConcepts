package SeleniumConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusOfWebElement {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void isDisplayedTest() {
		driver.get("https://www.demoqa.com/automation-practice-form");
		WebElement name = driver.findElement(By.xpath("//label[@id='userName-label']"));
		//Assert.assertTrue(name.isDisplayed());
		System.out.println("The Display Status :" + name.isDisplayed());
	}
	
	@Test
	public void isEnabledTest() {
		driver.get("https://www.demoqa.com/automation-practice-form");
		WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
		System.out.println("The Enabled Status :" + email.isEnabled());
	}
	
	@Test
	public void isSelectedTest() {
		driver.get("https://www.demoqa.com/automation-practice-form");
		WebElement maleRadioBtn = driver.findElement(By.xpath("//label[contains(text(), 'Male')]"));
		//WebElement FemailRadioBtn = driver.findElement(By.xpath("//label[contains(text(), 'Female')]"));
		//System.out.println("The Male Selected Status :"+ maleRadioBtn.isSelected());
		//System.out.println("The Female Selected Status :" + FemailRadioBtn.isSelected());
		maleRadioBtn.click();
		System.out.println("The Male Selected Status :"+ maleRadioBtn.isSelected());
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,200)", "");
		
		WebElement sportsCB = driver.findElement(By.xpath("//label[contains(text(), 'Sports')]"));
		sportsCB.click();
		System.out.println("The Sports Selected Status :" + sportsCB.isSelected());

	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
