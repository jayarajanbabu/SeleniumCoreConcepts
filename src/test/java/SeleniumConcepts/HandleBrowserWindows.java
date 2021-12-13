package SeleniumConcepts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void getWindowhandle() {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php");
		String windowID = driver.getWindowHandle();
		System.out.println("Window ID is "+windowID);
	}
	
	@Test
	public void getWindowHandlesByIterator() {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php");
		driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")).click();
		Set<String> windowIDs = driver.getWindowHandles();

		Iterator<String> it = windowIDs.iterator();
		String parentWindowID = it.next();
		String childWindowID = it.next();
		
		System.out.println("Parent Window ID :"+ parentWindowID);
		System.out.println("Child Window ID :"+ childWindowID);
		
		driver.switchTo().window(parentWindowID);
		System.out.println("Parent Window Title :"+ driver.getTitle());
		driver.switchTo().window(childWindowID);
		System.out.println("Child Window Title :"+ driver.getTitle());
	}

	@Test
	public void getWindowHandlesByArrayList() {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php");
		driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")).click();
		Set<String> windowIDs = driver.getWindowHandles();
		
		List<String> windowIDsList = new ArrayList(windowIDs);
		String parentWindowID = windowIDsList.get(0);
		String childWindowID = windowIDsList.get(1);
		
		System.out.println("Parent Window ID :"+ parentWindowID);
		System.out.println("Child Window ID :"+ childWindowID);
		
		driver.switchTo().window(parentWindowID);
		System.out.println("Parent Window Title :"+ driver.getTitle());
		driver.switchTo().window(childWindowID);
		System.out.println("Child Window Title :"+ driver.getTitle());
		driver.switchTo().window(parentWindowID);

	}
	
	@Test
	public void closeSpecificWindow() {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php");
		driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")).click();
		Set<String> windowIDs = driver.getWindowHandles();
		
		List<String> windowIDsList = new ArrayList(windowIDs);
		for (String winID:windowIDs) {
			String title = driver.switchTo().window(winID).getTitle();
			System.out.println(title);
			if (title.equals("OrangeHRM") || title.contains("Free HR Software")) {
				driver.close();
			}
		}
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
		//driver.quit();
		
	}
}
