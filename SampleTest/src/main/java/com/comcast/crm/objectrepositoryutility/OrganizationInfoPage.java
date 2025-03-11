package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		//@FindBy(className="dvHeaderText")
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement headerMssg;
		
		@FindBy(id="dtlview_Organization Name")
		private WebElement actorgfield;
		@FindBy(id="dtlview_Industry")
		private WebElement actindustry;
		@FindBy(id="dtlview_Type")
		private WebElement acttype;
		@FindBy(id="dtlview_Phone")
		private WebElement actphn;
		
		public WebElement getActphn() {
			return actphn;
		}

		public WebElement getActindustry() {
			return actindustry;
		}

		public WebElement getActtype() {
			return acttype;
		}

		public WebElement getHeaderMssg() {
			return headerMssg;
		}

		public WebElement getActorgfield() {
			return actorgfield;
		}
		
		
	}


