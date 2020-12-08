package com.inetBanking.utilies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	WebDriver driver;

	public WaitHelper( WebDriver ldriver){

		this.driver=ldriver;


	}

	public  void waitforElement(WebElement element,long timeoutunitsecond) {

		WebDriverWait wait=new WebDriverWait(driver,timeoutunitsecond);
		wait.until(ExpectedConditions.visibilityOf(element));



	}




}
