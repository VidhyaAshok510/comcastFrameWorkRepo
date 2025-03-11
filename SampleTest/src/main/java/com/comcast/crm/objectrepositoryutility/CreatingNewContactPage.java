package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="lastname")
	private WebElement lastnametext;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButtn;
	@FindBy(name="support_start_date")
	private WebElement starttext;
	
	@FindBy(name="support_end_date")
	private WebElement endtext;
	@FindBy(xpath="//input[@name='account_name']/..//img")
	private WebElement orgAddBtn;
	
	public WebElement getOrgAddBtn() {
		return orgAddBtn;
	}

	public WebElement getLastnametext() {
		return lastnametext;
	}

	public WebElement getSaveButtn() {
		return saveButtn;
	}

	public WebElement getStarttext() {
		return starttext;
	}

	public WebElement getEndtext() {
		return endtext;
	}
	
	public void newContact(String lastName, String startDate, String endDate) {
		lastnametext.sendKeys(lastName);
		starttext.clear();
		starttext.sendKeys(startDate);
		endtext.clear();
		endtext.sendKeys(endDate);
		saveButtn.click();
	}
	public void newLastnameContact(String lastName) {
		lastnametext.sendKeys(lastName);
		saveButtn.click();
	}
}
