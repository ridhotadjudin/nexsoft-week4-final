package com.nexsoft.test.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {
	
	protected WebDriver driver;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//h3[normalize-space()='User Information']")
	private WebElement checkSignUp1;
	@FindBy(xpath = "//h3[normalize-space()='Account Information']")
	private WebElement checkSignUp2;
	@FindBy(xpath = "//h3[normalize-space()='Profile Information']")
	private WebElement checkSignUp3;
	
	public String getCheckSignUp() {
		String output = null;
		if(checkSignUp1!=null && checkSignUp2!=null && checkSignUp3!=null) {
			output = checkSignUp1.getText();
		}
		return output;
	}
	
	
}
