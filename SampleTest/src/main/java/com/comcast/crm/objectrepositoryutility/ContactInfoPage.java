package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	WebDriver driver;
	public ContactInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="dtlview_Last Name")
	private WebElement actLastname;
	@FindBy(id="dtlview_Support Start Date")
	private WebElement actStart;
	@FindBy(id="dtlview_Support End Date")
	private WebElement actEnd;
	@FindBy(id="mouseArea_Organization Name")
	private WebElement actorg;
	
	public WebElement getActorg() {
		return actorg;
	}
	public WebElement getActLastname() {
		return actLastname;
	}
	public WebElement getActStart() {
		return actStart;
	}
	public WebElement getActEnd() {
		return actEnd;
	}
	
}
