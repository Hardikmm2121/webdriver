package ListenerAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class MyListener implements WebDriverListener{
	
	@Override
	public void afterClick(WebElement element) {
	
		System.out.println("Inside afterClickOn");
		
	}
	
	@Override
	public void afterFindElement(WebElement element, By by, WebElement element1) {
		
		System.out.println("Inside afterFindBy");
		
	}

}
