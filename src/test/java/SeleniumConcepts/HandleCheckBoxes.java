package SeleniumConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleCheckBoxes {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void handleSingleCheckBox() {
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.findElement(By.xpath("//input[@id='monday']")).click();
		}
	
	@Test
	public void selectAllCheckboxes() {
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		List<WebElement> checkboxList = driver.findElements(By.xpath("//div[@class='form-check']//input[@type='checkbox']"));
		System.out.println("The Total check boxes :"+ checkboxList.size());
		for (int i=0; i<checkboxList.size();i++) {
			checkboxList.get(i).click();
		}
	}
	
	@Test
	public void specificCheckBoxes() {
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		List<WebElement> checkboxList = driver.findElements(By.xpath("//div[@class='form-check']//input[@type='checkbox']"));
		for (WebElement option:checkboxList) {
			String checkboxName = option.getAttribute("id");
			if (checkboxName.equals("monday") || checkboxName.equals("friday")) {
				option.click();
			}
		}
	}
	
	@Test
	public void selectLastTwoCheckBoxes() {
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		List<WebElement> checkboxList = driver.findElements(By.xpath("//div[@class='form-check']//input[@type='checkbox']"));
		int totalCheckBoxes = checkboxList.size();
		for (int i=totalCheckBoxes-3; i<totalCheckBoxes;i++) {
			checkboxList.get(i).click();
		}
	}
	
	@Test
	public void selectFirstFewCheckboxes() {
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		List<WebElement> checkboxList = driver.findElements(By.xpath("//div[@class='form-check']//input[@type='checkbox']"));
		int totalCheckBoxes = checkboxList.size();
		for (int i=0; i<totalCheckBoxes;i++) {
			if (i<2) {
				checkboxList.get(i).click();
			}
		}
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
