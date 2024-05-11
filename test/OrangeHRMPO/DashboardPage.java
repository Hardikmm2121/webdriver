package OrangeHRMPO;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends LoadableComponent<DashboardPage>{

	@FindBy(xpath = "//h6[text()='Dashboard']")
	private WebElement title;
	
	@FindBy(xpath = "//span[text()='Leave']")
	private WebElement leave;
	
	private WebDriver driver;
	WebDriverWait wait;

	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		get();	
	}

	public LeavePage leaveButton() {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Leave']")));
		leave.click();
		LeavePage lp = new LeavePage(driver);
		return lp;
	}
	
	@Override
	protected void isLoaded() throws Error {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
		assertTrue(title.isDisplayed());
		assertEquals(title.getText(),"Dashboard","Dashboard Page Not Loaded!!");
		assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index","Dashboard Page Not Loaded!!");
	}


	@Override
	protected void load() {
		// Empty as the page is loaded automatically after successful login.
		
	}
}
