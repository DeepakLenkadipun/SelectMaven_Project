package com.crm.autodesk.elementeRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericLibraries.WebDriverUtility;

public class ContactsPage extends WebDriverUtility {
	// constructor
	WebDriver driver;

	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// locate all elements
	@FindBy(xpath = "//img[@title='Last Viewed']")
	private WebElement lastViwedImg;

	@FindBy(xpath = "//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']")
	private List<WebElement> allCheckBox;

	@FindBy(xpath = "//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Contacts']")
	private List<WebElement> allcontacts;
	
	@FindBy(xpath = "//td[@class='trackerList small']/../td[2]/a")
	private List<WebElement> getlastViewdcontact;

	@FindBy(xpath = "//input[@value='Send Mail']")
	private WebElement sendmailBtn;
	
	@FindBy(xpath = "//b[text()='Email']")
	private WebElement childframe;
	
	@FindBy(xpath = "//input[@value=' Select ']")
	private WebElement childframeselectBtn;
	
	@FindBy(id = "parent_name")
	private WebElement childwindowemailToEdt;
	
	@FindBy(name = "subject")
	private WebElement childwindowemailsubjectEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement childwindowsaveBtn;
	
	@FindBy(xpath="//a[text()='Deepak']")
	private WebElement getContactInfo;
	
	
	// generate getters
    
	public WebElement getGetContactInfo() {
		return getContactInfo;
	}


	public WebElement getChildwindowsaveBtn() {
		return childwindowsaveBtn;
	}

	
	public List<WebElement> getGetlastViewdcontact() {
		return getlastViewdcontact;
	}


	public WebElement getChildwindowemailToEdt() {
		return childwindowemailToEdt;
	}

	
	public WebElement getChildwindowemailsubjectEdt() {
		return childwindowemailsubjectEdt;
	}


	public WebElement getChildframeselectBtn() {
		return childframeselectBtn;
	}


	public WebElement getChildframe() {
		return childframe;
	}

	public WebElement getLastViwedImg() {
		return lastViwedImg;
	}

	public List<WebElement> getAllCheckBox() {
		return allCheckBox;
	}

	public List<WebElement> getAllcontacts() {
		return allcontacts;
	}

	public WebElement getSendmailBtn() {
		return sendmailBtn;
	}

	// provied business method
	/**
	 * this method will allow to click on lastviewed image
	 */
	public void clickonLastViewBtn() {
		lastViwedImg.click();
	}

	public void clickonallcheckbox() {
		List<WebElement>list=allCheckBox;
		for(WebElement wb:list) {
			wb.click();	
		}
	}

	public void clickonthirdcheckbox() {
		List<WebElement> list = allCheckBox;
		for(int i=0;i<list.size();i++)
		{
			list.get(i=2).click();
			break;
		}
	}
	public void clickonthirdcontact() {
		List<WebElement> list = allcontacts;
		for(int i=0;i<list.size();i++)
		{
			list.get(i=2).click();
		}
	}
	
	
	public void Printalertmsgofpopup(WebDriver driver) {
		sendmailBtn.click();
		printalertmsg(driver);
		acceptAlert(driver);
	}
	public void selectsaveBtnonPopup() {
		childframeselectBtn.click();
		
	}
	
	public void switchtochildwindow(WebDriver driver) 
	{
		switchToWindow(driver, "Emails");	
	}
	public void switchttoParentwindow(WebDriver driver) 
	{
		switchToWindow(driver, "Contacts");	
	}
	public void enterSubjectinmail(String subject) {
		childwindowemailsubjectEdt.sendKeys(subject);
		childwindowsaveBtn.click();
	}
	
	public String getallViewdcontact() {
		String List=null;
		for(WebElement wb:getlastViewdcontact) {
	      List=	wb.getText();
	      System.out.println(List);
		}
		return List;
		
	}
	public String getallcontactsfirstname() {
		String List=null;
		for(WebElement wb:allcontacts) {
	      List=	wb.getText();
	      System.out.println(List);
		}
		return List;
		
	}
	public void ClickonSendMailBtn() {
		sendmailBtn.click();
	}
	public String getContactInformation() {
		return getContactInfo.getText();
		
	}

	
	
}
