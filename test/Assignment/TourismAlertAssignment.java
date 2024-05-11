package Assignment;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TourismAlertAssignment {
	WebDriver driver;
	

	@Test
	public void alertWindowPopUp() throws InterruptedException {

		driver.get("http://nichethyself.com/tourism/home.html");
		
		driver.findElement(By.linkText("Customized tours")).click();

		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> it = allWindowHandles.iterator();
		String parentWindow = it.next();
		String childWindow1 = it.next();
		
		
		
		
		try {
			driver.switchTo().window(childWindow1);
			WebElement stay = driver.findElement(By.id("days"));
			Select select = new Select(stay);
			select.selectByVisibleText("Home Stay");
			driver.findElement(By.xpath("//label[text()='England']")).click();
			driver.findElement(By.className("link")).click();
			
			
			try {
			
				driver.switchTo().window("Contact");
				driver.findElement(By.className("glyphicon-search")).click();
								
				try {
					Alert alert = driver.switchTo().alert();
					assertEquals(alert.getText(), "Enter your location:");
					alert.sendKeys("London");
					alert.accept();
					driver.close();
					try {
						driver.switchTo().window(childWindow1);
						driver.findElement(By.className("btn-primary")).click();
						try {
							driver.switchTo().alert();
							alert.accept();
							
						}catch(Exception e) {
							
						}
					}catch(Exception e) {
						
					}
					
				}catch(NoAlertPresentException e) {
					
				}
				
			}catch(NoSuchWindowException e) {
				fail("Exception in child window 1.");				
			}
			
		} catch (Exception e) {
			System.out.println("Exception in parent window");
		}
		
		driver.switchTo().window(parentWindow);
		driver.findElement(By.name("username")).sendKeys("stc123");
		Thread.sleep(2000);

	}

	@BeforeClass
	public void beforeClass() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

		
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
