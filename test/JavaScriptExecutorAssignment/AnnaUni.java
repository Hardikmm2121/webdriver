package JavaScriptExecutorAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AnnaUni {
	
	WebDriver driver;
	JavascriptExecutor js;
	
  @Test
  public void clickOnDepartmentMenuThroughJSE() throws InterruptedException {
	  
	  driver.get("https://www.annauniv.edu");
	  WebElement department = driver.findElement(By.xpath("//a[text()='Departments']"));
	  js = (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].click();",department);
	  Thread.sleep(3000);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
