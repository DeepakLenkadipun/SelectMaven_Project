package com.crm.autodesk.ContactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.BaseClass;
import com.crm.autodesk.GenericLibraries.ExcelFileUtility;
import com.crm.autodesk.GenericLibraries.JSONFileUtility;
import com.crm.autodesk.GenericLibraries.JavaUtility;
import com.crm.autodesk.GenericLibraries.WebDriverUtility;
import com.crm.autodesk.elementeRepository.ContactsPage;
import com.crm.autodesk.elementeRepository.HomePage;
import com.crm.autodesk.elementeRepository.LoginPage;

public class TC_19_SendmailwithoutSelectContact extends BaseClass {
	

	@Test(groups="RegresionSuite")
	public void sendmailWithoutClickContact() throws Throwable {
	
		//String orgName = eLib.getExcelData("Sheet2", 1, 3) + jLib.getrandomNum();


		// navigate to contact page

		 HomePage hp = new HomePage(driver);
         hp.clickonContacts();
         
         //click on sendmailbutton and capture alert msg with accept
         ContactsPage cp=new ContactsPage(driver);
         cp.Printalertmsgofpopup(driver);            
       
      
 
	}        
}
