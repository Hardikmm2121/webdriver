package Assignment;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CookBookAlertAssignment {
	WebDriver driver;

	@Test
	public void loginToNicheTourism() throws InterruptedException {

		driver.get("http://www.cookbook.seleniumacademy.com/Alerts.html");
		driver.findElement(By.id("simple")).click();
		Alert alert1 = driver.switchTo().alert();
		assertEquals(alert1.getText(),"Hello! I am an alert box!");
		alert1.accept();
		
		driver.findElement(By.id("confirm")).click();
		Alert alert2 = driver.switchTo().alert();
		assertEquals(alert2.getText(),"Press a button!");
		alert1.accept();
		WebElement demo = driver.findElement(By.id("demo"));
		assertEquals(demo.getText(),"You Accepted Alert!");
		
		driver.findElement(By.id("prompt")).click();
		Alert alert3 = driver.switchTo().alert();
		alert3.sendKeys("Aman Gupta");
		alert3.accept();
		WebElement promptDemo = driver.findElement(By.id("prompt_demo"));
		assertEquals(promptDemo.getText(),"Hello Aman Gupta! How are you today?");
		
		

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
