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
	
	@FindBy(xpath="//*[@id='dialog-title']")
	WebElement dialogtitle;
	
		
		@FindBy(xpath="//*[contains(@id,'email')]")
		WebElement email;
		
		@FindBy(xpath="//*[@id='password']")
		WebElement password;
		
		@FindBy(xpath="//span[contains(text(),'Remember me') or @class='checkbox__box']")
		WebElement remembermecheck;
		
		@FindBy(xpath="//*[@type='submit'][contains(text(),'Sign In')]")
		WebElement signinBtn;
		
		
		
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
			driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Sign in or Create an Account']")));
			
			//driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			
			return dialogtitle.getText();
		}
		
		public boolean validateforgotpasslink(){
			signInLink.click();
			TestUtil.switchToFrame();
			return forgotpassword.isDisplayed();
		}
		
		public boolean validatecheckbox(){
			signInLink.click();
			TestUtil.switchToFrame();
			return remembermecheck.isSelected();
		}
		public HomePage login(String un, String pwd){
			
			signInLink.click();
			TestUtil.switchToFrame();
								
			email.sendKeys(un);
			password.sendKeys(pwd);
			remembermecheck.click();
			//loginBtn.click();
			    	JavascriptExecutor js = (JavascriptExecutor)driver;
			    	js.executeScript("arguments[0].click();", signinBtn);
			    	
			return new HomePage();
		}
		
	}
