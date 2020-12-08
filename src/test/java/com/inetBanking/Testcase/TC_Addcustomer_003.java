package com.inetBanking.Testcase;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetBanking.PageObject.AddCustomer;
import com.inetBanking.PageObject.LoginPage;
public class TC_Addcustomer_003 extends Base{

	@Test
	public void addingCustomer() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setusername(uname);
		lp.setpassword(paword);
		lp.clicklogin();
		AddCustomer adcus=new AddCustomer(driver);
		adcus.clickcustomer();
		
		adcus.setcustomer("Alimuzzaman");
		adcus.cusaddress("39ave");
		adcus.customercity("Staten island");
		adcus.customerstate("newjersey");
		adcus.customertelephone("6466376908");
		adcus.enterdate("07", "06", "1992");
		adcus.customerpassword("uiouy");
		adcus.customerpinno("458761");//123406
		adcus.genderclass("male");
		String Email=randomestring()+"@gmail.com";
		adcus.customeremail(Email);
		Thread.sleep(3000);
		adcus.clicksubmit();

		Thread.sleep(3000);

		logger.info("validation started....");

		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");

		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");

		}
		else
		{
			logger.info("test case failed....");
			captureScreen( driver,"addingCustomer");

			Assert.assertTrue(false);
		}



	}








}
