package OrangeHRMPO;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeavePage extends LoadableComponent<LeavePage>{

	@FindBy(xpath = "//h6[text()='Leave']")
	private WebElement title;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement search;
	
	@FindBy(css ="i.oxd-userdropdown-icon")
	private WebElement profileIcon; 
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logOutButton;
	
	private WebDriver driver;
	WebDriverWait wait;

	
	public LeavePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		get();		
	}
	
	public LeavePage clickOnSearchButton() {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));
		search.click();
		return this;
	}
	
	public DashboardPage backPage() {
		driver.navigate().back();
		return new DashboardPage(driver);
	}
	
	public LoginPage logOut() {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("i.oxd-userdropdown-icon")));
		profileIcon.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Logout']")));
		logOutButton.click();	
		return new LoginPage(driver);
		
	}
	
	@Override
	protected void isLoaded() throws Error {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Leave']")));
		assertEquals (title.getText(),"Leave","Leave Page Not Loaded!!");
		assertEquals (driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList","Leave Page Not Loaded!!");
	}

	@Override
	protected void load() {
		// Empty as the page is loaded automatically after successful login.
		
	}

}
