package SeleniumConcepts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsAndPopUps {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	@Test
	public void handleAlertsWithOkButton() {
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void confAlertWindow() {
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
	}
	
	@Test
	public void alertWithInput() {
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		Alert alertWindow = driver.switchTo().alert();
		System.out.println("The Msg displayed on alert :"+alertWindow.getText());
		alertWindow.sendKeys("Hello");
		alertWindow.accept();
		//alertWindow.dismiss();
	}
	
	@Test
	public void authenticatedPopUp() {
		//driver.get("https://the-internet.herokuapp.com/basic_auth");
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
//Syntax: 	http://username:password@URL
		
	}
	
	@Test
	public void permissionPopUps() {
		
	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
