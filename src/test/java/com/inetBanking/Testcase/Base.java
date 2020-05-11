package com.inetBanking.Testcase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilies.Readconfig;

public class Base {
	Readconfig readconfig=new Readconfig ();
	public String url=readconfig.geturl();
	public String uname=readconfig.getusername();
	public String paword=readconfig.getpassword();
	public static WebDriver driver;
	public static Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getchromepath() );
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getfirefoxpath() );
			driver=new FirefoxDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver",readconfig.getrdgepath() );
			driver=new EdgeDriver();;
		}
		driver.get(url);
		logger=Logger.getLogger("inetBanking");
		PropertyConfigurator.configure("log4j.properties");
	}


	@AfterClass
	public void tearDown() {

		driver.quit();
	}

	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(9);
		return(generatedstring);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(6);
		return (generatedString2);
	}

	public void captureScreen(WebDriver driver,String tname) throws IOException {

		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir") +"/ScreenShots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot token");
		//		public static void takeScreenshotAtEndOfTest() throws IOException {
		//			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//			String currentDir = System.getProperty("user.dir");
		//			FileUtils.copyFile(scrFile, new File(currentDir + "/ScreenShots/" + System.currentTimeMillis() + ".png"));
		//		
		//	}



	}








}
