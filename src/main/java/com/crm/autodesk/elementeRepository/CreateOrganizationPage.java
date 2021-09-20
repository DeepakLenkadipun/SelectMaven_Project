package com.crm.autodesk.elementeRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericLibraries.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility{
	//constructor
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//locate all thw webelement
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
    
	
	// generates getters
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business logic
	/**
	 * this meyhod will create organization with mandatory field
	 * @param OrgName
	 */
    
	public void createorganization(String OrgName) {
		orgNameEdt.sendKeys(OrgName);
		saveBtn.click();
	}
	
	/**
	 * this method will create organization by choosing an industry type
	 * @param OrgName
	 * @param industryType
	 */
	
	public void createOrganizationWithIndustries(String OrgName,String industryType) {
		orgNameEdt.sendKeys(OrgName);
		select(industryDropDown, industryType);
		saveBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
