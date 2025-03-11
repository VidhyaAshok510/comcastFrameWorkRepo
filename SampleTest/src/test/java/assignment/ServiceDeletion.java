package assignment;

import java.time.Duration;

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
import com.comcast.crm.objectrepositoryutility.ServicePage;

public class ServiceDeletion {

	public static void main(String[] args) throws Throwable {
		
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		ExcelUtility elib = new ExcelUtility();
		
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		
		 String service= elib.getDataFromExcel("Assign", 13, 2)+ jlib.GetRandomNum();
	     String option= elib.getDataFromExcel("Assign", 13, 3);
		
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
			driver.manage().window().maximize();
			
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(URL,USERNAME, PASSWORD);
			HomePage hp = new HomePage(driver);
			wlib.moveToElement(driver, hp.getMoreLink());
			hp.getServiceLink().click();
			ServicePage sp = new ServicePage(driver);
			sp.getCreateNewBtn().click();
			sp.newservice(service);
			String headerInfo=sp.getHeaderText().getText();
			if(headerInfo.contains(service)) {
				System.out.println(service+ " information is verified ==PASS");
			}
			else {
				System.out.println(service+ " information is not verified ==FAIL");
			}
			
			hp.getServiceLink().click();
			sp.servicesearch(service, option);
			driver.findElement(By.xpath("//a[text()='"+service+"']/../..//td[9]//a[text()='del']")).click();
			driver.switchTo().alert().accept();
			hp.logout();
	}
	

}
