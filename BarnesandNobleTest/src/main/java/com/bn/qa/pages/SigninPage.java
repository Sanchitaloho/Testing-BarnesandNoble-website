package com.bn.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bn.qa.base.TestBase;
import com.bn.qa.utils.TestUtil;

public class SigninPage extends TestBase{

	//Page Factory - OR:
	@FindBy(id="signInLink")
	WebElement signInLink;
	
	@FindBy(xpath="*[@id='dialog-title']")
	WebElement dialogtitle;
	
		@FindBy(id="email")
		WebElement email;
		
		@FindBy(id="password")
		WebElement password;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement signinBtn;
		
		@FindBy(xpath="//span[@class='checkbox__box']")
		WebElement remembermecheck;
		
		
		@FindBy(xpath="//a[contains(text(),'Create an account')]")
		WebElement createaccount;
		
		@FindBy(xpath="//a[@id='loginForgotPassword']")
		WebElement forgotpassword;
		
		
		@FindBy(xpath="//img[contains(@class,'img-responsive')]")
		WebElement Logo;
		
		//Initializing the Page Objects:
		public SigninPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validatePageTitle(){
			return driver.getTitle();
		}
		
		public String validateSigninPopupTitle(){
			signInLink.click();
		//	driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Fill Quote']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//*[contains(@id,'frame')]")));
			
			return dialogtitle.getText();
		}
		
		public boolean validateforgotpasslink(){
			signInLink.click();
			TestUtil.switchToFrame();
			return forgotpassword.isDisplayed();
		}
		
		public HomePage login(String un, String pwd){
			
			
			signInLink.click();
			
			TestUtil.switchToFrame();
			email.sendKeys(un);
			password.sendKeys(pwd);
			//loginBtn.click();
			    	JavascriptExecutor js = (JavascriptExecutor)driver;
			    	js.executeScript("arguments[0].click();", signinBtn);
			    	
			return new HomePage();
		}
		
	}
