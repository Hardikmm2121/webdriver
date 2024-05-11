package ActionClassAssignment;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnnaAssignment {
	WebDriver driver;

	@Test
	public void loginToNicheTourism() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions ac = new Actions(driver);

		// Open Annauni Website
		driver.get("https://www.annauniv.edu");
		String parentWindow = driver.getWindowHandle();

		// Move Arrow To Departments And Click On Mechanical Engineering
		// ( Unable To Click By WebElement So Click By JavaScriptExecutor )
		WebElement department = driver.findElement(By.xpath("//a[text() = 'Departments']"));
		ac.moveToElement(department).build().perform();
		WebElement me = driver.findElement(By.xpath("//a[contains(text(),'Mechanical Engineering')]"));
		wait.until(ExpectedConditions.visibilityOf(me));
		wait.until(ExpectedConditions.elementToBeClickable(me));
		js.executeScript("arguments[0].click();", me);

		//Switch To Mechanical Window And Move To Facilities And Click On AUFRC
		Set<String> twoWindow = driver.getWindowHandles();
		String mechanicalWindow = null;

		for (String oneWindow : twoWindow) {
			if (!oneWindow.equals(parentWindow)) {

				driver.switchTo().window(oneWindow);
				mechanicalWindow = driver.getWindowHandle();
				assertEquals(driver.getTitle(), "Department of Mechanical Engineering | Anna University Chennai",
						"Mechanical Engineering Site Error!!!");
				WebElement facilities = driver.findElement(By.xpath("//a[text()='Facilities']"));
				ac.moveToElement(facilities).perform();
				WebElement aufrc = driver.findElement(By.xpath("//a[text()='AUFRG']"));
				wait.until(ExpectedConditions.elementToBeClickable(aufrc)).click();
			}
		}

		//Switch To AUFRC Window And Back To The Mechanical Window
		Set<String> threeWindow = driver.getWindowHandles();

		for (String windowId : threeWindow) {
			driver.switchTo().window(windowId);
			if (driver.getTitle().equals("AU-FRG Institute for CAD/CAM - Anna University Chennai")) {
				System.out.println(driver.getCurrentUrl());
				assertEquals(driver.getTitle(), "AU-FRG Institute for CAD/CAM - Anna University Chennai");
			}
		}
		driver.switchTo().window(mechanicalWindow);
		System.out.println(driver.getTitle());
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
