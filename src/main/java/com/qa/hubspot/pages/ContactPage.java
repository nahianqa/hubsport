package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.constrant.Constant;
import com.qa.hubspot.util.ElementUtil;

public class ContactPage extends BasePage {
	
	
	WebDriver driver;
	ElementUtil elementUtil;

	By createContactButton = By.xpath("//span[text()='Create contact']");
	By createContactFormButton = By.xpath("//li//span[text()='Create contact']");

	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");

	public ContactPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getContactsPageTitle() {
		elementUtil.waitForPageTitle(Constant.CONTACTS_PAGE_TITLE);
		return elementUtil.doGetTitle();
	}

	public void createNewContact(String mail, String FN, String LN, String jobtitle) {

		elementUtil.doClick(createContactButton);
		elementUtil.doActionsSendKeys(email, mail);
		elementUtil.doActionsSendKeys(firstName, FN);
		elementUtil.doActionsSendKeys(lastName, LN);
		elementUtil.doActionsSendKeys(jobTitle, jobtitle);
		
		elementUtil.doClick(createContactFormButton);
		//elementUtil.doClick(createContactFormButton);

	}
	
	
	

}
