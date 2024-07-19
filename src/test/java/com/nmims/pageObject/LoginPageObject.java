package com.nmims.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	
	public LoginPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	@CacheLookup
	protected  WebElement sapId;

	@FindBy(name = "password")
	@CacheLookup
	protected WebElement password;
	
	@FindBy(id = "login")
	@CacheLookup
	protected WebElement loginButton;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	@CacheLookup
	protected WebElement logoutbutton;
	
	
}
