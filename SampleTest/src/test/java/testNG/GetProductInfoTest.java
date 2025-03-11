package testNG;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;


public class GetProductInfoTest {
	@Test(dataProvider = "getData")
	public void getProductPriceTest(String brandName, String productName) {
		WebDriver driver = new ChromeDriver();
		WebDriverUtility wlib= new WebDriverUtility();
		wlib.waitForPageToLOad(driver);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName);
		driver.findElement(By.id("nav-search-submit-button")).click();	
		String x= "//span[text()='"+productName+"']/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		String price=driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		driver.quit();
	}
	
	/*@DataProvider
	public Object[][] getData(){
		Object[][] objArray = new Object[2][2];
		objArray[0][0]="tv";
		objArray[0][1]="Redmi Xiaomi 138 cm (55 inch) F Series UHD 4K Smart LED Fire TV L55MA-FVIN (Black)";
		objArray[1][0]="tv";
		objArray[1][1]="acer 109 cm (43 inches) I Pro Series 4K Ultra HD LED Smart Google TV AR43UDIGU2875AT (Black)";
				return objArray;
		
	}*/
	@DataProvider
	public Object[][] getData() throws Throwable{
		ExcelUtility eLib = new ExcelUtility();
		
         int rowCount=	eLib.getRowCount("product");
         Object[][] objArray = new Object[rowCount][2];
         for(int i = 0;i<rowCount;i++) {
        	 objArray[i][0]=eLib.getDataFromExcel("product", i+1, 0);
     		objArray[i][1]=eLib.getDataFromExcel("product", i+1, 1);
     		
         }
		return objArray;
	}

}
