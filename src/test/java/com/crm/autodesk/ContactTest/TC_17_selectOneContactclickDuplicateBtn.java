package com.crm.autodesk.ContactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.BaseClass;
import com.crm.autodesk.GenericLibraries.ExcelFileUtility;
import com.crm.autodesk.GenericLibraries.JSONFileUtility;
import com.crm.autodesk.GenericLibraries.JavaUtility;
import com.crm.autodesk.GenericLibraries.WebDriverUtility;
import com.crm.autodesk.elementeRepository.ContactsDuplicatePage;
import com.crm.autodesk.elementeRepository.ContactsInfopage;
import com.crm.autodesk.elementeRepository.ContactsPage;
import com.crm.autodesk.elementeRepository.HomePage;
import com.crm.autodesk.elementeRepository.LoginPage;

public class TC_17_selectOneContactclickDuplicateBtn extends BaseClass {
	

	@Test(groups="SmokeSuite")
	public void ViewContact() throws Throwable {
	
		//String orgName = eLib.getExcelData("Sheet2", 1, 3) + jLib.getrandomNum();

		
		// navigate to contact page

		 HomePage hp = new HomePage(driver);
         hp.clickonContacts();
         
         //select on thirdcontactCheckBox
         ContactsPage cp=new ContactsPage(driver);
         cp.clickonthirdcheckbox();
         
       //  click third contact
         cp.clickonthirdcontact();
         
         //capture firstname of contact
         ContactsInfopage cip=new ContactsInfopage(driver);
         String acctualconInfo=cip.getlastname();
        System.out.println("actual 1st name  "+acctualconInfo);
        
         
         //click on duplicate
         cip.ClickonduolicateBtn();
         
         //click on savebutton
         ContactsDuplicatePage cdp= new ContactsDuplicatePage(driver);
         cdp.clickOnSaveBtn();
         
         //click on contactlink
         hp.clickonContacts();
         
         //printing all 1stname of contact
         String duplicateinfo=cp.getallcontactsfirstname();
      
     	//validation
 		Assert.assertTrue(acctualconInfo.contains(duplicateinfo));
 		System.out.println("test case pass");
 		
 }
}
