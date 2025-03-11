package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationPage {
	WebDriver driver;
	public OrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement createNewBtn;
		@FindBy(name="search_text")
		private WebElement searchText;
		@FindBy(id="bas_searchfield")
		private WebElement inDrop;
		@FindBy(xpath="//input[@value=' Search Now ']")
		private WebElement searchNowBtn;
		/*driver.findElement(By.xpath("//a[text()='"+orgName+"]/../../td[8]/a[text()='del']"));
		private WebElement deltBtn;*/
		  
	
		/*public WebElement getDeltBtn() {
			return deltBtn
		}*/
		public WebElement getInDrop() {
			return inDrop;
		}
		public WebElement getSearchNowBtn() {
			return searchNowBtn;
		}
		public WebElement getCreateNewBtn() {
			return createNewBtn;
		}
		public WebElement getSearchText() {
			return searchText;
		}
		public void selection(String orgName,String cateogory) {
			searchText.sendKeys(orgName);
			Select selobj = new Select(inDrop);
			selobj.selectByVisibleText(cateogory);
			searchNowBtn.click();
			
		}
}	
		
		
		
		
		
	
	


