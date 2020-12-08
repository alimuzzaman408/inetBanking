package com.inetBanking.Testcase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilies.Readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	Readconfig readconfig=new Readconfig ();
	public String url=readconfig.geturl();
	public String uname=readconfig.getusername();
	public String paword=readconfig.getpassword();
	public String br=readconfig.getbrowser();
	public static WebDriver driver;
	public static Logger logger;


	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		logger=Logger.getLogger("inetBanking");
		PropertyConfigurator.configure("log4j.properties");



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
		else if(br.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);

	}


	@AfterClass
	public void tearDown() {

		driver.quit();
	}

	
	
	public static String randomestring()
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
		File target=new File(System.getProperty("user.dir") +"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");


	}



}









