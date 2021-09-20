package com.crm.autodesk.practiceContactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.ExcelFileUtility;
import com.crm.autodesk.GenericLibraries.JSONFileUtility;
import com.crm.autodesk.GenericLibraries.JavaUtility;
import com.crm.autodesk.GenericLibraries.WebDriverUtility;

public class TC_01_CreateContactWithOrganizationTest {
	WebDriver driver;

	@Test
	public void createContactWithOrganization() throws Throwable {

		// read all the neccessary data
		JSONFileUtility jsonLib = new JSONFileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();

		String BROWSER = jsonLib.readDataFromJSON("browser");
		String URL = jsonLib.readDataFromJSON("url");
		String USERNAME = jsonLib.readDataFromJSON("username");
		String PASSWORD = jsonLib.readDataFromJSON("password");

		String contactName = eLib.getExcelData("Sheet2", 1, 2);
		String orgName = eLib.getExcelData("Sheet2", 1, 3);

		// launch Browser
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

		// Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// click on contact
		driver.findElement(By.linkText("Contacts")).click();

		// creat on creat contact link
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// create contact
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		driver.findElement(By.xpath("//img[@title='Select']")).click();

		// switch to child window
		wLib.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();

		driver.findElement(By.linkText("imperialblue")).click();

		// switch back to parent window

		wLib.switchToWindow(driver, "Contacts");
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		// logout
		WebElement ele = driver
				.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td[1]/img"));
		wLib.mouseover(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();

		// close
		driver.close();
	}
}
