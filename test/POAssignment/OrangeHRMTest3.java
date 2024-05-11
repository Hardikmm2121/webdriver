package POAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class OrangeHRMTest3 {

	OrangeHRMHomePageIt3 hrm;

	@Test
	public void OrangeHRM() {

		hrm.login("Admin", "admin123");

	}

	@BeforeClass
	public void beforeClass() {

		hrm = new OrangeHRMHomePageIt3();

	}

	@AfterClass
	public void afterClass() {
		hrm.closeBrowser();
	}

}
