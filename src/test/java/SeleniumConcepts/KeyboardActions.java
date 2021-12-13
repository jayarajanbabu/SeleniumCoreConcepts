package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActions {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void keyBoardActions() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/key_presses");
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.SPACE).perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(2000);
	}
	
	@Test
	public void keyboardActionsMultiple() {
		driver.get("https://text-compare.com/");
		WebElement input1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		WebElement input2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));
		input1.sendKeys("Welcome to Selenium");
		
		Actions action = new Actions(driver);
//CTRL + A
		action.keyDown(Keys.CONTROL);
		action.sendKeys("a");
		action.keyUp(Keys.CONTROL);
		action.perform();
		
//CTRL + C
		action.keyDown(Keys.CONTROL);
		action.sendKeys("c");
		action.keyUp(Keys.CONTROL);
		action.perform();
		
//tab
		action.sendKeys(Keys.TAB);
		action.perform();
		
//CTRL + V
		action.keyDown(Keys.CONTROL);
		action.sendKeys("v");
		action.keyUp(Keys.CONTROL);
		action.perform();
		
//compare texts
		if(input1.getAttribute("value").equals(input2.getAttribute("value"))) {
			System.out.println("Text Copied");
		}else {
			System.out.println("Text not copied");
		}
	}
	@AfterMethod
	public void tearDown() {
		
	}
}
