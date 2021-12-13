package SeleniumConcepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDropDownsSorted {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void checkDDSorted() {
		driver.get("https://www.twoplugs.com/newsearchserviceneed");
		WebElement drpElement = driver.findElement(By.xpath("//select[@name='category_id']"));
		Select drpSelect = new Select(drpElement);
		
		List<WebElement> options = drpSelect.getOptions();
		
		ArrayList originalList = new ArrayList();
		ArrayList tempList = new ArrayList();
		
		for (WebElement option:options) {
			originalList.add(option.getText());
			tempList.add(option.getText());
		}
		System.out.println("Original List :"+originalList);
		System.out.println("TempList List :"+tempList);
		
		Collections.sort(tempList);
		System.out.println("Original List after sort :"+originalList);
		System.out.println("TempList List after sort :"+tempList);

		if (originalList.equals(tempList))
		{
			System.out.println("DropDowns are sorted...");
		} else {
			System.out.println("DropDown are not sorted");
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
