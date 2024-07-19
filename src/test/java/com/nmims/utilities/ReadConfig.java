package com.nmims.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prt;
	public ReadConfig() {
		try {
			FileInputStream fis=new FileInputStream("./Configuration/config.properties");
			prt=new Properties();
			prt.load(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
		
}
	
	public String getUrl() {
		String url = prt.getProperty("url");
		return url;
	}

	
	public String getUsername() {
		String sapid = prt.getProperty("sapid");
		return sapid;
	}
	
	public String getPassword() {
		String password = prt.getProperty("password");
		return password;
	}
	
	public String getChromepath() {
		String chromepath = prt.getProperty("chromepath");
		return chromepath;
	}
	
	
}
