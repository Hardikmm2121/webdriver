package scripts;


import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Inclass {
	WebDriver driver;

	@Test
	public void loginToNicheTourism() throws InterruptedException {

		driver.get("http://www.cookbook.seleniumacademy.com/Config.html");
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		
		driver.findElement(By.id("helpbutton")).click();
		Set<String> second = driver.getWindowHandles();
		System.out.println(second);
		
		driver.findElement(By.id("chatbutton")).click();
		Set<String> third = driver.getWindowHandles();
		System.out.println(third);
		
		driver.findElement(By.id("visitbutton")).click();
		Set<String> fourth = driver.getWindowHandles();
		System.out.println(fourth);
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> it = allWindowHandles.iterator();
		String w1 = it.next();
		System.out.println(w1);
		String w2 = it.next();
		System.out.println(w2);
		String w3 = it.next();
		System.out.println(w3);
		String w4 = it.next();
		System.out.println(w4);
		
		driver.switchTo().window(w1);
		assertEquals(driver.getTitle(),"Build my Car - Configuration");
		driver.close();
		Thread.sleep(2000);

		driver.switchTo().window(w2);
		assertEquals(driver.getTitle(),"Help");
		driver.close();
		Thread.sleep(2000);
		
		driver.switchTo().window(w3);
		assertEquals(driver.getTitle(),"");
		driver.close();
		Thread.sleep(2000);
		
		driver.switchTo().window(w4);
		assertEquals(driver.getTitle(),"Visit Us");
		driver.close();
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
