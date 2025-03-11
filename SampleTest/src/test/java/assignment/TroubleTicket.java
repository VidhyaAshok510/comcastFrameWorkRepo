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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.TroubleTicketPage;

public class TroubleTicket {

	public static void main(String[] args) throws Throwable {
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		ExcelUtility elib = new ExcelUtility();
		
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		
		String ticket=elib.getDataFromExcel("assign", 1, 2)+jlib.GetRandomNum();
		String option=elib.getDataFromExcel("assign", 1, 3);
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
		
	/*	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Trouble Tickets")).click();
		driver.findElement(By.xpath("//img[@alt='Create Ticket...']")).click();
		driver.findElement(By.name("ticket_title")).sendKeys(ticket);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String ticketTitle = driver.findElement(By.id("dtlview_Title")).getText();
		if(ticketTitle.equals(ticket)) {
			System.out.println(ticket+ " information is verified ==PASS");
		}
		else {
			System.out.println(ticket+ " information is not verified ==FAIL");
		}
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();	*/
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL,USERNAME, PASSWORD);
		HomePage hp = new HomePage(driver);
		hp.getTicketLink().click();
		TroubleTicketPage tp = new TroubleTicketPage(driver);
		tp.getCreateNewBtn().click();
		tp.ticketCreation(ticket,option);
		tp.getSaveBtn().click();
		
		String ActHeader=tp.getActTitle().getText();
		if(ActHeader.contains(ticket)) {
			System.out.println(ticket+ " information is verified ==PASS");
		}
		else {
			System.out.println(ticket+ " information is not verified ==FAIL");
		}
		hp.logout();
 
		
	}
}
