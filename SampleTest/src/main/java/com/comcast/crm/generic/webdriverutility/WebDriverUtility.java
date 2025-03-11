package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForPageToLOad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitforElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	
	public void switchToTabonURL(WebDriver driver, String partialUrl) {
		Set<String> set = driver.getWindowHandles();
		Iterator <String> it = set.iterator();
		while(it.hasNext()) {
			String windowID =it.next();
			driver.switchTo().window(windowID);
			String acturl = driver.getCurrentUrl();
			if(acturl.contains(partialUrl)) {
				break;
			}
		}
	}
			public void switchToTabonTitle(WebDriver driver, String partialTitle) {
				Set<String> set = driver.getWindowHandles();
				Iterator <String> it = set.iterator();
				while(it.hasNext()) {
					String windowID =it.next();
					driver.switchTo().window(windowID);
					String actTitle = driver.getTitle();
					if(actTitle.contains(partialTitle)) {
						break;
					}
				}
			}
			public void moveToElement(WebDriver driver, WebElement element) {
				Actions act = new Actions(driver);
				act.moveToElement(element).perform();
			}
			public void doubleClick(WebDriver driver, WebElement element) {
				Actions act = new Actions(driver);
				act.moveToElement(element).perform();
			}
			public void switchToFrame(WebDriver driver,int index) {
				driver.switchTo().frame(index);
			}
}
	

