package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class MyFirstTestNGTest {

	WebDriver driver;

	@Test // Test case 1.
	public void googleTest() {
			
		driver.get("https://www.google.com");
		WebElement serch = driver.findElement(By.name("q"));
		serch.sendKeys("Niche thyself");
	}

	@Test // Test case 2.
	public void loginToNicheTourism() throws InterruptedException {

		driver.get("https://nichethyself.com/tourism/home.html");
		WebElement user = driver.findElement(By.name("username"));
		user.sendKeys("stc123");

		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys("12345");

		user.submit();
		// pass.submit();

		String expectedPageTitleAfterLogin = "My account";
		Thread.sleep(3000);
		String actualPageTitleAfterLogin = driver.getTitle();
		// assertEquals(actualPageTitleAfterLogin, expectedPageTitleAfterLogin);
		assertEquals(actualPageTitleAfterLogin, expectedPageTitleAfterLogin, "Seems looking different...");
	}

	@BeforeMethod // Executes before every test.
	public void beforeMethod() {

	}

	@AfterMethod // Executes after every test.
	public void afterMethod() {

	}

	@BeforeClass // Execute only once before first test. 
	public void beforeClass() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterClass // Execute only once after last test.
	public void afterClass() {
		
		driver.quit();
	}

}
