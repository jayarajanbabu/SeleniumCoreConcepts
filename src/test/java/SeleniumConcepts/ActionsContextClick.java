package SeleniumConcepts;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsContextClick {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement contextButton = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions action = new Actions(driver);
		action.contextClick(contextButton).build().perform();
		
		By xpath = By.xpath("//ul[@class='context-menu-list context-menu-root']/li[contains(@class,'context-menu-icon')]/span");
		contextClick(xpath, "Quit");
	}
	
	public static void contextClick(By locator, String valueName) throws InterruptedException {
		List<WebElement> options = driver.findElements(locator);
		for (WebElement e:options) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(valueName)) {
			e.click();
			Alert alert = driver.switchTo().alert();
			Thread.sleep(3000);
			alert.accept();
			break;
			}
		}
	}

}
