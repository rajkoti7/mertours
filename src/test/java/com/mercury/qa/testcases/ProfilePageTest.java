package com.mercury.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mercury.qa.base.TestBase;
import com.mercury.qa.pages.HomePage;
import com.mercury.qa.pages.LoginPage;
import com.mercury.qa.pages.ProfilePage;
import com.mercury.qa.util.TestUtil;

public class ProfilePageTest extends TestBase {
	ProfilePage profilepage;
	LoginPage loginpage;
	HomePage homepage;
	String sheetname="Sheet1";
	
	public ProfilePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));
		profilepage= new ProfilePage();
		profilepage=homepage.validateProfilePageLink();
		
	}
	@Test(priority=1)
	public void validateEditImageTest() {
		boolean flag=profilepage.validateEditImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=1)
	public void validateSubmitBtnTest() {
		boolean flag =profilepage.validateSubmitBtn();
		Assert.assertTrue(flag);
	}
	@DataProvider
	public Object[][] getMercuryTestData() {
		Object[][] data= TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=2,dataProvider="getMercuryTestData")
	public void fillingFormTest(String firstname,String city, String country) {
		profilepage.fillingForm(firstname, city, country);	
	
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
