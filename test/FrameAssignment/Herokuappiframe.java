package FrameAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Herokuappiframe {
	WebDriver driver;

	@Test
	public void loginToNicheTourism() throws InterruptedException {

		driver.get("http://the-internet.herokuapp.com/frames");
		driver.findElement(By.linkText("iFrame")).click();
		
		driver.switchTo().frame("mce_0_ifr");
		WebElement text = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
		text.click();
		text.clear();
		text.sendKeys("I know how to work with iframe");
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
