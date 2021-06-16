package pnc.ProjectSat;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;

public class InfyTest extends BaseTest {

	LoginPg l;

	@Test
	public void f() throws IOException {
		l = new LoginPg();
		//l.verifyHamburger();
		l.verifyFooterFields();
	}

	@BeforeTest
	public void beforeTest() {
		initialize();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
