package com.crm.autodesk.GenericLibraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.elementeRepository.HomePage;
import com.crm.autodesk.elementeRepository.LoginPage;

/**
 * This class contains all the basic configuration annotation
 */

public class BaseClass {
	public DataBaseUtility dLib = new DataBaseUtility();
	public JSONFileUtility jsonLib = new JSONFileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriver driver;
	public static WebDriver staticdriver;

	@BeforeSuite(groups = { "SmokeSuite", "RegresionSuite" })
	public void connectDB() throws Throwable {
		// dLib.connectToDatabase();
		System.out.println("=======MakeDBConnection========");
	}

	// @Parameters("BROWSER")
	@BeforeClass(groups = { "SmokeSuite", "RegresionSuite" })
	public void launchBrowser(/* String BROWSER*/ ) throws Throwable {
		System.out.println("========launchBrowser==========");
		String BROWSER = jsonLib.readDataFromJSON("browser");
		String URL = jsonLib.readDataFromJSON("url");
		if (BROWSER.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browser");
		}
		wLib.waitForPageLoad(driver);
		wLib.maximiseWindow(driver);
		driver.get(URL);
		staticdriver = driver;
	}

	@BeforeMethod(groups = { "SmokeSuite", "RegresionSuite" })
	public void loginToApp() throws Throwable {
		System.out.println("=====LoginApp======");
		String USERNAME = jsonLib.readDataFromJSON("username");
		String PASSWORD = jsonLib.readDataFromJSON("password");

		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
	}

	@AfterMethod(groups = { "SmokeSuite", "RegresionSuite" })
	public void logoutofApp() {
		System.out.println("======logoutOfApp");

		HomePage hp = new HomePage(driver);
		hp.signOut(driver);
	}

	@AfterClass(groups = { "SmokeSuite", "RegresionSuite" })
	public void closeBrowser() {
		System.out.println("========closeBrowser========");
		driver.close();
	}

	@AfterSuite(groups = { "SmokeSuite", "RegresionSuite" })
	public void closeDB() throws Throwable {
		// dLib.closeDb();
		System.out.println("==============close=============");
	}

	/**
	 * method for Screenshot
	 * 
	 * @param name
	 * @return
	 * @throws IOException
	 */
	public String getscreenshot(String name) throws IOException {
		File srcfile = ((TakesScreenshot) staticdriver).getScreenshotAs(OutputType.FILE);
		String destfile = System.getProperty("user.dir") + "/Screenshots/" + name +jLib.getrandomNum()+" .png";
		File finaldest = new File(destfile);
		FileUtils.copyFile(srcfile, finaldest);
		return destfile;

	}

}
