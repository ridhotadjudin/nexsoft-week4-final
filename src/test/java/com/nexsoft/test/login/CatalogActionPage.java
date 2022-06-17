package com.nexsoft.test.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogActionPage {
	
	protected WebDriver driver;

	public CatalogActionPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//a[normalize-space()='Sign In']")
	private WebElement signIn;

	public SignInPage gotoSignInPage() {
		signIn.click();
		return PageFactory.initElements(driver, SignInPage.class);
	}
}
