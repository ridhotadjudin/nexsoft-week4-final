package com.nexsoft.test.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(xpath = "//input[@name='newAccount']")
	private WebElement btnCreateUser;

	// user information element
	@FindBy(xpath = "//input[@name='username']")
	private WebElement uiUserID;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement uiNewPassword;
	@FindBy(xpath = "//input[@name='repeatedPassword']")
	private WebElement uiRepeatPassword;
	
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

	public String getCheckSignUp() {
		String output = null;
		if (checkSignUp1 != null && checkSignUp2 != null && checkSignUp3 != null) {
			output = checkSignUp1.getText();
		}
		return output;
	}

	public SignInPage createNewAccountUser(
			String uname, String pass, String rePass, String firstName, String lastName, 
			String email, String phone, String address1, String address2, String city,
			String state, String zip, String country
			) {
		uiUserID.sendKeys(uname);
		uiNewPassword.sendKeys(pass);
		uiRepeatPassword.sendKeys(rePass);
		
		aiFirstName.sendKeys(firstName);
		aiLastName.sendKeys(lastName);
		aiEmail.sendKeys(email);
		aiPhone.sendKeys(phone);
		aiAddress1.sendKeys(address1);
		aiAddress2.sendKeys(address2);
		aiCity.sendKeys(city);
		aiState.sendKeys(state);
		aiZip.sendKeys(zip);
		aiCountry.sendKeys(country);

//		btnCreateUser.click();
		return PageFactory.initElements(driver, SignInPage.class);
	}

}
