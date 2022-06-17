package com.nexsoft.test.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	protected WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "a[href='actions/Catalog.action']")
	private WebElement enterStore;

	public CatalogActionPage gotoCatalogActionPage() {
		enterStore.click();
		return PageFactory.initElements(driver, CatalogActionPage.class);
	}

}
