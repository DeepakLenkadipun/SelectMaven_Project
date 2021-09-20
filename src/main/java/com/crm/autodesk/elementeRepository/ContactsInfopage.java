package com.crm.autodesk.elementeRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfopage {
	WebDriver driver;
	
	public ContactsInfopage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath="//span[@id='dtlview_First Name']")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@title='Duplicate [Alt+U]']")
	private WebElement DuplicateBtn;
    
	//getters method
	
	
	public WebElement getDuplicateBtn() {
		return DuplicateBtn;
	}
	
	public WebElement getLastname() {
		return lastname;
	}

	//generate business method
	public void ClickonduolicateBtn() {
		DuplicateBtn.click();
	}
	
	public String getlastname() {
		String lnmae=lastname.getText();
		return lnmae;
		
	}

}
