package ActionClassAssignment;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleAssignment {
	WebDriver driver;

	@Test
	public void loginToNicheTourism() throws InterruptedException {

		//Open Google And Verify
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(),"Google","Google page not loaded!!");
		
		//Click On Gmail Button And Verify
		driver.findElement(By.linkText("Gmail")).click();
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(),"Gmail: Private and secure email at no cost | Google Workspace");
		
		//Click On SignIn Button And Verify
		driver.findElement(By.linkText("Sign in")).click();
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(),"Gmail");

		//Enter Email And Back To Google And Write Selenium Is Easy
		driver.findElement(By.cssSelector("input[name='identifier']")).sendKeys("rocky123@gmail.com");
		driver.navigate().back();
		driver.navigate().back();
		driver.findElement(By.name("q")).sendKeys("Selenium is easy");
		Thread.sleep(3000);
	}

	@BeforeClass
	public void beforeClass() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
