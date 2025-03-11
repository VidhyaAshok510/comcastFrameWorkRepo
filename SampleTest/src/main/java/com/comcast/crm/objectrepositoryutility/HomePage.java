package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("Home Pag");
		System.out.println("Login page loaded");
	}
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLink;
	@FindBy(linkText="Trouble Tickets")
	private WebElement ticketLink;
	@FindBy(linkText="Leads")
	private WebElement leadLink;
	@FindBy(linkText="Services")
	private WebElement serviceLink;
	@FindBy(linkText="Products")
	private WebElement productLink;
	@FindBy(linkText="Options")
	private WebElement optionLink;

	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreLink ;
	
	
	
	public WebElement getMoreLink() {
		return moreLink;
	}
	public WebElement getServiceLink() {
		return serviceLink;
	}
	public WebElement getTicketLink() {
		return ticketLink;
	}
	public WebElement getLeadLink() {
		return leadLink;
	}
	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement sign;
	@FindBy(linkText="Sign Out")
	private WebElement logoutbtn;
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getContactLink() {
		return contactLink;
	}
	public WebElement getSign() {
		return sign;
	}
	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	public void logout() {
		Actions action =new Actions(driver);
		action.moveToElement(sign).perform();
		action.click(logoutbtn).perform();
	}

}
