package SeleniumConcepts;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenKinks {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void linksLocators() {
		driver.get("https://www.amazon.com/");
		//driver.findElement(By.linkText("Today's Deals")).click();
		driver.findElement(By.partialLinkText("Deals")).click();
	}
	
	@Test
	public void printingAllLinks() {
		driver.get("https://www.amazon.com/");
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println("Number of links :"+ list.size());
		
		for (WebElement link:list) {
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));
		}
	}
	
	@Test
	public void brokenLinks() throws IOException {
		driver.get("http://www.deadlinkcity.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int brokenLinks = 0;
		for (WebElement link:links) {
		String url = link.getAttribute("href");
		if (url==null || url.isEmpty()) {
			System.out.println("url is empty");
			continue;
		}
		URL link1 = new URL(url);
		try {
			HttpURLConnection httpconn = (HttpURLConnection) link1.openConnection();
			httpconn.connect();
			if (httpconn.getResponseCode()>=400) {
				System.out.println(httpconn.getResponseCode()+url +"  is" + "  Broken Link");
				brokenLinks++;
			} else {
				System.out.println(httpconn.getResponseCode()+url + "  is" + "  Valid Link");
			}
		} catch (IOException e) {
		}
		}
		System.out.println("Number of Broken Links :" +brokenLinks);
	}

	@AfterMethod
	public void tearDown() {
		
	}
}
