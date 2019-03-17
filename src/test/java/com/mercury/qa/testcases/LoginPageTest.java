package com.mercury.qa.testcases;

import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mercury.qa.base.TestBase;
import com.mercury.qa.pages.HomePage;
import com.mercury.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	//static WebDriver driver;
	Logger log = Logger.getLogger(LoginPageTest.class);
	public LoginPageTest() {
		super();
		
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		 loginpage=new LoginPage();
		 homepage=new HomePage();
	}
	@Test(priority=1)
	public void validateLoginTitleTest() {
		String title= loginpage.validateLoginTitle();
		Assert.assertEquals(title, "Welcome: Mercury Tours");
		
	}
	@Test(priority=2)
	public void validateTitleLogoTest() {
		boolean flag=loginpage.validateTitleLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=1)
	public void validateLoginTest() {
	homepage=loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void teardown() {
	driver.quit();
	
}
}
