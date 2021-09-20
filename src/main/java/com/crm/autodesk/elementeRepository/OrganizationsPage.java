package com.crm.autodesk.elementeRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	public OrganizationsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//locate all element
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgImg;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;

	@FindBy(name="submit")
	private WebElement submitBtn;
	
	//generates getters

	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//provied business methods
	
	public void clickOnCreateOrganizationImg() {
		createOrgImg.click();
	}
	

}
