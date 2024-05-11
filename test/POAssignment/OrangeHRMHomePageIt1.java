package POAssignment;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMHomePageIt1 {
	
	private WebElement username;
	private WebElement password;
	private WebElement login;
	private WebDriver driver;
	private String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	
	public OrangeHRMHomePageIt1(){
		driver = new ChromeDriver();
		driver.get(url);
		assertEquals(driver.getTitle(),"OrangeHRM", "site does not open!!!");
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
		username = driver.findElement(By.name("username"));
		password = driver.findElement(By.name("password"));
		login = driver.findElement(By.cssSelector("button[type='submit']"));
	}
	
	public void login(String user , String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		login.click();
		
	}
	

	public void closeBrowser() {
		driver.quit();
	}

}
