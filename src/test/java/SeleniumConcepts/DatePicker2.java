package SeleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker2 {
WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void datePicker2() {
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");	
		driver.findElement(By.xpath("//input[@id='dob']")).click();
		Select month_drp = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		month_drp.selectByVisibleText("May");
		Select year_drp = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		year_drp.selectByVisibleText("2017");
		String date = "22";
		
		List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for (WebElement ele:alldates) {
			String dt = ele.getText();
			if (dt.equals(date)) {
				ele.click();
				break;
			}
		}
	}
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	
	

}
