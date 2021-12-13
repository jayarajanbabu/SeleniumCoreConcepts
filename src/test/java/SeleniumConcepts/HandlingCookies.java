package SeleniumConcepts;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCookies {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void captureCookies() {
		driver.get("https://demo.nopcommerce.com/");
//capture cookies
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Size of cookies :"+cookies.size());
//Print cookies
		for (Cookie cookie:cookies) {
			System.out.println("The name and value of cookie :"+cookie.getName()+ " "+cookie.getValue());
		}
//Add cookie
		Cookie cookieobj = new Cookie("MyCookie", "334455");
		driver.manage().addCookie(cookieobj);
		
		cookies = driver.manage().getCookies();
		System.out.println("Size of cookies after adding:"+cookies.size());
//Delete cookie
	//	driver.manage().deleteCookie(cookieobj);
		driver.manage().deleteCookieNamed("MyCookie");
		
		cookies = driver.manage().getCookies();
		System.out.println("Size of cookies after deleting:"+cookies.size());
//Delete All cookies
		driver.manage().deleteAllCookies();
		cookies = driver.manage().getCookies();
		System.out.println("Size of cookies after deleting All:"+cookies.size());
	}
	
	@AfterMethod
	public void tearDoown() {
		driver.quit();
	}
}
