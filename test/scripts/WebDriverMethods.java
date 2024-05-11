package scripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebDriverMethods {
	WebDriver driver;

	@Test
	public void loginToNicheTourism() throws InterruptedException {

		driver.get("https://nichethyself.com/tourism/home.html");
		//Thread.sleep(3000);
		driver.navigate().to("http://www.google.com"); //Same as driver.get();
		//Thread.sleep(3000);
		driver.navigate().refresh(); //Refresh the page
		//Thread.sleep(3000);
		driver.navigate().back(); //Go back 
		//Thread.sleep(3000);
		driver.navigate().forward(); //Go forward
		//Thread.sleep(3000);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		//Thread.sleep(3000);
		assertEquals(driver.getCurrentUrl(), "https://www.google.com/");
		//Get the size of your browser window
		//driver.manage().window().
		//Set the size of your browser window
		//driver.manage().
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
