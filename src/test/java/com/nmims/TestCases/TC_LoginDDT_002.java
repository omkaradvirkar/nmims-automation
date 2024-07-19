package com.nmims.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nmims.pageObjectMethod.LoginPageObjectMethod;
import com.nmims.utilities.XLUtils;



public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String un,String pwd) throws InterruptedException, IOException {
		LoginPageObjectMethod lop=new LoginPageObjectMethod(driver);
		lop.setUsername(un);
		logger.info("Username Entered");
		lop.setPassword(pwd);
		logger.info("Password Entered");
		lop.Login();
		Thread.sleep(10000);
		if(driver.getPageSource().contains("Incorrect username or password. Please try again.")) {
			logger.info("Please enter valid credentials");
			Assert.assertTrue(false);
			driver.close();
			
		}
		captureScreen(driver, "loginDDT");
		Thread.sleep(10000);
		lop.Logout();
		
		
		
	}
	
	@DataProvider(name="LoginData")
	 String[][] getData() throws IOException{
		String path="./Configuration/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for (int row = 1; row <=rownum; row++) {
			for (int column = 0; column <colcount; column++) {
				logindata [row-1] [column]=XLUtils.getCellData(path, "Sheet1", row, column);
				
			}
			}
	return logindata;	
	}

}
