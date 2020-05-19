package com.bn.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bn.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath = "//td[contains(text(),'Hello,')]")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement searchLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public SearchBook clickOnsearch(){
		searchLink.click();
		return new SearchBook();
	}
	
	public WishlistPage clickOnwishlistsLink(){
		dealsLink.click();
		return new WishlistPage();
	}
	
	public MyAccount clickOnManageaccountsLink(){
		tasksLink.click();
		return new MyAccount();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
	//	action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
	
}
