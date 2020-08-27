package com.qa.hubspot.test;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.constrant.Constant;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LogInPage;

public class LoginPageTest {
	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LogInPage loginpage;
	HomePage homePage;
	
	@BeforeClass
	public void setUp() {
	basepage = new BasePage();
	prop = basepage.init_properties();
	driver=basepage.init_driver(prop);
	loginpage = new LogInPage(driver);

	}
	

	@Test(priority = 1, enabled = true)
	public void verifyloginPagetitle() {
		Reporter.log("Report Started s " + "verifyloginPagetitle");
		String title =loginpage.getTitle();
		System.out.println("loginpage title is " + title);
		Reporter.log("loginpage title is " + title);
		Assert.assertEquals(title, Constant.LOGIN_PAGE_TITLE);
		Reporter.log("Report ends  " + "verifyloginPagetitle");

	}
	@Parameters({ "browser" })
	@Test(priority = 2)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginpage.existSignupLink());
	}
	
	
	@Test(priority = 3)
	@Parameters({ "emailId", "password" })
	public void verifyLoginTest() {
		homePage= loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		 homePage.getLoggedAccountName();
		
	}
	
	@Test(priority = 4)
	//@Parameters({ "emailId", "password" })
	public void gittest() {
		System.out.println("GIT works with branch conept ");
		
	}
	
	@Test(priority = 5)
	//@Parameters({ "emailId", "password" })
	public void gittest2() {
		System.out.println("GITBranch concept");
		System.out.println("GIT branch concept fin e22 ");
		System.out.println("GIT push from deo team ");
		
		System.out.println("I lov bangladesh ");

	}
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	
	
	
}
