package POAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class OrangeHRMTest2 {

	OrangeHRMHomePageIt2 it2;

	@Test
	public void OrangeHRM() {

		it2.login("Admin", "admin123");
	}

	@BeforeClass
	public void beforeClass() {

		it2 = new OrangeHRMHomePageIt2();
	}

	@AfterClass
	public void afterClass() {

		it2.closeBrowser();
	}

}
