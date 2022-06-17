package com.nexsoft.test.login;

import static org.testng.Assert.assertEquals;

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

public class UserSignUpTest {
	

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
	public void test_signUp_createNewAccount() {
		CatalogActionPage catalog = PageFactory.initElements(driver, CatalogActionPage.class);
		SignUpPage signUp = catalog.gotoSignInPage().gotoSignUpPage();
		
		String result = signUp.createNewAccountUser(
				"ikan", "passikan", "passikan", "ikan", "laut", "ikanlaut@gmail.com",
				"0821212121", "ini alamat ke 1", "ini alamat ke 2", "tangerang",
				"banten", "40123", "indonesia"
				).getCheckBtnSignIn();
		
		delayMS(500);
		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
		Reporter.log(file);
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 200)", "");
		
		MainPage main = catalog.gotoSignInPage().loginValidUser("ikan", "passikan");
		String result2 = main.gotoAccountPage().getCheckAccounInfo();
		
		// verify create user new account
		assertEquals(result, "Sign In");
		// verify go to account page
		assertEquals(result2, "ikan");
	}
	
}
