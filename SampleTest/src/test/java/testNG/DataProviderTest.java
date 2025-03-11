package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider = "getData")
	public void createContactTest(String firstname, String lastname, long mno) {
		System.out.println("Firstname:"+firstname+"  Lastname :"+ lastname +" Mobile no:"+ mno);
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] objArray= new Object[3][3];
		objArray[0][0]="Vidhya";
		objArray[0][1]="Ashok";
		objArray[0][2]=9988776655l;
		
		objArray[1][0]="Rudra";
		objArray[1][1]="Samson";
		objArray[1][2]=7888776655l;
		
		objArray[2][0]="Athira";
		objArray[2][1]="M";
		objArray[2][2]=7890776655l;
		
		return objArray; 
	}

}
