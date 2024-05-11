package POAssignment;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class OrangeHRMHomePageIt2 {
	
	@FindBy(name = "username")
	private WebElement username;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(css = "button[type='submit']")
	private WebElement login;
	
	private WebDriver driver;
	private String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	private String expectedTitle = "OrangeHRM";
	
	public OrangeHRMHomePageIt2(){
		
		driver = new ChromeDriver();
		driver.get(url);
		assertEquals(driver.getTitle(),expectedTitle, "site does not open");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
		PageFactory.initElements(driver, this);
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
