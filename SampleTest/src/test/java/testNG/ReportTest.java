package testNG;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReportTest {
	@Test
	public void homePageTest(Method mtd) {
		Reporter.log(mtd.getName()+"Test Start",true);
		Reporter.log("Step 1",true);
		Reporter.log("Step 2",false);
		Reporter.log("Step 3",true);
		Reporter.log("Step 4",true);
		Reporter.log(mtd.getName()+"Test Start");
	}
	@Test
	public void verifyLogohomePageTest(Method mtd) {
		Reporter.log(mtd.getName()+"Test Start",true);
		Reporter.log("Step 1",true);
		Reporter.log("Step 2",true);
		Reporter.log("Step 3",true);
		Reporter.log("Step 4",true);
		Reporter.log(mtd.getName()+"Test Start");
	}
	

}
