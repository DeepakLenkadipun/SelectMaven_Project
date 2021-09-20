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

public class TC_03_CreateOrganizationwithindustryEducation {
	WebDriver driver;

	@Test
	public void createNewOrganizationwithEducation() throws Throwable {
		// read all the neccessary data
		JSONFileUtility jsonLib = new JSONFileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();

		String BROWSER = jsonLib.readDataFromJSON("browser");
		String URL = jsonLib.readDataFromJSON("url");
		String USERNAME = jsonLib.readDataFromJSON("username");
		String PASSWORD = jsonLib.readDataFromJSON("password");

		String orgName = eLib.getExcelData("Sheet2", 1, 3) + jLib.getrandomNum();
		String indname = eLib.getExcelData("Sheet2", 1, 4);

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

		// click on Organization
		driver.findElement(By.linkText("Organizations")).click();

		// creat on creat Organization link
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// create Organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// choose industry as education
		WebElement wbe = driver.findElement(By.name("industry"));
		wLib.select(wbe, indname);

		// explicity wait

		WebElement element = driver.findElement(By.xpath("//span[@class='small']"));
		wLib.waitForElementToBeVisible(driver, element);

		// logout
		WebElement ele = driver
				.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td[1]/img"));
		wLib.mouseover(driver, ele);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		driver.close();
	}

}
