package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CookBookAssignment {
	WebDriver driver;

	@Test
	public void cookBookWedSite() throws InterruptedException {

		driver.get("http://www.cookbook.seleniumacademy.com/Config.html");
		
		driver.findElement(By.xpath("//input[@value='Diesel']")).click();
				
		WebElement absCheckbox = driver.findElement(By.name("abs"));
		if(!absCheckbox.isSelected()) {
			absCheckbox.click();
		}
				
		WebElement headLamp = driver.findElement(By.name("ledheadlamp"));
		System.out.println("Headlamp checkbox is enabled or not? " + headLamp.isEnabled());

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
