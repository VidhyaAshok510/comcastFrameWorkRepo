package assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
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
import com.comcast.crm.objectrepositoryutility.CreatingNewOppPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OpportunitiesPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class OpportunitiesWithOrganization {

	public static void main(String[] args) throws Throwable {
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		ExcelUtility elib = new ExcelUtility();
		
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		
		String orgName = elib.getDataFromExcel("assign", 7, 2)+jlib.GetRandomNum();
		String potentialname = elib.getDataFromExcel("assign", 7, 3)+jlib.GetRandomNum();
		
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
		driver.findElement(By.linkText("Opportunities")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		driver.findElement(By.name("potentialname")).sendKeys(potentialname);
		
		driver.findElement(By.xpath("//input[@name='related_to_display']/following-sibling::img")).click();
		Set<String> set = driver.getWindowHandles();
		Iterator <String> it = set.iterator();
		while(it.hasNext()) {
			String windowID =it.next();
			driver.switchTo().window(windowID);
			String acturl = driver.getCurrentUrl();
			if(acturl.contains("module=Accounts")) {
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		Set<String>set1= driver.getWindowHandles();
		Iterator <String> it1 = set.iterator();
		while(it1.hasNext()) {
			String windowID =it1.next();
			driver.switchTo().window(windowID);
			String acturl = driver.getCurrentUrl();
			if(acturl.contains("module=Potentials")) {
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actpotentialname = driver.findElement(By.id("dtlview_Opportunity Name")).getText();
		if(actpotentialname.equals(potentialname)) {
			System.out.println(potentialname+ " information is verified ==PASS");
		}
		else {
			System.out.println(potentialname+ " information is not verified ==FAIL");
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
		hp.getOpportunitiesLink().click();
		
		OpportunitiesPage otp = new OpportunitiesPage(driver);
		otp.getNewOpptuBtn().click();
		CreatingNewOppPage cno= new CreatingNewOppPage(driver);
		cno.getOpportunitytext().sendKeys(potentialname);
		cno.getOrgAddBtn().click();
		wlib.switchToTabonURL(driver, "module=Accounts");   
		cno.selectOrg(orgName);
		wlib.switchToTabonURL(driver, "Contacts&action");
		cno.getSaveBtn().click();
		String actOppNme=cno.getActOppotu().getText();
		if(actOppNme.equals(potentialname)) {
			System.out.println(potentialname+ " information is verified ==PASS");
		}
		else {
			System.out.println(potentialname+ " information is not verified ==FAIL");
		}
		driver.quit();
 
	}


	}


