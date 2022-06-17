package com.nexsoft.test.login;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserLoginTest {
	
	protected WebDriver driver;
	private JavascriptExecutor jsExe;
	
	public void delayMS(int inInt) {
		try {
			Thread.sleep(inInt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String screenShot() {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String namaFile = "D:\\selenium-workspace\\Week4_Final\\hasilScreenshot\\" + waktu + ".png";
		File screenshot = new File(namaFile);
		try {
			FileUtils.copyFile(srcFile, screenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return namaFile;
	}

	@BeforeTest
	public void init() {
		System.setProperty("url", "https://petstore.octoperf.com/actions/Catalog.action");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		jsExe = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
	}

	@BeforeMethod
	public void cekSession() {
		driver.get(System.getProperty("url"));
	}
	
	@Test(priority = 1)
	public void test_btnSignIn_gotoSignInPage() {
		CatalogActionPage catalog = PageFactory.initElements(driver, CatalogActionPage.class);
		SignInPage signIn = catalog.gotoSignInPage();
		String result = signIn.getCheckSignIn();
		
		delayMS(500);
		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
		Reporter.log(file);
		
		// verify go to sign in page
		assertEquals(result, "Please enter your username and password.");
	}
	
	@Test(priority = 2)
	public void test_signInSuccess_gotoMainPage() {
		CatalogActionPage catalog = PageFactory.initElements(driver, CatalogActionPage.class);
		MainPage main = catalog.gotoSignInPage().loginValidUser("buaya", "12345");
		String result = main.getUsername();
		
		delayMS(500);
		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
		Reporter.log(file);
		
		// verify login success
		assertEquals(result, "Welcome Buaya!");

		delayMS(500);
		main.gotoCatalogPage();
	}
	
	@Test(priority = 3)
	public void test_signInFail_usernameValid_passwordNotValid() {
		CatalogActionPage catalog = PageFactory.initElements(driver, CatalogActionPage.class);
		SignInPage signIn = catalog.gotoSignInPage();
		signIn.loginValidUser("buaya", "buaya");
		String result = signIn.getCheckSignInPasswordNotValid();
		
		delayMS(500);
		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
		Reporter.log(file);
		
		// verify login failed password not valid
		assertEquals(result, "Invalid username or password. Signon failed.");
	}
	
	@Test(priority = 4)
	public void test_signInFail_usernameNotValid_passwordNotValid() {
		CatalogActionPage catalog = PageFactory.initElements(driver, CatalogActionPage.class);
		SignInPage signIn = catalog.gotoSignInPage();
		signIn.loginValidUser("123", "buaya");
		String result = signIn.getCheckSignInUsernamePasswordNotValid();
		
		delayMS(500);
		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
		Reporter.log(file);
		
		// verify login failed username password not valid
		assertEquals(result, "Invalid username or password. Signon failed.");
	}
	
	@Test(priority = 5)
	public void test_signInFail_emptyUsernamePassword() {
		CatalogActionPage catalog = PageFactory.initElements(driver, CatalogActionPage.class);
		SignInPage signIn = catalog.gotoSignInPage();
		signIn.loginValidUser("", "");
		String result = signIn.getCheckSignInEmptyUsernamePassword();
		
		delayMS(500);
		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
		Reporter.log(file);
		
		// verify login failed username password not valid
		assertEquals(result, "Please enter your username and password.");
	}
	
	@Test(priority = 6)
	public void test_btnSignUp_gotoSignUpPage() {
		CatalogActionPage catalog = PageFactory.initElements(driver, CatalogActionPage.class);
		SignUpPage signUp = catalog.gotoSignInPage().gotoSignUpPage();
		String result = signUp.getCheckSignUp();
		
		delayMS(500);
		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
		Reporter.log(file);
		
		// verify sign up page
		assertEquals(result, "User Information");
	}
	
	@Test(priority = 7)
	public void test_signUp_createNewAccount() {
		CatalogActionPage catalog = PageFactory.initElements(driver, CatalogActionPage.class);
		SignUpPage signUp = catalog.gotoSignInPage().gotoSignUpPage();
		
		String result = signUp.createNewAccountUser(
				"macan", "passmacan", "passmacan", "macan", "laut", "macan@gmail.com",
				"0821212121", "ini alamat ke 1", "ini alamat ke 2", "tangerang",
				"banten", "40123", "indonesia"
				).getCheckBtnSignIn();
		
		delayMS(500);
		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
		Reporter.log(file);
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 200)", "");
		
		// verify create user new account
		assertEquals(result, "Sign In");
	}
	
	@Test(priority = 8)
	public void test_signUp_usingNewAccount() {

		CatalogActionPage catalog = PageFactory.initElements(driver, CatalogActionPage.class);
		MainPage main = catalog.gotoSignInPage().loginValidUser("macan", "passmacan");
		
		delayMS(500);
		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
		Reporter.log(file);
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 200)", "");
		
		String result = main.gotoAccountPage().getCheckAccounInfo();
		
		// verify go to account page
		assertEquals(result, "macan");
	}
	
	@Test(enabled=false,priority = 9)
	public void test_signUp_checkAllComponent() {
		SignInPage sign = PageFactory.initElements(driver, SignInPage.class);
		MainPage main = sign.loginValidUser("ikancupa", "passikan");
		
		delayMS(500);
		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
		Reporter.log(file);
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 200)", "");
		
		// verify user first name
		assertTrue(main.gotoAccountPage().getCheckFirstName(), "ikancupa");
	}
	
}
