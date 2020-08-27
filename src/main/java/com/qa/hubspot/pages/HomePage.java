package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.util.ElementUtil;

public class HomePage extends BasePage {
	WebDriver driver;
ElementUtil elementutil;
	By header =  By.cssSelector("h1.private-page__title");
	By accountname = By.cssSelector("span.account-name ");
	By logo = By.cssSelector("li>a#nav-primary-home");

	By contactsParentTab = By.id("nav-primary-contacts-branch");
	By contactsChildTab = By.id("nav-secondary-contacts");
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementutil = new ElementUtil(driver);
		//elementutil.waitForElementPresent(header);
	}

	public String getHomeTitle() {
		return elementutil.doGetTitle();
	}
	
	public boolean verifyHomePageHeader() {
		//elementutil.waitForElementPresent(header);

		return elementutil.doisDesplayed(header);
	}
	public boolean verifyLoggedAccountName() {
		//elementutil.waitForElementPresent(accountname);

		return elementutil.doisDesplayed(accountname);
	}
	
	public boolean verifyApplicatioLogo(){
		//return driver.findElement(logo).isDisplayed();
		return elementutil.doisDesplayed(logo);
		
	}
	public String getHomaPageHeader() {
		//elementutil.waitForElementPresent(header);

		return elementutil.doGettext(header);
	}
	public String getLoggedAccountName() {
		//elementutil.waitForElementPresent(accountname);

		return elementutil.doGettext(accountname);
	}
	
	public ContactPage goToContactsPage() {
		elementutil.waitForElementPresent(contactsParentTab);
		elementutil.doClick(contactsParentTab);
		elementutil.waitForElementPresent(contactsChildTab);
		elementutil.doClick(contactsChildTab);

		return new ContactPage(driver);
	}
}
