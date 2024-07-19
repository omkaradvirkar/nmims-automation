package com.nmims.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nmims.pageObjectMethod.LoginPageObjectMethod;

public class TC_001_Login extends BaseClass {
	LoginPageObjectMethod lpo;
	@Test
	public void Login() throws IOException {
		driver.get(url);
		lpo=new LoginPageObjectMethod(driver);
		logger.info("Url is entered ");
		lpo.setUsername(username);
		logger.info("Username is entered");
		lpo.setPassword(password);
		logger.info("Password is entered");
		lpo.Login();
		String Title="xyz";
		String expectedTitle = driver.getTitle();
		
		if (expectedTitle.equals(Title)) {
			Assert.assertTrue(true);
		} else {
			captureScreen(driver, "Login");
			Assert.assertTrue(false);
			
		}
		
	}
}
