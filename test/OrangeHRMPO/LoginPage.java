package OrangeHRMPO;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends LoadableComponent<LoginPage>{
	
	@FindBy(name = "username")
	private WebElement username;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	private WebElement login;
	
	private WebDriver driver;
	private String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	private String expectedTitle = "OrangeHRM";
	WebDriverWait wait;
	
	
	public LoginPage() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		get();
	}
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		get();
	
	}
	
	public void login(String user,String pass) {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
		username.clear();
		username.sendKeys(user);
		password.clear();
		password.sendKeys(pass);
		login.click();
	}
	
	public DashboardPage successfullLogin(String user,String pass) {
		login(user,pass);
		DashboardPage dPage = new DashboardPage(driver);
		return dPage;
		
	}
	
	public LoginPage unSuccessfullLogin(String user,String pass) {
		login(user,pass);
		return this;
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	@Override
	protected void isLoaded() throws Error {
		assertEquals(driver.getTitle(),expectedTitle,"Login Page Not Loaded!!");
		
	}

	@Override
	protected void load() {
		driver.get(url);
		
	}

}
