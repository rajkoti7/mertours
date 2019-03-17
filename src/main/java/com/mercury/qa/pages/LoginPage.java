package com.mercury.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercury.qa.base.TestBase;

public class LoginPage extends TestBase {

	//PageFactory
	@FindBy(name="userName")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="login")
	WebElement loginbtn;
	
	@FindBy(xpath="//img[@alt='Mercury Tours']")
	WebElement mercurytoursLogo;
	
	@FindBy(xpath="//a[text()='PROFILE']")
	WebElement profileLink;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public String validateLoginTitle() {
		return driver.getTitle();
	}
	
	public boolean validateTitleLogo() {
		return mercurytoursLogo.isDisplayed();
	}
	public HomePage validateLogin(String un, String pass) {
		username.sendKeys(un);
		password.sendKeys(pass);
		loginbtn.click();
		return new HomePage();
	}
	
}
