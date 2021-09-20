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

public class TC_20_SendiningmaleMultipleContactse extends BaseClass {

	

	@Test(groups="RegresionSuite")
	public void sendAMailToSelectedContact() throws Throwable {
		

		String subjname = eLib.getExcelData("Sheet2", 1, 7);

		
		// navigate to contact page

		HomePage hp = new HomePage(driver);
		hp.clickonContacts();

		// select mulitiple contacts
		ContactsPage cp = new ContactsPage(driver);
		cp.clickonallcheckbox();
		// click on sendmail Btn
		cp.ClickonSendMailBtn();
		// click on save button on popup
		cp.selectsaveBtnonPopup();

		// switch to child window
		cp.switchtochildwindow(driver);

		// enter subject in mail
		cp.enterSubjectinmail(subjname);

		// switch to parent window
		cp.switchttoParentwindow(driver);

		
	}
}
