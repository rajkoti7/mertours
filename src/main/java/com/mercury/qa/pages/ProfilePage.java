package com.mercury.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mercury.qa.base.TestBase;

public class ProfilePage extends TestBase {
	
	@FindBy(xpath="//img[@src='/images/masts/mast_editprofile.gif']")
	WebElement editimage;
	
	@FindBy(xpath="//img[@src='images/profile_submit.gif']")
	WebElement submitbtn;
	
	@FindBy(name="firstName")
	WebElement  ftName;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="country")
	WebElement country;
	
	public ProfilePage () {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateEditImage() {
		return editimage.isDisplayed();
	}
	public boolean validateSubmitBtn() {
		return submitbtn.isDisplayed();
	}
	public void fillingForm(String firstname, String ct, String count) {
		Select select=new Select(country);
		select.selectByVisibleText(count);
		ftName.sendKeys(firstname);
		city.sendKeys(ct);
		
	}

}
