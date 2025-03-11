package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TroubleTicketPage {
	WebDriver driver;
	public TroubleTicketPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="//img[@title='Create Ticket...']")
		private WebElement createNewBtn;
		@FindBy(name="ticket_title")
		private WebElement titletext;
		@FindBy(name="ticketstatus")
		private WebElement ticketDd;
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		@FindBy(className="dvHeaderText")
		private WebElement actTitle;
		
		public WebElement getCreateNewBtn() {
			return createNewBtn;
		}
		public WebElement getTitletext() {
			return titletext;
		}
		public WebElement getTicketDd() {
			return ticketDd;
		}
		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		public WebElement getActTitle() {
			return actTitle;
		}
		public void ticketCreation(String title,String option) throws Throwable {
			titletext.sendKeys(title);
			Select selobj = new Select(ticketDd);
			selobj.selectByVisibleText(option);
			//Thread.sleep(2000);
			//saveBtn.click();
			
		}
		
		
}
