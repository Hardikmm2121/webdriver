package Assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyTemplateTestNGClass {
	WebDriver driver;

	@Test
	public void loginToNicheTourism() throws InterruptedException {

		driver.get("");

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
