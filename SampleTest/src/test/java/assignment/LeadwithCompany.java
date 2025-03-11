package assignment;

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
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LeadPage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class LeadwithCompany {

	public static void main(String[] args) throws Throwable {
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		ExcelUtility elib = new ExcelUtility();
		
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		
		
		String company =elib.getDataFromExcel("Assign", 10, 2)+jlib.GetRandomNum();
		String lastname =elib.getDataFromExcel("Assign", 10, 3);
		
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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(company);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String headerinfo =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if ( headerinfo .contains(company)) {
			System.out.println(company + "header verified == PASS");
		}
		else {
			System.out.println(company + "header not verified == FAIL");
		}
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("company")).sendKeys(company);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actlastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		String actCompany=driver.findElement(By.id("dtlview_Company")).getText();
		
		if (  actlastName .equals(lastname)) {
			System.out.println(lastname + "information verified == PASS");
		}
		else {
			System.out.println(lastname + "information not verified == FAIL");
		}
		if(actCompany.equals(company)) {
			System.out.println(company+ " information is verified ==PASS");
		}
		else {
			System.out.println(company+ " information is not verified ==FAIL");
		}
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();	*/
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL,USERNAME, PASSWORD);
		HomePage hp = new HomePage(driver);
		hp.getLeadLink().click();
		LeadPage ldp = new LeadPage(driver);
		ldp.getAddleadBtn().click();
		ldp.lead(lastname, company);
		String headerInfo=ldp.getHeaderText().getText();
		if(headerInfo.contains(lastname)) {
			System.out.println(lastname+ " information is verified ==PASS");
		}
		else {
			System.out.println(lastname+ " information is not verified ==FAIL");
		}
		hp.logout();
 
	}


	}


