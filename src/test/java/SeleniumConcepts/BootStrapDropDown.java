package SeleniumConcepts;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BootStrapDropDown {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
	
	@Test
	public void bootStrapDropDown() {
		driver.get("https://www.jquery-az.com/bootstrap4/demo.php?ex=79.0_1");
		driver.findElement(By.xpath("//button[@id='btnDropdownDemo']")).click();
		List<WebElement> productTypes =	driver.findElements(By.xpath("//div[contains(@class,'dropdown-menu show')]//a"));
		System.out.println("The number of product types are :"+productTypes.size());
		
		
		for (WebElement option:productTypes) {
			if (option.getText().equals("HTML")) {
				option.click();
				break;
			}
		}
		
	}
	
	@Test
	public void bootStrapDD() {
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.findElement(By.xpath("//span[@class='multiselect-selected-text']")).click();
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container dropdown-menu')]//li//a//label"));
		System.out.println(options.size());

		for (WebElement option:options) {
			if (option.getText().equals("Angular")) {
				option.click();
				break;
			}
		} 
		
/*		for (int i=0; i<options.size();i++) {
			if (options.get(i).getText().contains("Angular")) {
				options.get(i).click();
				options.get(i).click();
				break;
			}
		} */
	}

	@Test
	public void bootStrapDD2() {
		driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,400)", "");
		driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'dropdown-menu show')]//a"));
		System.out.println(list.size());
		
		for (WebElement option:list) {
			System.out.println(option.getText());
			if (option.getText().contains("Another action")) {
				option.click();
			break;
			}
		}
	}
	
	@Test
	public void gmailDD() {
		driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%26ogbl%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.findElement(By.xpath("//span[contains(text(),'Create account')]")).click();
		List<WebElement> gmailList = driver.findElements(By.xpath("//ul[@aria-label='Create account']//li"));
		System.out.println("The gmail list :"+gmailList.size());
		
		for(WebElement option:gmailList) {
			System.out.println("The Options are :"+option.getText());
			if (option.getText().contains("For my child")) {
				option.click();
				break;
			}
		}
	}
	
	@AfterMethod
	public void tearDown() {
	//driver.quit();
	}
}
