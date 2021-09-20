package com.crm.practicechaitra;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.JSONFileUtility;

public class clickForDelete {
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
	List<WebElement>list2=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[8]/a/following-sibling::a"));
	
	//click 11th checkbox and delete
	for(int i=0;i<list.size();i++)
	{
		list.get(i=10).click();
		list2.get(i=10).click();
		Alert alt=driver.switchTo().alert();
		alt.accept();
		break;
	}
	driver.close();
  }
}
