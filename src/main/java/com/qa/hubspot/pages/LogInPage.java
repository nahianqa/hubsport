package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.constrant.Constant;
import com.qa.hubspot.util.ElementUtil;

public class LogInPage extends BasePage {
	WebDriver driver;
	ElementUtil elementutil;

	By emailId = By.cssSelector("#username");
	By password = By.cssSelector("input.login-password");
	By signuplink = By.xpath("//i18n-string [text()='Sign up']");
	By loginbutton = By.xpath("//button[@id = 'loginBtn']");

	public LogInPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(driver);
	}

	public String getTitle() {
		elementutil.waitForPageTitle(Constant.LOGIN_PAGE_TITLE);
		return  elementutil.doGetTitle();
	}

	public boolean existSignupLink() {
		return elementutil.doisDesplayed(signuplink);
	}

	public HomePage doLogin(String email, String Paswrd) {

		elementutil.dosendKeys(emailId, email);
		elementutil.dosendKeys(password, Paswrd);
		elementutil.doClick(loginbutton);
		elementutil.doGetTitle()	;	

		return new HomePage(driver);
	}
}
