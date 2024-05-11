package scripts;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TwitterAssignment {
	WebDriver driver;
	WebDriverWait wait;
	

	@Test
	public void loginToNicheTourism() throws InterruptedException {

		driver.get("https://www.twitter.com");
		//Thread.sleep(2000);
		//wait.until(ExpectedConditions.urlToBe("https://twitter.com/"));
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div")));
		List<WebElement> allDivElement = driver.findElements(By.xpath("//div"));
		System.out.println("Total div element in twitter :" + allDivElement.size());
		//Thread.sleep(10000);
		
		Set<Cookie> allCookies = driver.manage().getCookies();              //getCookies
		System.out.println("Total cookies on twitter:"+ allCookies.size());
			
		for(Cookie oneCookie : allCookies) {
			System.out.println(oneCookie.getName());
		}
		System.out.println("--------------------------------");
		
		driver.manage().deleteCookieNamed("gt");                            //deleteCookieNamed
		allCookies = driver.manage().getCookies();
		for(Cookie oneCookie : allCookies) {
			System.out.println(oneCookie.getName());
		}
		System.out.println(allCookies.size());
		System.out.println("--------------------------------");
		
		Cookie c = new Cookie("NameAddCookie", "Value");
		driver.manage().addCookie(c);                                       //addCookie
		allCookies = driver.manage().getCookies();
		for(Cookie oneCookie : allCookies) {
			System.out.println(oneCookie.getName());
		}
		System.out.println(allCookies.size());
		System.out.println("--------------------------------");
		
		Cookie b = driver.manage().getCookieNamed("NameAddCookie");        //getCookieNamed
		System.out.println(b);
		System.out.println("--------------------------------");
		
		driver.manage().deleteCookie(c);                                   //deleteCookie
		allCookies = driver.manage().getCookies();
		for(Cookie oneCookie : allCookies) {
			System.out.println(oneCookie.getName());
		}
		System.out.println(allCookies.size());
		System.out.println("--------------------------------");
		
				
		driver.manage().deleteAllCookies();								  //deleteAllCookies
		System.out.println(driver.manage().getCookies().size());
		System.out.println("--------------------------------");
		
			
	}

	@BeforeClass
	public void beforeClass() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
