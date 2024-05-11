package scripts;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleLinkTest {
	WebDriver driver;

	@Test
	public void showGoogleLinks() throws InterruptedException {

		driver.get("https://www.google.com");

		List<WebElement> allgoogleLinks = driver.findElements(By.xpath("//a"));
		System.out.println("Total links on google" + ":" + allgoogleLinks.size());

		for (WebElement oneElement : allgoogleLinks) {
			System.out.println(oneElement.getText() + "-" + oneElement.getAttribute("href"));
		}

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
