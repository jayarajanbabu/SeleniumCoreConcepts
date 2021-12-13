package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOperations {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void rightClick() {
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		WebElement rightClick = driver.findElement(By.xpath("//span[contains(@class,'context-menu-on')]"));
		Actions action = new Actions(driver);
		action.contextClick(rightClick).perform();
		}
	@Test
	public void doubleClick() {
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		WebElement doubleClick = driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me To See Alert')]"));
		Actions action = new Actions(driver);
		action.doubleClick(doubleClick).perform();
	}
	@Test
	public void dragAndDrop() {
		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		WebElement washington = driver.findElement(By.xpath("//div[@id='box3']"));
		WebElement US = driver.findElement(By.xpath("//div[@id='box103']"));
		Actions action = new Actions(driver);
		action.dragAndDrop(washington, US).perform();
	}
	@Test
	public void dragAndDropImgs() {
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		WebElement img = driver.findElement(By.xpath("//img[@src='images/high_tatras2_min.jpg']"));
		WebElement trash = driver.findElement(By.xpath("//div[@id='trash']"));
		Actions action = new Actions(driver);
		action.dragAndDrop(img, trash).perform();
	}
	
	@Test
	public void mouseHover() {
		driver.get("https://demo.opencart.com/");
		WebElement desktop = driver.findElement(By.xpath("//a[contains(text(),'Desktops')]"));
		WebElement mac = driver.findElement(By.xpath("//a[contains(text(),'Mac (1)')]"));
		Actions action = new Actions(driver);
		action.moveToElement(desktop).moveToElement(mac).click().perform();
	}
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
