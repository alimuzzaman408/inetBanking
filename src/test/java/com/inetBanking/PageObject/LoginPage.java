
package com.inetBanking.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetBanking.utilies.WaitHelper;

public class LoginPage {
	public WebDriver  driver;
	 WaitHelper waithelper;
	
	public LoginPage(WebDriver ldriver){	
		this.driver=ldriver;
		PageFactory.initElements(ldriver, this);
		waithelper=new WaitHelper(ldriver);

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
		waithelper.waitforElement(username, 20);
		username.sendKeys(name);

	}
	public void setpassword(String pass) {
		waithelper.waitforElement(Pasword, 20);
		Pasword.sendKeys(pass);

	}

	public void clicklogin() {
		waithelper.waitforElement(clickbtn, 15);
		clickbtn.click();
	}

	public void logOut() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
	 	js.executeScript("arguments[0].click();", lnkLogout) ; 
		//lnkLogout.click();	
	}






}
