package com.qa.hubspot.test;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.constrant.Constant;
import com.qa.hubspot.pages.ContactPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LogInPage;
import com.qa.hubspot.util.ExcelUtil;

public class ContactPageTest {
	
	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LogInPage loginpage;
	HomePage homePage;
	SoftAssert softAssert;
	ContactPage contactsPage;

	@BeforeMethod
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.init_properties();
		driver = basepage.init_driver(prop);
		loginpage = new LogInPage(driver);
		homePage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToContactsPage();
	}

	@Test 
	public void verifyContactsPageTitleTest() {
		String title = contactsPage.getContactsPageTitle();
		System.out.println("contacts page title is : " + title);
		Assert.assertEquals(title, Constant.CONTACTS_PAGE_TITLE);
	}

	@DataProvider
	public Object[][] getContactsTestData() {
		Object data[][] = ExcelUtil.getTestData(Constant.CONTACTS_SHEET_NAME.trim());
		return data;
	}

	@Test(dataProvider ="getContactsTestData")
	//
	public void createNewContactTest(String email, String firstName, String lastName, String jobTitle) {
		// contactsPage.createNewContact("nav@gmail.com", "naveen", "K", "QA");
		contactsPage.createNewContact(email, firstName, lastName, jobTitle);

	}
	
	public void gittesnnt2() {
		System.out.println("GITBranch concept");
		System.out.println("GIT branch concept fin e22 ");
		System.out.println("GIT works fin ejjj ");

	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}
	
	
	
	
	
	
	

}
