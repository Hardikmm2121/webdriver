package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindowSize {
	WebDriver driver;

	@Test
	public void loginToNicheTourism() throws InterruptedException {

		WebElement serch = driver.findElement(By.name("q"));
		serch.sendKeys("Niche thyself");
		//Thread.sleep(2000);
	}

	@BeforeClass
	public void beforeClass() throws InterruptedException {

		driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		//Thread.sleep(2000);
		
		driver.manage().window().fullscreen();
		//Thread.sleep(2000);
		
		driver.manage().window().minimize();
		//Thread.sleep(2000);
		
		driver.manage().window().maximize();
		//Thread.sleep(2000);
		
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();
		
		Dimension d = new Dimension(width / 2, height);
		
		driver.manage().window().setSize(d);
		//Thread.sleep(2000);
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
