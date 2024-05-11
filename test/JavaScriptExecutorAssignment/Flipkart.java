package JavaScriptExecutorAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Flipkart {
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;
	
  @Test
  public void seeTheShopsyAndClick() {
	  
	  driver.get("https://www.flipkart.com");
	  WebElement shopsy = driver.findElement(By.xpath("//a[contains(text(),'Shopsy')]"));
	  
	  js = (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView(true);", shopsy);
	  	  
	  wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOf(shopsy));
	  
	  js.executeScript("arguments[0].click();", shopsy);
	  
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
