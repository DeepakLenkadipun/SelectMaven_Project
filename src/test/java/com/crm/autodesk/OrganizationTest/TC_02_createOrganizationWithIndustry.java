package com.crm.autodesk.OrganizationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.ExcelFileUtility;
import com.crm.autodesk.GenericLibraries.JSONFileUtility;
import com.crm.autodesk.GenericLibraries.JavaUtility;
import com.crm.autodesk.GenericLibraries.WebDriverUtility;
import com.crm.autodesk.elementeRepository.CreateOrganizationPage;
import com.crm.autodesk.elementeRepository.HomePage;
import com.crm.autodesk.elementeRepository.LoginPage;
import com.crm.autodesk.elementeRepository.OrganizationInfoPage;
import com.crm.autodesk.elementeRepository.OrganizationsPage;

public class TC_02_createOrganizationWithIndustry {
	WebDriver driver;

	@Test
	public void createOrganizationwithindustryTest() throws Throwable {
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
		String industryName=eLib.getExcelData("Sheet2", 1, 4);

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

		// login page
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);

		// navigate to organizations page

		HomePage hp = new HomePage(driver);
		hp.clickonOrganization();

		// navigate to createorganization page

		OrganizationsPage orgpage = new OrganizationsPage(driver);
		orgpage.clickOnCreateOrganizationImg();

		// create Organizationwithindustry
		CreateOrganizationPage createorgp =new CreateOrganizationPage(driver);
		createorgp.createOrganizationWithIndustries(orgName, industryName);
		//verification 
		
		OrganizationInfoPage orginfo=new OrganizationInfoPage(driver);
		
		String actuallInfo=orginfo.getorganizationInformation();
		
		Assert.assertTrue(actuallInfo.contains(orgName));
		System.out.println(actuallInfo);
		String actuallIndInfo=orginfo.getIndustriesInformation();
		Assert.assertTrue(actuallIndInfo.equals(industryName));
		
		System.out.println(industryName);

     
		//signout
       HomePage hp1 = new HomePage(driver);
		hp1.signOut(driver);
		

		driver.close();
	
	}

}



