package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoqaWebPage {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void loginToNicheTourism() throws InterruptedException {

		//Open Website
		driver.get("https://demoqa.com/automation-practice-form");

		//Verify The City Dropdown Is Enable Or Not
		WebElement city = driver
				.findElement(By.xpath("//div[@class=' css-1fhf3k1-control']//div[@class=' css-1wy0on6']"));
		System.out.println("City dropdown is enabled - " + city.isEnabled());
		

		//Type The First And Last Name Nd Get What I Write
		WebElement firstname = driver.findElement(By.id("firstName"));
		firstname.sendKeys("Aman");
		System.out.println(firstname.getAttribute("value"));

		WebElement lastname = driver.findElement(By.id("lastName"));
		lastname.sendKeys("Gupta");
		System.out.println(lastname.getAttribute("value"));

		//Write Mail , Click On Gender Which You Can Choose And Number.
		WebElement email = driver.findElement(By.id("userEmail"));
		email.sendKeys("Aman1234@gmail.com");

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", email);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='gender-radio-1']"))).click();

		driver.findElement(By.id("userNumber")).sendKeys("1234567890");

		//Complete The Date Picker Of Date Of Birth
		driver.findElement(By.cssSelector("input#dateOfBirthInput")).click();
		WebElement selectMonth = driver.findElement(By.className("react-datepicker__month-select"));
		Select month = new Select(selectMonth);
		month.selectByVisibleText("June");
		WebElement selectYear = driver.findElement(By.className("react-datepicker__year-select"));
		Select year = new Select(selectYear);
		year.selectByVisibleText("2001");
		driver.findElement(By.xpath("//div[@aria-label='Choose Friday, June 1st, 2001']")).click();
		Thread.sleep(3000);

		//Type The Subject And Click On Hobby
		WebElement subject = driver.findElement(By.id("subjectsInput"));
		subject.sendKeys("Chemistry");
		subject.sendKeys(Keys.ENTER);

		WebElement checkbox = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
		if (!checkbox.isSelected()) {
			checkbox.click();
		}

		//Type An Address 
		WebElement address = driver.findElement(By.id("currentAddress"));
		address.sendKeys("Ahmedabad");

		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", address);

		//Handle State And City Dropdown
		WebElement state = driver.findElement(By.xpath("//div[text()='Select State']/parent::div"));
		state.click();
		WebElement state2 = driver.findElement(By.id("react-select-3-input"));
		state2.sendKeys("Har");
		state2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		WebElement city1 = driver.findElement(By.xpath("//div[text()='Select City']/parent::div"));
		city1.click();
		WebElement city2 = driver.findElement(By.id("react-select-4-input"));
		city2.sendKeys("kar");
		city2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

	}

	@BeforeClass
	public void beforeClass() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
