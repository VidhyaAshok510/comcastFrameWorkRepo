package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(name="accountname")
		private WebElement orgtext;
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		@FindBy(name="industry")
		private WebElement industryDd;
		@FindBy(name="accounttype")
		private WebElement typeDd;
		@FindBy(name="phone")
		private WebElement phntext;
		
	
		public WebElement getTypeDd() {
			return typeDd;
		}
		public WebElement getOrgtext() {
			return orgtext;
		}
		public WebElement getPhntext() {
			return phntext;
		}
		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		public WebElement getIndustryDd() {
			return industryDd;
		}
		public void newOrg(String orgName) {
			orgtext.sendKeys(orgName);
			saveBtn.click();
		}
		
			public void newOrg(String orgName, String industry) {
				orgtext.sendKeys(orgName);
				Select selobj = new Select(industryDd);
				selobj.selectByContainsVisibleText(industry);
				saveBtn.click();
			}
				public void newOrg(String orgName, String industry, String type) {
					orgtext.sendKeys(orgName);
					Select selobj = new Select(industryDd);
					selobj.selectByContainsVisibleText(industry);
					Select selobj1 = new Select(typeDd);
					selobj1.selectByVisibleText(type);
					saveBtn.click();
			
		
	}
				

}
