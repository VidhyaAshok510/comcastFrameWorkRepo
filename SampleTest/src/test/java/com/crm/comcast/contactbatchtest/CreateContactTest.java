package com.crm.comcast.contactbatchtest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.ChildwindowPage;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;
import com.crm.generic.baseutility.BaseClass;

public class CreateContactTest extends BaseClass {
	@Test(groups="smokeTest")
	public void createContactTest() throws Throwable {
		String lastname=eLib.getDataFromExcel("contact", 1, 2);
		wLib.waitForPageToLOad(driver);
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getNewContact().click();
		CreatingNewContactPage cnc = new CreatingNewContactPage(driver);
		cnc.newLastnameContact(lastname);
		ContactInfoPage cip= new ContactInfoPage(driver);
		String actLastName=cip.getActLastname().getText();
		if(actLastName.equals(lastname)) {
			System.out.println(lastname+ " information is verified ==PASS");
		}
		else {
			System.out.println(lastname+ " information is not verified ==FAIL");
		}
	}
	@Test(groups="regressionTest")
	public void createContactWithSupportDate() throws Throwable {
		String lastname=eLib.getDataFromExcel("contact", 4, 2);
		String startDate=jLib.getSystemDateYYYYMMDD();
		String endDate= jLib.getRequiredDateYYYYMMDD(30);
		
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getNewContact().click();
		CreatingNewContactPage cnc = new CreatingNewContactPage(driver);
		cnc.newContact(lastname, startDate, endDate);
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actStartDate=cip.getActStart().getText();
		String actEndDate=cip.getActEnd().getText();
		if(actStartDate.equals(startDate)) {
			System.out.println(startDate+ " information is verified ==PASS");
		}
		else {
			System.out.println(startDate+ " information is not verified ==FAIL");
		}
		if(actEndDate.equals(endDate)) {
			System.out.println(endDate+ " information is verified ==PASS");
		}
		else {
			System.out.println(endDate+ " information is not verified ==FAIL");
		}
	}
	@Test(groups="regressionTest")
	public void createContactWithOrgTest() throws Throwable {
		String orgName=eLib.getDataFromExcel("contact", 7, 2)+ jLib.GetRandomNum();;
		String lastname=eLib.getDataFromExcel("contact", 7, 3);
		wLib.waitForPageToLOad(driver);
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		OrganizationPage op= new OrganizationPage(driver);
		op.getCreateNewBtn().click();
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.newOrg(orgName);
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName=oip.getHeaderMssg().getText();
		if(actOrgName.contains(orgName)) {
			System.out.println(orgName+ " is created ==PASS");
		}
		else {
			System.out.println(orgName+ " is not created ==FAIL");
		}
		hp.getContactLink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getNewContact().click();
		CreatingNewContactPage cnc= new CreatingNewContactPage(driver);
		cnc.getLastnametext().sendKeys(lastname);
		cnc.getOrgAddBtn().click();
		wLib.switchToTabonURL(driver, "module=Accounts");
		ChildwindowPage cwp = new ChildwindowPage(driver);
		cwp.selectOrg(orgName);
		wLib.switchToTabonURL(driver, "Contacts&action");
		cnc.getSaveButtn().click();
		ContactInfoPage cip= new ContactInfoPage(driver);
		String actOrgNm=driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']/..//a")).getText();
		if(actOrgNm.equals(orgName)) {
			System.out.println(orgName+ " information is verified ==PASS");
		}
		else {
			System.out.println(orgName+ " information is not verified ==FAIL");
		}

		
	}

}
