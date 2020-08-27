package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	WebDriver driver;
	WebDriverWait wait;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);

	}

	public WebElement getElement(By locator) {
		waitForElementPresent(locator);
		WebElement element = null;// Initially it will Null
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("some exception got occoured while create the webelement" + locator);
			System.out.println(e.getMessage());
		}
		return element;
	}

	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception got occoured while click the webelement" + locator);
			System.out.println(e.getMessage());
		}
	}
	public void doActionclick(By locator, String...value) {
		try {
Actions action = new Actions(driver);	
action.sendKeys(getElement(locator),value).build().perform();
}
		catch (Exception e) {
			System.out.println("some exception got occoured while click the webelement" + locator);
			System.out.println(e.getMessage());
		}
	}
	
	public void doActionMovetoElement(By locator) {
		try {
Actions action = new Actions(driver);	
action.moveToElement(getElement(locator)).build().perform();
}
		catch (Exception e) {
			System.out.println("some exception got occoured while click the webelement" + locator);
			System.out.println(e.getMessage());
		}
	}
	public void doActionsSendKeys(By locator, String... value) {
		try {
			Actions action = new Actions(driver);
			action.sendKeys(getElement(locator), value).build().perform();
		} catch (Exception e) {
			System.out.println("some exception got occurred while passing the values to the webelement : " + locator);
			System.out.println(e.getMessage());
		}
	}
	
	public void dosendKeys(By locator, String value) {
		try {
			getElement(locator).clear();
			getElement(locator).sendKeys(value);

		} catch (Exception e) {
			System.out.println("some exception got occoured while sendin the text" + locator);
			System.out.println(e.getMessage());
		}
	}
	
	public String doGettext(By locator) {
		String text = null;
		try {
			text= getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("some exception got occoured while get text the webelement" + locator);
			System.out.println(e.getMessage());
		}
		return text;
	}
	
	public boolean doisDesplayed(By locator) {
		boolean flag = false;// By default it will be fasle
		try {
			flag= getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("some exception got occoured while  displaying  the webelement" + locator);
			System.out.println(e.getMessage());
		}
		return flag;
	}
	
	// We do not need locator for get title 
	public String doGetTitle() {
		String title = null;
		try {
			title= driver.getTitle();
		} catch (Exception e) {
			System.out.println("some exception got occoured while get title of the page");
			System.out.println(e.getMessage());
		}
		return title;
	
	}	
	
	
	
	public void waitForPageUrl(String url) {
		wait.until(ExpectedConditions.urlToBe(url));
	}

	public void waitForPageTitle(String title) {
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void waitForElementPresent(By locator){
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
