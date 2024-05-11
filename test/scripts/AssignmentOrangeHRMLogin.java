package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class AssignmentOrangeHRMLogin {

	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void orangeHRMLogin() throws InterruptedException {
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username"))).sendKeys("Admin");
//		WebElement user = driver.findElement(By.name("username"));
//		user.sendKeys("Admin");
		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys("admin123");
		pass.submit();
		
		String expectedResultAfterLogin = "OrangeHRM";
		//Thread.sleep(3000);
		String actualResultAfterLogin = driver.getTitle();
		assertEquals(actualResultAfterLogin, expectedResultAfterLogin, "Login Failed");
		
		wait
			.until(ExpectedConditions
				.textToBePresentInElementLocated(By.className("oxd-topbar-header-breadcrumb"), "Dashboard"));
		WebElement pageHeader = driver.findElement(By.className("oxd-topbar-header-breadcrumb"));
		//System.out.println(pageHeader.getText());
		System.out.println(pageHeader.isDisplayed());
		String expectedResult = "Dashboard";
		assertEquals(pageHeader.getText(), expectedResult);
	
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
