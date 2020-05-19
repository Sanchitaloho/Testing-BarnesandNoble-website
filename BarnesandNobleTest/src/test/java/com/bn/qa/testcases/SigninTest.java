package com.bn.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bn.qa.base.TestBase;
import com.bn.qa.pages.HomePage;
import com.bn.qa.pages.SigninPage;

public class SigninTest extends TestBase {

	SigninPage signinPage;
	HomePage homePage;
	
	public SigninTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		signinPage = new SigninPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = signinPage.validatePageTitle();
		Assert.assertEquals(title, "Online Bookstore: Books, NOOK ebooks, Music, Movies & Toys | Barnes & Noble®");
	}
	//@Test(priority=2)
	public void validateSigninPopupTitle(){
		String titlepop = signinPage.validateSigninPopupTitle();
		System.err.println("The title of popup is : " + titlepop);
	}
	
	//@Test(priority=3)
	public void forgotpasslinkTest(){
		boolean flag = signinPage.validateforgotpasslink();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=4)
	public void loginTest(){
		homePage = signinPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
