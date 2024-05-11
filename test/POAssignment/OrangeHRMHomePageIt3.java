package POAssignment;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMHomePageIt3 {
	
	private By username = By.name("username");
	private By password = By.name("password");
	private By login = By.cssSelector("button[type='submit']");
	private WebDriver driver;
	private String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	
	public OrangeHRMHomePageIt3(){
		driver = new ChromeDriver();
		driver.get(url);
		assertEquals(driver.getTitle(),"OrangeHRM", "site does not open!!!");

	}
	
	public void login(String user , String pass) {
		
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(login).click();
		
	}
	

	public void closeBrowser() {
		driver.quit();
	}

}
