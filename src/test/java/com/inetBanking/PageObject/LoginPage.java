
package com.inetBanking.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver  ldriver;
	public LoginPage(WebDriver rdriver){	
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

	}
	@CacheLookup
	@FindBy(name="uid")
	WebElement username;
	@CacheLookup
	@FindBy(name="password")
	WebElement Pasword;
	@CacheLookup
	@FindBy(name="btnLogin")
	WebElement clickbtn;

	@CacheLookup
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement lnkLogout;

	public void setusername(String name) {
		username.sendKeys(name);

	}
	public void setpassword(String pass) {

		Pasword.sendKeys(pass);

	}

	public void clicklogin() {
		clickbtn.click();
	}

	public void logOut() {

		lnkLogout.click();	
	}






}
