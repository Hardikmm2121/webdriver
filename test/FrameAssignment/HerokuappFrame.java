package FrameAssignment;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HerokuappFrame {
	WebDriver driver;

	@Test
	public void frameTest() throws InterruptedException {

		driver.get("http://the-internet.herokuapp.com/frames");
		
		//Click on Nasted Frames
		driver.findElement(By.linkText("Nested Frames")).click();

		//Switch to top frame
		try {
			driver.switchTo().frame("frame-top");
			System.out.println("Switch to top frame");
		} catch (NoSuchFrameException e) {
			fail("Top Frame Not Found");
		}

		//Switch to top left frame
		try {
			driver.switchTo().frame("frame-left");
			System.out.println("Switch to left frame");
			WebElement left = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
			assertEquals(left.getText(), "LEFT");
			System.out.println("Left frame text:-" + left.getText());

		} catch (NoSuchFrameException e) {
			fail("Top Left Frame Not Found");
		}

		//Switch to top frame
		driver.switchTo().parentFrame();
		System.out.println("Switch to parent frame");

		//Switch to top middle frame
		try {
			driver.switchTo().frame("frame-middle");
			System.out.println("Switch to middle frame");
			WebElement middle = driver.findElement(By.cssSelector("div#content"));
			assertEquals(middle.getText(), "MIDDLE");
			System.out.println("Middle frame text:-" + middle.getText());

		} catch (NoSuchFrameException e) {
			fail("Top middle Frame Not Found");
		}
		
		//Switch to top frame
		driver.switchTo().parentFrame();
		System.out.println("Switch to parent frame");
		
		//Switch to top right frame
		try {
			driver.switchTo().frame("frame-right");
			System.out.println("Switch to right frame");
			WebElement right = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
			assertEquals(right.getText(), "RIGHT");
			System.out.println("Right frame text:-" + right.getText());

		} catch (NoSuchFrameException e) {
			fail("Top Right Frame Not Found");
		}
		
		//Switch to main html page
		driver.switchTo().defaultContent();
		System.out.println("Switch to Main Content");
		
		//Switch to bottom frame
		try {
			driver.switchTo().frame("frame-bottom");
			WebElement bottom = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
			assertEquals(bottom.getText(), "BOTTOM");
			System.out.println("Bottom frame text:-" + bottom.getText());

		}catch(NoSuchFrameException e) {
			fail("Bottom Frame Not Found");
		}
		
		//Switch to main html page
		driver.switchTo().defaultContent();
		driver.navigate().back();
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
