package ListenerAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EventFiringTest {

	WebDriver driver, original_driver;
	MyListener myListener;

	@Test
	public void testEventFiringWebDriver() throws Exception {
		
		driver.get("https://www.wikipedia.org");
		WebElement italiano = driver.findElement(By.partialLinkText("Italiano"));
		//after findelement method called
		italiano.click();
		//after click method called
		
	}

	@BeforeMethod
	public void setUp() throws Exception {

		original_driver = new ChromeDriver(); // This does not fire events
		myListener = new MyListener();
		driver = new EventFiringDecorator(myListener).decorate(original_driver);
	}

	@AfterMethod
	public void tearDown() throws Exception {
        driver.quit();
    }
}
