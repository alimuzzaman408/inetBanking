package com.inetBanking.Testcase;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.PageObject.LoginPage;
import com.inetBanking.utilies.Testutil;

public class TC_logintestDDT_002 extends Base {

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setusername(user);
		logger.info("user name provided");
		lp.setpassword(pwd);
		logger.info("password provided");
		Thread.sleep(3000);
		lp.clicklogin();;
		Thread.sleep(5000);

		if(isAlertPresent()==true)
		{
			
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.logOut();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();

		}


	}


	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}

	}


	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=".//src/test/java/com/inetBanking/Testdata/testdata.xlsx";

		int rownum=Testutil.getRowCount(path, "login");
		int colcount=Testutil.getCellCount(path,"login",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=Testutil.getCellData(path,"login", i,j);//1 0
			}

		}
		return logindata;
	}

}
