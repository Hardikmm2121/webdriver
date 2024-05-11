package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Goibibo {
	WebDriver driver;
	
	@Test(enabled = false)
	public void goibibo1() throws InterruptedException {

		driver.get("https://www.goibibo.com/");
		
		driver.findElement(By.className("logSprite")).click();
		
		driver.findElement(By.cssSelector("div.hFZOAX p.bhnHeQ")).click();
		WebElement ben = driver.findElement(By.cssSelector("input[type='text']"));
		ben.sendKeys("Ben");
		driver.findElement(By.cssSelector("li[tabindex='0']")).click();
		
		Thread.sleep(2000);
		
	}
	
	@Test
	public void goibibo2() throws InterruptedException {
		
		driver.get("https://www.goibibo.com/");
		
		driver.findElement(By.className("logSprite")).click();
		
		driver.findElement(By.cssSelector("div.hFZOAX p.bhnHeQ")).click();
		WebElement ben = driver.findElement(By.cssSelector("input[type='text']"));
		ben.sendKeys("Pune");
		driver.findElement(By.cssSelector("li[tabindex='0']")).click();

	
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Delhi");
		driver.findElement(By.cssSelector("li[tabindex='0']")).click();
		
		driver.findElement(By.cssSelector("div.iHoHRr span.cUvQPq")).click();
		
		driver.findElement(By.cssSelector("div[aria-label='Mon Apr 08 2024']")).click();
		
		
		driver.findElement(By.cssSelector("span.fswDownArrowTraveller")).click();
		
		driver.findElement(By.xpath("//p[text()='Adults']/ancestor::div[contains(@class,'izaxVp')]//span[3]")).click();
		
		driver.findElement(By.xpath("//li[text()='business']")).click();
		
		driver.findElement(By.cssSelector("a.cBPtpd")).click();
		
		Thread.sleep(3000);
	}

	@BeforeClass
	public void beforeClass() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
