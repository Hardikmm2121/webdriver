package ActionClassAssignment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TripHoboAction {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void TripHobo() throws InterruptedException {

		//Open Triphobo Website
		driver.get("https://www.triphobo.com/");
		
		//Click On Plan Your Next Location
		driver.findElement(By.id("plan-my-trip")).click();
		wait.until(ExpectedConditions.urlToBe("https://www.triphobo.com/trip"));

		//Fill All Details And Click On Start Planning
		driver.findElement(By.cssSelector("div.search>input")).sendKeys("Houston");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Houston, Texas, United States']"))).click();
		driver.findElement(By.cssSelector("input[placeholder='Start Date']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'ui-datepicker-group-first')]/table/tbody//tr[5]//td[3]"))
				.click();
		driver.findElement(By.xpath("//div[contains(@class,'ui-datepicker-group-last')]/table/tbody//tr[2]//td[6]"))
				.click();
		driver.findElement(By.cssSelector("div.button-box span")).click();

		//Click On Next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#js_city_step_next>span")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Skip to']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Trip Overview']"))).click();

		//Wait Until All The Element Present On That Page
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div#overview li div")));

		//Handle Disclaimer And Click On Edit Plan
		if (driver.findElement(By.cssSelector("div.disclaimer-box ")).isDisplayed()) {
			driver.findElement(By.cssSelector("span.icon-close")).click();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Edit This Plan']"))).click();
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.cssSelector("div.fc-view-container table tbody tr")));

		//Drag And Drop
		wait.until(ExpectedConditions
				.visibilityOfElementLocated
				(By.xpath("//div[@title='Nassau Bay Peninsula Wildlife Park']")));
		WebElement dragPart = driver.findElement(
				By.xpath("//div[@title='Nassau Bay Peninsula Wildlife Park']"));
		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@data-full='8:00 AM - 9:00 AM']/parent::div/parent::a[@title='Free time']")));
		WebElement dropPart = driver.findElement(
				By.xpath("//div[@data-full='8:00 AM - 9:00 AM']/parent::div/parent::a[@title='Free time']"));
		
		Actions ac = new Actions(driver);
		ac.dragAndDrop(dragPart, dropPart).perform();
		
		//Save And Finish Planning
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(@class,'save-to-plan')]")));
		WebElement savePlan = driver.findElement(By.xpath("//span[contains(@class,'save-to-plan')]"));
		
		ac.moveToElement(savePlan).click(savePlan).build().perform();
		
		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Finish Planning']"))).click();
		
		
	}

	@BeforeClass
	public void beforeClass() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
