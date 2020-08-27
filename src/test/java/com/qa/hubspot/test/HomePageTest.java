package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.constrant.Constant;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LogInPage;

public class HomePageTest {
	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LogInPage loginpage;
	HomePage homePage;
	SoftAssert softAssert;

	
	@BeforeTest
	public void setUp() {
	basepage = new BasePage();
	prop = basepage.init_properties();
	driver=basepage.init_driver(prop);
	loginpage = new LogInPage(driver);
	homePage =loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	softAssert = new SoftAssert();
	}

	
	
	@Test(priority = 1 )
	public void verifyHomePageHeaderValueTest() {
		softAssert.assertTrue(homePage.verifyHomePageHeader());
		boolean headerValue = homePage.verifyHomePageHeader();
		System.out.println("home page header is: " + headerValue);
		Assert.assertEquals(headerValue, Constant.HOME_PAGE_HEADER, "home page header mismatched...");
		System.out.println("end of the test.......");
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void verifyLoggedInUserTest(){
		softAssert.assertTrue(homePage.verifyLoggedAccountName());
		String accountName = homePage.getLoggedAccountName();
		System.out.println("account Name is: " + accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
		softAssert.assertAll();
		System.out.println("Nahian Compile ");
	}

	@Test(priority = 3)
	public void verifyHomePageAppLogo() {
		Assert.assertTrue(homePage.verifyApplicatioLogo(), "application logo is not present...");
	}

	@Test(priority = 4)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomeTitle();
		System.out.println("home page title is: " + title);
		Assert.assertEquals(title, Constant.HOME_PAGE_TITLE);
		System.out.println("GIT works fin e ");

	}

//	@AfterTest
//	public void quitBrowser() {
//		driver.quit();
//	}
}
