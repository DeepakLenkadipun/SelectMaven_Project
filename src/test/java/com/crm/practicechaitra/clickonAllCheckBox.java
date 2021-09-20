package com.crm.practicechaitra;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.JSONFileUtility;

public class clickonAllCheckBox {
	WebDriver driver;
	@Test
	public void OrganisationTest() throws Throwable {
		
        JSONFileUtility jsonLib=new JSONFileUtility();
		
	String BROWSER=jsonLib.readDataFromJSON("browser");
	String URL=jsonLib.readDataFromJSON("url");
	String USERNAME=jsonLib.readDataFromJSON("username");
	String PASSWORD=jsonLib.readDataFromJSON("password");
		
	
	if(BROWSER.equals("chrome")) {
		driver=new ChromeDriver();
	}else if(BROWSER.equals("firefox")) {
		driver=new FirefoxDriver();
	}else {
		System.out.println("invalid browser");
	}
	driver.get(URL);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Organizations")).click();
	List<WebElement>list=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
	
	// click all check box
	for(WebElement wb:list) {
		wb.click();
		
	}
	
	//click only 5th checkbox
	for(int i=0;i<list.size();i++)
	{
		list.get(i=4).click();
		break;
	}
	
	//click on last check box
	list.get(list.size()-1).click();
	
	//get all element from organization td
	List<WebElement>list1=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']"));
	
	for(WebElement wb1:list1) {
		
		System.out.println(wb1.getText());
		
	}
	driver.close();
 }

}
