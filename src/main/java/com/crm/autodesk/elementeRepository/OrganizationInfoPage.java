package com.crm.autodesk.elementeRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericLibraries.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility {
	WebDriver driver;
	// constructor
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//locate webelement
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement organizationInfo;
    
	@FindBy(id="dtlview_Industry")
	private WebElement industryInfo;
	
	@FindBy(xpath="//span[@class='small']")
	private WebElement elementofexplicity;
	
	//generates getters
     public WebElement getElementofexplicity() {
		return elementofexplicity;
	}

	
	public WebElement getOrganizationInfo() {
		return organizationInfo;
	}

	public WebElement getIndustryInfo() {
		return industryInfo;
	}
	
	//provied bussiness methods
	/**
	 * get Organization information
	 * @return
	 */
	public String getorganizationInformation() {
		return organizationInfo.getText();
	}
	/**
	 * get industries information
	 * @return
	 */
	
	public String getIndustriesInformation() {
		return industryInfo.getText();
	}
	/**
	 * this method is for expilicity wait
	 */
	public void elementforexplicitywait() {
	 waitForElementToBeVisible(driver, elementofexplicity);
	}

}
