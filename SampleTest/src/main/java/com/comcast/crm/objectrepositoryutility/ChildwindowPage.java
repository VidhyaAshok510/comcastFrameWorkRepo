package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ChildwindowPage {
	WebDriver driver;
	public ChildwindowPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="search_txt")
	private WebElement childorgsearchtext;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement childsearchBtn;
	@FindBy(id="1")
	private WebElement orgOption;
	
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
}
