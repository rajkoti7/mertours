package com.mercury.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercury.qa.base.TestBase;

public class HomePage extends TestBase {

	
	@FindBy(xpath="//img[@src='/images/masts/mast_flightfinder.gif']")
	WebElement homelogo;
	
	@FindBy(xpath="//a[text()='PROFILE']")
	WebElement profilelink;
	
	@FindBy(xpath="//input[@name='findFlights']")
	WebElement continuebtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String  validateHomepageTitle() {
		return driver.getTitle();
	}
	public boolean validateHomeLogo() {
		return homelogo.isDisplayed();	
	}
	public boolean validateContinueButton() {
		return continuebtn.isDisplayed();
	}
	public ProfilePage validateProfilePageLink() {
		profilelink.click();
		return new ProfilePage();
				
	}
}
