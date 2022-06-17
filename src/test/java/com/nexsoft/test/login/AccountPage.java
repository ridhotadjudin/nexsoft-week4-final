package com.nexsoft.test.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {
	
	protected WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//td[normalize-space()='ikan']")
	private WebElement checkUsername;
	
	public String getCheckAccounInfo() {
		return checkUsername.getText();
	}
}
