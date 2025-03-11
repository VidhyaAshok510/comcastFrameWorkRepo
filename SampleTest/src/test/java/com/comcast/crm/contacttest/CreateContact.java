package com.comcast.crm.contacttest;

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

public class CreateContact {

	public static void main(String[] args) throws Throwable {
		FileUtility flib= new FileUtility();
		ExcelUtility elib= new ExcelUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
				
		String lastname=elib.getDataFromExcel("contact", 1, 2);
		
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
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
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
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(URL,USERNAME, PASSWORD);
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
		
		hp.getSign().click();
		hp.getLogoutbtn().click();
		driver.quit();
 
	}
	}


