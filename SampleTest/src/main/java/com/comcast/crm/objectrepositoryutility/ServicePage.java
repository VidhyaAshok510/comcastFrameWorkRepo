package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ServicePage {
	WebDriver driver;
	public ServicePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="//img[@title='Create Service...']")
		private WebElement createNewBtn;
		@FindBy(name="servicename")
		private WebElement servicetext;
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		@FindBy(className="lvtHeaderText")
		private WebElement headerText ;
		@FindBy(name="search_text")
		private WebElement searchText ;
		@FindBy(name="search_field")
		private WebElement searchField ;
		@FindBy(name="submit")
		private WebElement searchBtn ;
		
		public WebElement getCreateNewBtn() {
			return createNewBtn;
		}
		public WebElement getServicetext() {
			return servicetext;
		}
		public WebElement getSaveBtn() {
			return saveBtn;
		}
		public WebElement getHeaderText() {
			return headerText;
		}
		public WebElement getSearchText() {
			return searchText;
		}
		public WebElement getSearchField() {
			return searchField;
		}
		public WebElement getSearchBtn() {
			return searchBtn;
		}
		public void newservice(String service) {
			servicetext.sendKeys(service);
			saveBtn.click();
		}
		
		public void servicesearch(String service,String option) {
			searchText.sendKeys(service);
			Select selobj = new Select(searchField);
			selobj.selectByVisibleText(option);
			searchBtn.click();
		}
		
		
		
}
