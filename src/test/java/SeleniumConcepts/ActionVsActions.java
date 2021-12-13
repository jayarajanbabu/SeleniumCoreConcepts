package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionVsActions {
WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	@Test
	public void ActionsVsAction() {
		driver.get("http://automationpractice.com/index.php");
		WebElement women = driver.findElement(By.xpath("//a[@title='Women']"));
//Actions is a class		
		Actions actions = new Actions(driver);
		actions.moveToElement(women).perform();
//Action is an Interface		
		WebElement dresses = driver.findElement(By.xpath("//a[@title='Dresses']"));
		Action action = actions.moveToElement(dresses).build();
		action.perform();
	}
	@AfterMethod
	public void tearDown() {
		
	}
}
