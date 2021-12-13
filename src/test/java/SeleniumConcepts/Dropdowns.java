package SeleniumConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dropdowns {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void dropDown() {
		driver.get("https://www.opencart.com/index.php?route=account/register");
		WebElement dropCountry = driver.findElement(By.xpath("//select[@id='input-country']"));
		
		Select select = new Select(dropCountry);
//Using Select methods		
	/*	select.selectByVisibleText("Fiji");
		select.selectByValue("38");
		select.selectByIndex(99); */
		
//without using Select methods
		List<WebElement> allOption = select.getOptions();
		
		for (WebElement option:allOption) {
			if (option.getText().equals("Cuba")) {
			option.click();
			break;
			}
		}
		
	}
	
	@Test
	public void dropDown2() {
		driver.get("https://www.orangehrm.com/contact-sales/");
		WebElement empEle = driver.findElement(By.xpath("//select[@id='Form_submitForm_NoOfEmployees']"));
		selectOptionFromDropDown(empEle,"21 - 25");
		WebElement cntryEle = driver.findElement(By.xpath("//select[@id='Form_submitForm_Country']"));
		selectOptionFromDropDown(cntryEle,"India");
		
	}

//Generic Method for dropdown
	
	public static void selectOptionFromDropDown(WebElement ele, String Value) 
	{
		Select drp = new Select(ele);
		
		List<WebElement> allOption = drp.getOptions();
		
		for (WebElement option:allOption) {
			if (option.getText().equals(Value)) {
				option.click();
				break;
			}
		}
	}
	
	@AfterMethod
	public void tearDown() {
//	driver.quit();
	}
}
