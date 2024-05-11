package ActionClassAssignment;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IceFaceShowcase {
	WebDriver driver;
	WebDriverWait wait;
	
	@Test(enabled = false)
	public void goToTheSelection() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Open Website
		driver.get("http://icefaces-showcase.icesoft.org/showcase.jsf");
		assertEquals(driver.getTitle(),"ICEfaces Showcase","Site Not Loaded!!!" );
		
		//Find datatable and click
		driver.findElement(By.xpath("//a[text()='Datatable']")).click();
		
		//In the datatable click on the ace:datatable through javascript executor othewise it does not work
		WebElement dataTable = driver.findElement(By.xpath("//a[text()='ace:dataTable']"));
		js.executeScript("arguments[0].click();",dataTable);
		
		//click on the Selection through javascript executor othewise it does not work
		WebElement selection = driver.findElement(By.xpath("//div[@id='sm:j_idt646_content']//a[text()='Selection']"));
		js.executeScript("arguments[0].click();",selection);
		
		Thread.sleep(3000);


	}

	@Test
	public void selection() throws InterruptedException {

		//Open Website
		driver.get("http://icefaces-showcase.icesoft.org/showcase.jsf?grp=ace:dataTable&exp=Selection");
		
		//Click On Multiple Rows
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Multiple Rows']")));
		driver.findElement(By.xpath("//label[text()='Multiple Rows']")).click();

		//Select On Table Which Contains name = Iguana,Tamale,Pisces.
		List<WebElement> tableRows = driver
				.findElements(By.xpath("//div[@id='form:selectionTable']//table//tbody//tr"));

		for (int i = 1; i <= tableRows.size(); i++) {
			
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[@id='form:selectionTable']//table//tbody//tr[" + i + "]//td[2]")));
			
			String name =driver.findElement(By.xpath("//div[@id='form:selectionTable']//table//tbody//tr[" + i + "]//td[2]")).getText();
			
			if (name.equals("Tamale") || name.equals("Iguana") || name.equals("Pisces")) {
				
				System.out.println(name);
				
				wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//div[@id='form:selectionTable']//table//tbody//tr[" + i + "]//td[2]"))).click();
				
			}

		}
		Thread.sleep(3000);
	}

	@BeforeClass
	public void beforeClass() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
