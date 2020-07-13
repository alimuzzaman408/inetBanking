package com.inetBanking.utilies;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {


	public Properties pro;

	public Readconfig(){

		File sc=new File("./Configur/config.properties");
		
		try{
			pro=new Properties();
			FileInputStream ip=new FileInputStream(sc);
			
			pro.load(ip);


		}
		catch(Exception e) {

			System.out.println("Exception occured "+e.getMessage());
		}


	}
	public String getbrowser() {
		String br=pro.getProperty("browser");
		return br;
	}
	public String geturl() {
		String url=pro.getProperty("url");
		return url;
		
	}

	public String getusername() {
		String username=pro.getProperty("uname");
		return username;
	}

	public String getpassword() {
		String password=pro.getProperty("paword");
		return password;
	}

	public String getchromepath() {
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}

	public String getfirefoxpath() {
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}

	public String getrdgepath() {
		String edgepath=pro.getProperty("egedriver");
		return edgepath;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
