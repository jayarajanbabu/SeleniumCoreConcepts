package SeleniumConcepts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavascriptExecutormethods {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void drawBorderandTakeScreenshot() throws IOException {
		driver.get("https://www.nopcommerce.com/en");
		WebElement logo = driver.findElement(By.xpath("//div[@class='header-logo']"));
		JavascriptExecutorUtil.drawBorder(logo, driver);
		
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		File tgt = new File(".\\screenshots\\logo.png");
		FileUtils.copyFile(src, tgt);
		}
	
	@Test
	public void getTitleandInnerText() {
		driver.get("https://www.nopcommerce.com/en");
		String title = JavascriptExecutorUtil.getTitleByJS(driver);
		System.out.println("The page title is :"+title);
	
	}
	@Test
	public void pageInnerText() {
		driver.get("https://www.nopcommerce.com/en");
		System.out.println(JavascriptExecutorUtil.getPageInnerText(driver));
	}
	
	@Test
	public void clickElement() {
		driver.get("https://www.nopcommerce.com/en");
		WebElement link = driver.findElement(By.xpath("//a[contains(text(),'Partners')]"));
		JavascriptExecutorUtil.clickElementByJS(link, driver);
	}
	
	@Test
	public void generateAlert() {
		driver.get("https://www.nopcommerce.com/en");
		JavascriptExecutorUtil.generateAlert(driver, "Test Alert");
	}
	
	@Test
	public void refreshBrowser() {
		driver.get("https://www.nopcommerce.com/en");
		JavascriptExecutorUtil.refreshBrowserByJS(driver);
	}
	
	@Test
	public void scrollDownandUp() throws InterruptedException {
		driver.get("https://www.nopcommerce.com/en");
		JavascriptExecutorUtil.scrollPageDown(driver);
	//	Thread.sleep(4000);
		//JavascriptExecutorUtil.scrollPageUp(driver);
		}
	
	@Test
	public void scrollIntoView() {
		driver.get("https://www.nopcommerce.com/en");
		WebElement featuresLink = driver.findElement(By.xpath("//div[@class='all-services-button']//a[contains(text(),'View all features')]"));
		JavascriptExecutorUtil.scrollIntoView(featuresLink, driver);
	}
	
	@Test
	public void zoomPage() {
		driver.get("https://www.nopcommerce.com/en");
		JavascriptExecutorUtil.zoomPageByJS(driver);
	}
	
	@Test
	public void flash() {
		driver.get("https://classic.crmpro.com/index.html");
		WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutorUtil.flash(submit, driver);
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

	

}
