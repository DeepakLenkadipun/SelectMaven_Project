package com.crm.autodesk.practiceContactsTests;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.ExcelFileUtility;
import com.crm.autodesk.GenericLibraries.JSONFileUtility;
import com.crm.autodesk.GenericLibraries.JavaUtility;
import com.crm.autodesk.GenericLibraries.WebDriverUtility;

public class TC_04_CreateproductAndCompare {
	WebDriver driver;

	@Test
	public void createNewProduct() throws Throwable {
		// read all the neccessary data
		JSONFileUtility jsonLib = new JSONFileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();

		String BROWSER = jsonLib.readDataFromJSON("browser");
		String URL = jsonLib.readDataFromJSON("url");
		String USERNAME = jsonLib.readDataFromJSON("username");
		String PASSWORD = jsonLib.readDataFromJSON("password");

		String productName = eLib.getExcelData("Sheet2", 1, 5);
		String searchcontains = eLib.getExcelData("Sheet2", 0, 5);
		String PartNo = eLib.getExcelData("Sheet2", 0, 6);

		// launch Browser
		if (BROWSER.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browser");
		}
		wLib.waitForPageLoad(driver);
		wLib.maximiseWindow(driver);
		driver.get(URL);

		// Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// click on products
		driver.findElement(By.linkText("Products")).click();

		// click on products link
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

		// create Products
		driver.findElement(By.name("productname")).sendKeys(productName);
		driver.findElement(By.id("productcode")).sendKeys("102");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// capture text of product no
		WebElement webe = driver.findElement(By.xpath("//td[text()='Product No']/following-sibling::td"));
		String produc = webe.getText();
		System.out.println("captured product no" + webe.getText());

		// again click on product
		driver.findElement(By.linkText("Products")).click();

		// give input in search box
		driver.findElement(By.name("search_text")).sendKeys(productName);

		// search on search box by index
		WebElement elem = driver.findElement(By.id("bas_searchfield"));
		wLib.select(elem, 1);

		// click on search now
		driver.findElement(By.name("submit")).click();

		// explicity wait
		WebElement eleme = driver.findElement(By.xpath("//span[text()='of 1']"));
		wLib.waitForElementToBeVisible(driver, eleme);

		// validation for product no
		List<WebElement> webel = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]"));
		for (WebElement wb : webel) {
			System.out.println(wb.getText());
			if (produc.contains(wb.getText())) {
				System.out.println("create product pass");
				break;
			}
		}
		// explicity wait

		WebElement element = driver.findElement(By.xpath("//span[@class='small']"));
		wLib.waitForElementToBeVisible(driver, element);

		// logout
		WebElement ele = driver
				.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td[1]/img"));
		wLib.mouseover(driver, ele);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		driver.close();
	}

}
