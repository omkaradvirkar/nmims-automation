package com.nmims.pageObjectMethod;

import org.openqa.selenium.WebDriver;

import com.nmims.pageObject.LoginPageObject;

public class LoginPageObjectMethod extends LoginPageObject {

	public LoginPageObjectMethod(WebDriver driver) {
		super(driver);
		}
	
	public void setUsername(String username) {
		sapId.clear();
		sapId.sendKeys(username);
		}
	
	public void setPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void Login() {
		loginButton.click();
	}
	
	public void Logout() {
		logoutbutton.click();
	}

}
