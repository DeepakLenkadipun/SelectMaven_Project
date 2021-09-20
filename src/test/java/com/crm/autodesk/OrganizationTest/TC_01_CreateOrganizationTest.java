package com.crm.autodesk.OrganizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.BaseClass;
import com.crm.autodesk.GenericLibraries.ExcelFileUtility;
import com.crm.autodesk.GenericLibraries.JSONFileUtility;
import com.crm.autodesk.GenericLibraries.JavaUtility;
import com.crm.autodesk.GenericLibraries.WebDriverUtility;
import com.crm.autodesk.elementeRepository.CreateOrganizationPage;
import com.crm.autodesk.elementeRepository.HomePage;
import com.crm.autodesk.elementeRepository.LoginPage;
import com.crm.autodesk.elementeRepository.OrganizationInfoPage;
import com.crm.autodesk.elementeRepository.OrganizationsPage;


//@Listeners(com.crm.autodesk.GenericLibraries.Listners.class)        /* not required here bcz we make it in testng xml file for
                                                                       /*   all testscript no need of giving in individual class */
public class TC_01_CreateOrganizationTest extends BaseClass {


	@Test(retryAnalyzer=com.crm.autodesk.GenericLibraries.RetryAnalyser.class)
	public void createNewOrganization() throws Throwable {

	//	String orgName = eLib.getExcelData("Sheet2", 1, 3) + jLib.getrandomNum();
		
		String orgName = eLib.getExcelData("Sheet2", 1, 8) + jLib.getrandomNum();   /* making wrong for screenshot*/
       
		// navigate to organizations page
		HomePage hp = new HomePage(driver);
		hp.clickonOrganization();

		// navigate to createorganization page

		OrganizationsPage orgpage = new OrganizationsPage(driver);
		orgpage.clickOnCreateOrganizationImg();

		// create Organization
		CreateOrganizationPage creatorgp = new CreateOrganizationPage(driver);
		creatorgp.createorganization(orgName);

		// verification

		OrganizationInfoPage orginfo = new OrganizationInfoPage(driver);

		String actuallInfo = orginfo.getorganizationInformation();

		Assert.assertTrue(actuallInfo.contains(orgName));
		System.out.println(actuallInfo);


	}

}
