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

public class Calender {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream ("C:\\Users\\ASH\\Desktop\\commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		
	
		FileInputStream fis1 = new FileInputStream("./src/test/resources/excelsheet/testdatafile.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh= wb.getSheet("assign");
		Row row =sh.getRow(4);
		String event = row.getCell(2).toString()+ randomInt;
		
		
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
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Calendar")).click();
		driver.findElement(By.xpath("//img[@src='themes/images/cal_add.gif']")).click();
		driver.findElement(By.name("subject")).sendKeys(event);

	}

}
