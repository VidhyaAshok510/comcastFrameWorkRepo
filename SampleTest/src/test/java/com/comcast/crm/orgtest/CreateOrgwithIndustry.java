package com.comcast.crm.orgtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class CreateOrgwithIndustry {

	public static void main(String[] args) throws Throwable {
		FileUtility flib= new FileUtility();
		ExcelUtility elib= new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		
		
		String orgName=elib.getDataFromExcel("org", 4, 2)+ jlib.GetRandomNum();
		String industry=elib.getDataFromExcel("org", 4, 3);
		String type=elib.getDataFromExcel("org", 4, 4);
	
		
		WebDriver driver = null;
		if(BROWSER.equals("chrome")){
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")){
			driver = new FirefoxDriver();
		}
		else{
			driver = new ChromeDriver();
		}
		
		wlib.waitForPageToLOad(driver);
		
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		WebElement indust = driver.findElement(By.name("industry"));
		Select selobj= new Select(indust);
		selobj.selectByVisibleText(industry);
		
		WebElement typ = driver.findElement(By.name("accounttype"));
		Select selobj1 = new Select(typ);
		selobj1.selectByVisibleText(type);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actIndutry = driver.findElement(By.id("dtlview_Industry")).getText();
		String actType=driver.findElement(By.id("dtlview_Type")).getText();
		
		if (  actIndutry.equals(industry)) {
			System.out.println(industry + "information verified == PASS");
		}
		else {
			System.out.println(industry + "information not verified == FAIL");
		}
		if(actType.equals(type)) {
			System.out.println(type+ " information is verified ==PASS");
		}
		else {
			System.out.println(type+ " information is not verified ==FAIL");
		}
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();	*/
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL,USERNAME, PASSWORD);
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		OrganizationPage op= new OrganizationPage(driver);
		op.getCreateNewBtn().click();
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.newOrg(orgName, industry, type);
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actIndustryname=oip.getActindustry().getText();
		String actTypename=oip.getActtype().getText();
		if (  actIndustryname.equals(industry)) {
			System.out.println(industry + "information verified == PASS");
		}
		else {
			System.out.println(industry + "information not verified == FAIL");
		}
		if(actTypename.equals(type)) {
			System.out.println(type+ " information is verified ==PASS");
		}
		else {
			System.out.println(type+ " information is not verified ==FAIL");
		}
		driver.quit();
		
 
	}

}
