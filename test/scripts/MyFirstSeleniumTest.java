package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstSeleniumTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://nichethyself.com/tourism/home.html");
		//driver = new FirefoxDriver();
		
		WebElement user = driver.findElement(By.name("username"));
		user.sendKeys("stc123");
		
		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys("12345");
		
		user.submit();
		//pass.submit();
		
		String expectedPageTitleAfterLogin = "My account";
		Thread.sleep(3000);
		String actualPageTitleAfterLogin = driver.getTitle();
		
		if(expectedPageTitleAfterLogin.equals(actualPageTitleAfterLogin)) {
			System.out.println("Login Successful");
		}else {
			System.out.println("Login Failed");
		}
		
		//driver.quit();
	}

}
