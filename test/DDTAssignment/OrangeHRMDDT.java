package DDTAssignment;

import org.testng.annotations.Test;

import POAssignment.OrangeHRMHomePageIt1;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class OrangeHRMDDT {
	OrangeHRMHomePageIt1 homePage;

//	@Test(dataProvider = "HardCode", dataProviderClass = DataProviders.class)
	public void hardCodeDDT(String username, String password) {
		homePage.login(username, password);
	}

//	@Test(dataProvider = "loginDataFromXLS", dataProviderClass = DataProviders.class)
	public void loginDataComingFromXLS(String username, String password) {
		homePage.login(username, password);
	}
	
	@Test(dataProvider = "loginDataFromCSV", dataProviderClass = DataProviders.class)
	public void loginDataComingFromCSV(String username, String password) {
		homePage.login(username, password);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		homePage = new OrangeHRMHomePageIt1();

	}

	@AfterMethod
	public void afterMethod() {
		homePage.closeBrowser();
	}

}
