package SeleniumConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryDropDown {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void jqueryDD() {
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();
	//	selectChoiceValues(driver, "choice 1");
	//	selectChoiceValues(driver, "choice 2", "choice 2 3", "choice 6", "choice 6 2 1", "choice 6 2");
		selectChoiceValues(driver, "all");
	}
	
	public static void selectChoiceValues(WebDriver driver, String... value) {
		List<WebElement> list = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		
		if (!value[0].equalsIgnoreCase("all")){
			for (WebElement item:list) {
				String text = item.getText();
				for(String val:value) {
					if (text.equals(val)) {
						item.click();
						break;
					}
				}
			}
		} else {
			try {
			for (WebElement item:list) {
				item.click();
				}
			} catch (ElementNotInteractableException e) {
				
			}
			}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
