package SeleniumConcepts;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownloadWord{
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		String location = System.getProperty("user.dir")+"\\downloads\\";
	
//chrome
/*		HashMap pref = new HashMap();
		pref.put("download.default_directory", location);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", pref);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options); */
		
//Edge
/*		HashMap pref = new HashMap();
		pref.put("download.default_directory", location);
		EdgeOptions options = new EdgeOptions();
		options.setExperimentalOption("prefs", pref);
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver(options); */
		
//FireFox
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword");
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", location);
		
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
	}
	
	@Test
	public void downloadFile() {
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
	}
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
