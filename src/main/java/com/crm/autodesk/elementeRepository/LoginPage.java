package com.crm.autodesk.elementeRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {                         //Rule 1: Create a separate class for every web page
	
	//Rule 4:create a constructor and use pagefactory class to initialize
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//Rule 2:identify all the webelement using @FindBy,@FindBys and @Find All annotation
	@FindBy(name="user_name")                   
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")               
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")                    
	private WebElement loginBtn;
	
	//Rule 3:Declare all the webelements as Private and provide getters
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	//Rule 5: access the webelement using getters()/business methods
	
	public void login(String username,String password) {
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}

}




























