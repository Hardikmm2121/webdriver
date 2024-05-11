package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebElementMethods {
	WebDriver driver;

	@Test
	public void AssignmentWebElement() throws InterruptedException {

		driver.get("https://cookbook.seleniumacademy.com/Config.html");
		WebElement diesel = driver.findElement(By.xpath("//input[@value='Diesel']"));
		System.out.println("Isdisplayed or not? -" + diesel.isDisplayed());
		System.out.println("Isenabled or not? -" + diesel.isEnabled());
		System.out.println("Before clicking checkbox isselected or not? -" + diesel.isSelected());
		if (!diesel.isSelected()) {
			diesel.click();
		}
		System.out.println("After clicking checkbox isselected or not? -" + diesel.isSelected());

		String text = driver.findElement(By.xpath("//div[@id='tabs-1']/h2")).getText();
		System.out.println(text);
		
		WebElement button = driver.findElement(By.xpath("//button[@id='chatbutton']"));
		System.out.println("Button id attribute is - " + button.getAttribute("id"));
		System.out.println("Button tagname - " + button.getTagName());

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
