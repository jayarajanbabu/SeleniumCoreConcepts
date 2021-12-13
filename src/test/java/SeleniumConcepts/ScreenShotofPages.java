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

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotofPages {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void fullPageScreenShot() throws IOException {
		driver.get("https://demo.nopcommerce.com/");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File tgt = new File(".\\screenshots\\fullpage.png");
		FileUtils.copyFile(src, tgt);
	}
	
	@Test 
	public void sectionPageScreenShot() throws IOException {
		driver.get("https://demo.nopcommerce.com/");
		WebElement section = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File src = section.getScreenshotAs(OutputType.FILE);
		File tgt = new File(".\\screenshots\\section.png");
		FileUtils.copyFile(src, tgt);
	}
	
	@Test
	public void screenshotofWebElement() throws IOException {
		driver.get("https://demo.nopcommerce.com/");
		WebElement ele = driver.findElement(By.xpath("//div[@class='header-logo']//img"));
		File src = ele.getScreenshotAs(OutputType.FILE);
		File tgt = new File(".\\screenshots\\ele.png");
		FileUtils.copyFile(src, tgt);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
