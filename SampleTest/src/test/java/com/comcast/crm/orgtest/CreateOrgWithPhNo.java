package com.comcast.crm.orgtest;

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

public class CreateOrgWithPhNo {

	public static void main(String[] args) throws Throwable {
		FileUtility flib= new FileUtility();
		ExcelUtility elib= new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		
		String orgName=elib.getDataFromExcel("org", 7, 2)+ jlib.GetRandomNum();
		String phno=elib.getDataFromExcel("org", 7, 3);
		
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
		driver.findElement(By.id("phone")).sendKeys(phno);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actphno = driver.findElement(By.id("dtlview_Phone")).getText();
		String actType=driver.findElement(By.id("dtlview_Type")).getText();
		
		if (  actphno.equals(phno)) {
			System.out.println(phno + " information verified == PASS");
		}
		else {
			System.out.println(phno + " information not verified == FAIL");
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
		cop.getOrgtext().sendKeys(orgName);
		cop.getPhntext().sendKeys(phno);
		cop.getSaveBtn().click();;
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actPhno=oip.getActphn().getText();
		if (  actPhno.equals(phno)) {
			System.out.println(phno + " information verified == PASS");
		}
		else {
			System.out.println(phno + " information not verified == FAIL");
		}
		hp.getSign().click();
		hp.getLogoutbtn().click();
		driver.quit();
 
	}


	}


