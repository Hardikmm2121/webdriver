package OrangeHRMPO;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestForOrangeHRM {

	LoginPage lp;

	@Test
	public void testHRM() throws InterruptedException {

		lp.successfullLogin("Admin", "admin123").leaveButton().clickOnSearchButton().logOut();

		Thread.sleep(3000);
	}

	@BeforeClass
	public void beforeClass() {

		lp = new LoginPage();
	}

	@AfterClass
	public void afterClass() {

		lp.closeBrowser();
	}

}
