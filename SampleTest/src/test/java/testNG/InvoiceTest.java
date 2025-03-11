package testNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;

public class InvoiceTest extends BaseClass{
	@Test
	public void createInvoiceTest() {
		System.out.println("execute create Invoice Test");
		String actHeader=driver.findElement(By.linkText("Home")).getText();
		Assert.assertEquals(actHeader, "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		
		}
	@Test
	public void createInvoiceContactTest() {
		System.out.println("execute create Invoice with Contact Test");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		
		}
	@Test(retryAnalyzer=com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void activateSim() {
		System.out.println("Execute sim activation");
		Assert.assertEquals(" ", "Login");
	}
	

}
