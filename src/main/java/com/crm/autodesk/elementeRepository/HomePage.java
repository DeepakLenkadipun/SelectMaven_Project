package com.crm.autodesk.elementeRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericLibraries.WebDriverUtility;

public class HomePage extends WebDriverUtility {
    public WebDriver driver;
    
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Contacts")
	private WebElement contactLnk; 
	
	@FindBy(xpath="//span[text()=' Administrator']/../following-sibling::td[1]/img")
	private WebElement administatorImg; 
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutLnk;
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement organizationLnk; 
	
	@FindBy(linkText="Products")
	private WebElement productsLnk; 
	
	@FindBy(linkText="Email")
	private WebElement emailLnk; 
	
	@FindBy(linkText="Opportunities")
	private WebElement oppertunitiesLnk; 
	
	@FindBy(linkText="Leads")
	private WebElement leadsLnk;
	
	//generates getters

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getAdministatorImg() {
		return administatorImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}

	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getEmailLnk() {
		return emailLnk;
	}

	public WebElement getOppertunitiesLnk() {
		return oppertunitiesLnk;
	}

	public WebElement getLeadsLnk() {
		return leadsLnk;
	} 
	
	//provied business logic
	
	public void clickonOrganization() {
		
		organizationLnk.click();
	}
	
	public void clickonContacts() {
		contactLnk.click();
	}
	
	public void signOut(WebDriver driver) {
		mouseover(driver, administatorImg);
		signoutLnk.click();
	}
	public void clickonLeads() {
		leadsLnk.click();
	}

}



























