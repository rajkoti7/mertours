package com.mercury.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mercury.qa.base.TestBase;
import com.mercury.qa.pages.HomePage;
import com.mercury.qa.pages.LoginPage;
import com.mercury.qa.pages.ProfilePage;

public class HomePageTest extends TestBase{
HomePage homepage;
ProfilePage profilepage;
LoginPage loginpage;
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homepage= new HomePage();
		profilepage= new ProfilePage();	
		loginpage=new LoginPage();
		homepage=loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test(priority=1)
	public void validateHomepageTitleTest() {
		String title=homepage.validateHomepageTitle();
		Assert.assertEquals(title, "Sign-on: Mercury Tours");
	}
	@Test(priority=2)
	public void validateHomeLogoTest() {
		boolean flag= homepage.validateHomeLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=1)
	public void validateContinueButtonTest() {
		boolean flag=homepage.validateContinueButton();
		Assert.assertTrue(flag);
	}
	@Test(priority=2)
	public void validateProfilePageLinkTest() {
		profilepage=homepage.validateProfilePageLink();
	}
	@AfterMethod
	public void teardown() {
	driver.quit();
	}
}
