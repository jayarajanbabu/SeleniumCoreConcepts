package SeleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker1 {
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
	public void datePicker() {
		driver.get("http://www.redbus.in");
		String year = "2022";
		String month = "July";
		String date = "19";
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
//Pick Month Year 		
		while(true) {
			String monthyear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			String arr[] = monthyear.split(" ");
			String mon = arr[0];
			String yr = arr[1];
			
			if (mon.equalsIgnoreCase(month) && yr.equals(year)) 
				break;
			else 
				driver.findElement(By.xpath("//td[@class='next']//button")).click();
			}
//Pick Date
		List<WebElement> alldates = driver.findElements(By.xpath("//table[contains(@class,'rb-monthTable')]//td"));
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
