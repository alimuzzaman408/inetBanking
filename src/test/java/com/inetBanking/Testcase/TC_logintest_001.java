package com.inetBanking.Testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObject.LoginPage;
import com.inetBanking.Testcase.Base;

public class TC_logintest_001 extends Base {
	
	@Test
	public void logintest() throws IOException, InterruptedException {	
		LoginPage login=new LoginPage(driver);		
		login.setusername(uname);
		logger.info("username is entered");
		
		login.setpassword(paword);
		logger.info("password is entered");
		
		login.clicklogin();
		logger.info("Login button has clicked");
		System.out.println("Title of the home page:"+driver.getTitle());
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Title test is passed");
			
			
		}
		else {
			captureScreen(driver,"TC_logintest_001");
			Assert.assertTrue(false);
			logger.info("Title test failed");
			
		}		
	       login.logOut();
	
	}
}
