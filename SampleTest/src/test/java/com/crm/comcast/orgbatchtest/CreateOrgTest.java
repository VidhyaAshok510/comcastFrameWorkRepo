package com.crm.comcast.orgbatchtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;
import com.crm.generic.baseutility.BaseClass;

public class CreateOrgTest extends BaseClass {

	@Test(groups="smokeTest")
	public void createOrgTest() throws Throwable {
		
        UtilityClassObject.getTest().log(Status.INFO, "Read data from Excel");
		String orgName = eLib.getDataFromExcel("org", 10, 2) + jLib.GetRandomNum();
		String cateogory = eLib.getDataFromExcel("org", 10, 3);
		UtilityClassObject.getTest().log(Status.INFO, "Navigate To home page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate To org page");
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewBtn().click();
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.newOrg(orgName);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMssg().getText();
		/*boolean status= cateogory.contains(orgName);
		Assert.assertEquals(status, true);*/
		if (actOrgName.equals(orgName)) {
			System.out.println(orgName + " is created ==PASS");
			UtilityClassObject.getTest().log(Status.PASS, orgName+ "created ");
		} else {
			System.out.println(orgName + " is not created ==FAIL");
			UtilityClassObject.getTest().log(Status.FAIL, orgName+ " is not created ");
		}
	}

	@Test(groups="regressionTest")
	public void createOrgWithIndustry() throws Throwable {

		String orgName = eLib.getDataFromExcel("org", 4, 2) + jLib.GetRandomNum();
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewBtn().click();
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.newOrg(orgName, industry, type);
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actIndustryname = oip.getActindustry().getText();
		String actTypename = oip.getActtype().getText();
		if (actIndustryname.equals(industry)) {
			System.out.println(industry + "information verified == PASS");
		} else {
			System.out.println(industry + "information not verified == FAIL");
		}
		if (actTypename.equals(type)) {
			System.out.println(type + " information is verified ==PASS");
		} else {
			System.out.println(type + " information is not verified ==FAIL");
		}
	}

	@Test(groups="regressionTest")
	public void createOrgWithPhnno() throws Throwable {

		String orgName = eLib.getDataFromExcel("org", 7, 2) + jLib.GetRandomNum();
		String phno = eLib.getDataFromExcel("org", 7, 3);
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewBtn().click();
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.getOrgtext().sendKeys(orgName);
		cop.getPhntext().sendKeys(phno);
		cop.getSaveBtn().click();
		;
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actPhno = oip.getActphn().getText();
		if (actPhno.equals(phno)) {
			System.out.println(phno + " information verified == PASS");
		} else {
			System.out.println(phno + " information not verified == FAIL");
		}
	}
}
