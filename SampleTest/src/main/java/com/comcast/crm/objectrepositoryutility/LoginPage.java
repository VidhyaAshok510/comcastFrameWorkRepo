package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="user_name")
	private WebElement usertext;
	@FindBy(name="user_password")
	private WebElement pwdtext;
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	public WebElement getUsertext() {
		return usertext;
	}
	public WebElement getPwdtext() {
		return pwdtext;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	public void loginToApp(String url,String username,String password) {
		driver.manage().window().maximize();
		waitForPageToLOad(driver);
		driver.get(url);
		usertext.sendKeys(username);
		pwdtext.sendKeys(password);
		loginbtn.click();
	}
}
