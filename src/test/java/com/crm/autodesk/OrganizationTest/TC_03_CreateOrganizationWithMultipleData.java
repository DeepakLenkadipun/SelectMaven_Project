package com.crm.autodesk.OrganizationTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.BaseClass;
import com.crm.autodesk.elementeRepository.CreateOrganizationPage;
import com.crm.autodesk.elementeRepository.HomePage;
import com.crm.autodesk.elementeRepository.OrganizationInfoPage;
import com.crm.autodesk.elementeRepository.OrganizationsPage;

public class TC_03_CreateOrganizationWithMultipleData extends BaseClass {
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		return eLib.getExceldata("Sheet4");
		
	}
	
	@Test(dataProvider="getData")
	public void createOrgWithMultipleData(String orgName,String IndType) {

		// navigate to organizations page
		HomePage hp = new HomePage(driver);
		hp.clickonOrganization();

		// navigate to createorganization page

		OrganizationsPage orgpage = new OrganizationsPage(driver);
		orgpage.clickOnCreateOrganizationImg();

		// create Organization
		CreateOrganizationPage creatorgp = new CreateOrganizationPage(driver);
		creatorgp.createOrganizationWithIndustries(orgName, IndType);

		// verification

		OrganizationInfoPage orginfo = new OrganizationInfoPage(driver);

		String actuallInfo = orginfo.getorganizationInformation();

		Assert.assertTrue(actuallInfo.contains(orgName));
		System.out.println(actuallInfo);
		
	    String actualIndustryInfo= orginfo.getIndustriesInformation();
	    Assert.assertTrue(actualIndustryInfo.contains(IndType));
		System.out.println(IndType);
		
	}

}
