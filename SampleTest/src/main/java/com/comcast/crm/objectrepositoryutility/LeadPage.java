package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {
	WebDriver driver;
	public LeadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@title='Create Lead...']")
	private WebElement addleadBtn;
	@FindBy(name="lastname")
	private WebElement lastnametext;
	@FindBy(name="company")
	private WebElement companytext;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(className="dvHeaderText")
	private WebElement headerText;
	public WebElement getHeaderText() {
		return headerText;
	}
	public WebElement getAddleadBtn() {
		return addleadBtn;
	}
	public WebElement getLastnametext() {
		return lastnametext;
	}
	public WebElement getCompanytext() {
		return companytext;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void lead(String lastname, String company) {
		lastnametext.sendKeys(lastname);
		companytext.sendKeys(company);
		saveBtn.click();
		
		
	}
	
}
