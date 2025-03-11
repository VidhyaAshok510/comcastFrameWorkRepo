package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

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
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateContactWithSupportData {

	public static void main(String[] args) throws Throwable {
		FileUtility flib= new FileUtility();
		ExcelUtility elib= new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib= new WebDriverUtility();
		
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		
		String lastname=elib.getDataFromExcel("contact", 4, 2);
		String startDate=jlib.getSystemDateYYYYMMDD();
		String endDate= jlib.getRequiredDateYYYYMMDD(30);
		
		
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
		
		
	/*	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actstart = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		String actend = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(actstart.equals(startDate)) {
			System.out.println(startDate+ " information is verified ==PASS");
		}
		else {
			System.out.println(startDate+ " information is not verified ==FAIL");
		}
		if(actend.equals(endDate)) {
			System.out.println(endDate+ " information is verified ==PASS");
		}
		else {
			System.out.println(endDate+ " information is not verified ==FAIL");
		}
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();	*/
		
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(URL,USERNAME, PASSWORD);
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
		hp.getSign().click();
		hp.getLogoutbtn().click();
		driver.quit();
 
	}
	}

	


