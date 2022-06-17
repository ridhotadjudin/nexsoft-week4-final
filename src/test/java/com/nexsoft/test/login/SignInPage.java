package com.nexsoft.test.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	protected WebDriver driver;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//p[normalize-space()='Please enter your username and password.']")
	private WebElement checkSignIn;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement inputUsername;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement inputPassword;

	@FindBy(xpath = "//input[@name='signon']")
	private WebElement btnLogin;
	
	@FindBy(xpath = "//ul[@class='messages']")
	private WebElement invalidUsernamePassword;
	
	@FindBy(xpath = "//a[normalize-space()='Register Now!']")
	private WebElement btnSignUp;
	
	@FindBy(xpath = "//*[@id=\"Catalog\"]/form/p[1]")
	private WebElement emptyUsernamePassword;
	
	
	public MainPage loginValidUser(String username,String password) {
		inputUsername.clear();
		inputUsername.sendKeys(username);
		inputPassword.clear();
		inputPassword.sendKeys(password);
		btnLogin.click();
		return PageFactory.initElements(driver, MainPage.class);
	}
	
	public SignUpPage gotoSignUpPage() {
		btnSignUp.click();
		return PageFactory.initElements(driver, SignUpPage.class);
	}
	
	public String getCheckSignIn() {
		return checkSignIn.getText();
	}
	
	public String getCheckSignInPasswordNotValid() {
		return invalidUsernamePassword.getText();
	}
	
	public String getCheckSignInUsernamePasswordNotValid() {
		return invalidUsernamePassword.getText();
	}
	
	public String getCheckSignInEmptyUsernamePassword() {
		return emptyUsernamePassword.getText();
	}


}
