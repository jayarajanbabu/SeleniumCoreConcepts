package SeleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWebtable {
	

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void webTable() {
		driver.get("https://www.oracle.com/java/technologies/downloads/");
		
	//Count number of rows
	int rows =driver.findElements(By.xpath("//div[@id='jdk17-linux']//table[@class='otable-w2']/tbody/tr")).size();
	System.out.println("The number of rows are :"+ rows);
	
	//count the number of columns
	int cols = driver.findElements(By.xpath("//div[@id='jdk17-linux']//table[@class='otable-w2']//thead/tr/th")).size();
	System.out.println("The number of columns are :"+ cols);
	
	//Retrive a particular row
	String value = driver.findElement(By.xpath("//div[@id='jdk17-linux']//table[@class='otable-w2']//tbody/tr[2]/td[1]")).getText();
	System.out.println("Particular row value is :"+value);
	
	//Retieve all rows and columns
	System.out.println("The Table Data is : ");
	for (int r=0; r<=rows;r++) {
		for (int c=0; c<=cols;c++) {
			String data = driver.findElement(By.xpath("//div[@id='jdk17-linux']//table[@class='otable-w2']//tr["+r+"]/td["+c+"]")).getText();
			System.out.print(data + "  ");
		}
		System.out.println();
	}
	}
//Print particular values of an row	
	@Test
	public void particularValues() {
		
		driver.get("https://www.oracle.com/java/technologies/downloads/");
		int rows =driver.findElements(By.xpath("//div[@id='jdk17-linux']//table[@class='otable-w2']/tbody/tr")).size();

	for(int i=0; i<=rows;i++) {
		String product = driver.findElement(By.xpath("//div[@id='jdk17-linux']//table[@class='otable-w2']//tbody/tr["+i+"]/td[1]")).getText();
		if (product.equals("Arm 64 RPM Package")) {
			String fileSize = driver.findElement(By.xpath("//div[@id='jdk17-linux']//table[@class='otable-w2']//tbody/tr["+i+"]/td[2]")).getText();
			System.out.println("File Size is: "+ fileSize);
		}
	}	
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
