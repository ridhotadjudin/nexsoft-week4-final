package com.nexsoft.test.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	
	protected WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//div[@id='WelcomeContent']")
	private WebElement checkUsername;
	
	@FindBy(xpath = "//*[@id=\"MenuContent\"]/a[2]")
	private WebElement btnLogout;
	
	public String getUsername() {
		return checkUsername.getText();
	}
	
	public CatalogActionPage gotoCatalogPage() {
		btnLogout.click();
		return PageFactory.initElements(driver, CatalogActionPage.class);
	}
	
}
