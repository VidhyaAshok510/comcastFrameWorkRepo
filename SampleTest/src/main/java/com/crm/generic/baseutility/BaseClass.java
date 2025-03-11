package com.crm.generic.baseutility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	public DataBaseUtility dLib = new DataBaseUtility();
	public FileUtility fLib= new FileUtility();
	public ExcelUtility eLib= new ExcelUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib= new JavaUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	@BeforeSuite(groups={"smokeTest","regressionTest"})
	public void configBS() throws SQLException {
		System.out.println("===Connect to dB===");
		
		dLib.getDbConnection();
	}

	@AfterSuite(groups={"smokeTest","regressionTest"})
	public void configAS() {
		System.out.println("===Close dB===");
		dLib.closeDbConnection();
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups={"smokeTest","regressionTest"})
	public void configBC(/*String browser*/) throws Throwable {
		System.out.println("===Launch Browser===");
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		//String BROWSER= browser;
		if(BROWSER.equals("chrome")){
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("edge")){
			driver = new EdgeDriver();
		}
		else if(BROWSER.equals("firefox")){
			driver = new FirefoxDriver();
		}
		else{
			driver = new ChromeDriver();
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
	}
	
	@AfterClass(groups={"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("===Close Browser===");
		driver.quit();
	}
	@BeforeMethod(groups={"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		System.out.println("===Login to app===");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp( URL,USERNAME, PASSWORD);
	}
	@AfterMethod(groups={"smokeTest","regressionTest"})
	public void configAM() {
		System.out.println("====Logout===");
		
		HomePage hp = new HomePage(driver);
		wLib.waitForPageToLOad(driver);
		hp.logout();
		
	}

}
