package Assignment;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WikipediaAssignment {
	WebDriver driver;

	@Test
	public void wikipedia() throws InterruptedException {

		driver.get("https://www.wikipedia.org");
		
		driver.findElement(By.cssSelector("a#js-link-box-en")).click();

		driver.findElement(By.name("search")).sendKeys("Selenium");
	
		driver.findElement(By.cssSelector("button.cdx-button--action-default")).click();
		
		assertEquals(driver.getTitle(), "Selenium - Wikipedia");
		
		String heading = driver.findElement(By.cssSelector("span.mw-page-title-main")).getText();
		System.out.println("Heading :-" + heading);
	}

	@BeforeClass
	public void beforeClass() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
