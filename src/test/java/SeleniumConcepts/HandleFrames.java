package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleFrames {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void iframes() {
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
//First iframe
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("//a[contains(text(),'org.openqa.selenium')]")).click();
		driver.switchTo().defaultContent();
//Second iframe
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//span[contains(text(),'HasAuthentication')]")).click();
		driver.switchTo().defaultContent();
//Third iframe
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//a[contains(text(),'Deprecated')]")).click();
	}
	
	@Test
	public void inneriFrame() {
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.findElement(By.xpath("//a[contains(text(),'Iframe with in an Iframe')]")).click();
		WebElement outerFrame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(outerFrame);
		WebElement innerFrame = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(innerFrame);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Welcome");
		}
	
	@Test
	public void innerframes() {
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		driver.switchTo().frame("iframeResult");
		driver.switchTo().frame(0);
		
		System.out.println("Inner Frame Msg :"+driver.findElement(By.xpath("//h1")).getText());
		driver.switchTo().parentFrame();  
		String text = driver.findElement(By.xpath("//p[contains(text(),'You can use the height and width attributes to specify the size of the iframe:')]")).getText();
		System.out.println("The Outer frame Msg :"+text);
	}
	@AfterMethod
	public void tearDown() {
		//driver.quit();
		
	}
}
