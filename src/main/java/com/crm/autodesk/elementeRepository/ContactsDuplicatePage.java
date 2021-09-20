package com.crm.autodesk.elementeRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsDuplicatePage {
	WebDriver driver;
	//constructor
	public ContactsDuplicatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		//locator
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement clickonSaveBtn;
	
	//generates gettermethod
	public WebElement getClickonSaveBtn() {
		return clickonSaveBtn;
	}
	
	//create businessmethod
	public void clickOnSaveBtn() {
		clickonSaveBtn.click();
	}

}
