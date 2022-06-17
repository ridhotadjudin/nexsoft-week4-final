package com.nexsoft.test.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {

	protected WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//*[@id=\"Catalog\"]/form/table[1]/tbody/tr[1]/td[2]")
	private WebElement checkUsername;

	// account information element
	@FindBy(xpath = "//input[@name='account.firstName']")
	private WebElement aiFirstName;
	@FindBy(xpath = "//input[@name='account.lastName']")
	private WebElement aiLastName;
	@FindBy(xpath = "//input[@name='account.email']")
	private WebElement aiEmail;
	@FindBy(xpath = "//input[@name='account.phone']")
	private WebElement aiPhone;
	@FindBy(xpath = "//input[@name='account.address1']")
	private WebElement aiAddress1;
	@FindBy(xpath = "//input[@name='account.address2']")
	private WebElement aiAddress2;
	@FindBy(xpath = "//input[@name='account.city']")
	private WebElement aiCity;
	@FindBy(xpath = "//input[@name='account.state']")
	private WebElement aiState;
	@FindBy(xpath = "//input[@name='account.zip']")
	private WebElement aiZip;
	@FindBy(xpath = "//input[@name='account.country']")
	private WebElement aiCountry;

	// profile information element
	@FindBy(xpath = "//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[1]/td[2]/select")
	private WebElement piLanguage;
	@FindBy(xpath = "//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[2]/td[2]/select")
	private WebElement piCategory;

	public String getCheckAccounInfo() {
		return checkUsername.getText();	}
	
	public boolean getCheckFirstName() {
		return aiFirstName.isDisplayed();
	}
}
