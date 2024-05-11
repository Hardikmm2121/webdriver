package Assignment;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CookBook2 {
	WebDriver driver;

	@Test
	public void loginToNicheTourism() throws InterruptedException {

		driver.get("http://www.cookbook.seleniumacademy.com/Config.html");
		String mainWindow = driver.getWindowHandle();
		System.out.println(mainWindow);
		driver.findElement(By.id("helpbutton")).click();
		driver.switchTo().window("HelpWindow");
		WebElement bulildCar = driver.findElement(By.xpath("//h3"));
		assertEquals(bulildCar.getText(),"Build my Car - Configuration Help");
		driver.close();
		driver.switchTo().window(mainWindow);
		Thread.sleep(2000);
		driver.findElement(By.id("chatbutton")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("visitbutton")).click();
		Thread.sleep(2000);
		Set<String> allWindow = driver.getWindowHandles();
		System.out.println(allWindow);
		Iterator<String> itr = allWindow.iterator();
		String parentWindow = itr.next();
		String visitWindow = itr.next();
		String chatWindow = itr.next();
		
		
		driver.switchTo().window(chatWindow);
		WebElement pelement = driver.findElement(By.xpath("//p"));
		assertEquals(pelement.getText(),"Wait while we connect you to Chat...");
		
		driver.switchTo().window(visitWindow);
		assertEquals(driver.getTitle(),"Visit Us");
		driver.close();
		
		driver.switchTo().window(chatWindow);
		driver.close();
		
		driver.switchTo().window(parentWindow);
		driver.findElement(By.cssSelector("input[value='Petrol']")).click();
		Thread.sleep(2000);
		
		
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
