package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOppPage {
	WebDriver driver;
	public CreatingNewOppPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="potentialname")
	private WebElement opportunitytext;
	@FindBy(xpath="//input[@name='related_to_display']/..//img")
	private WebElement orgAddBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(id="search_txt")
	private WebElement childorgsearchtext;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement childsearchBtn;
	@FindBy(id="1")
	private WebElement orgOption;
	@FindBy(id="dtlview_Opportunity Name")
	private WebElement actOppotu;
	
	
	public WebElement getActOppotu() {
		return actOppotu;
	}



	public WebElement getChildorgsearchtext() {
		return childorgsearchtext;
	}

	

	public WebElement getChildsearchBtn() {
		return childsearchBtn;
	}

	public WebElement getOrgOption() {
		return orgOption;
	}

	public void selectOrg(String orgName) throws InterruptedException {
		childorgsearchtext.sendKeys(orgName);
		Thread.sleep(2000);
		childsearchBtn.click();
		Thread.sleep(2000);
		orgOption.click();
		
		
	}
	public WebElement getOpportunitytext() {
		return opportunitytext;
	}

	public WebElement getOrgAddBtn() {
		return orgAddBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
}
