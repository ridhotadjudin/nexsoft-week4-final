package com.nexsoft.test.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {
	
	protected WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "body > div:nth-child(2) > div:nth-child(1) > form:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)")
	private WebElement checkUsername;
	
	public String getCheckAccounInfo() {
		return checkUsername.getText();
	}
}
