package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ChildwindowPage;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class CreatecontactWithOrganization {

	public static void main(String[] args) throws Throwable {
		FileUtility flib= new FileUtility();
		ExcelUtility elib= new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		
		String orgName=elib.getDataFromExcel("contact", 7, 2)+ jlib.GetRandomNum();;
		String lastname=elib.getDataFromExcel("contact", 7, 3);
		
		
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
		
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String headerinfo =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if ( headerinfo .contains(orgName)) {
			System.out.println(orgName + "header verified == PASS");
		}
		else {
			System.out.println(orgName + "header not verified == FAIL");
		}
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		wlib.switchToTabonURL(driver, "module=Accounts");
		
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		wlib.switchToTabonURL(driver, "Contacts&action");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actlastname = driver.findElement(By.id("dtlview_Last Name")).getText();
		if(actlastname.equals(lastname)) {
			System.out.println(lastname+ " information is verified ==PASS");
		}
		else {
			System.out.println(lastname+ " information is not verified ==FAIL");
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
		wlib.switchToTabonURL(driver, "module=Accounts");
		ChildwindowPage cwp = new ChildwindowPage(driver);
		cwp.selectOrg(orgName);
		wlib.switchToTabonURL(driver, "Contacts&action");
		cnc.getSaveButtn().click();
		ContactInfoPage cip= new ContactInfoPage(driver);
		String actOrgNm=driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']/..//a")).getText();
		//String actOrgNm=cip.getActorg().getText();
		if(actOrgNm.equals(orgName)) {
			System.out.println(orgName+ " information is verified ==PASS");
		}
		else {
			System.out.println(orgName+ " information is not verified ==FAIL");
		}

	}
	}
		
		
	


