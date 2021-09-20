package com.crm.autodesk.GenericLibraries;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all the generic methods related to Webdriver actions
 * @author DEEPAK LENKA
 *
 */
public class WebDriverUtility {
	/**
	 * This method will wait for the page load for 20 seconds
	 * @param driver
	 */
	    public void waitForPageLoad(WebDriver driver) {	
	    	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       }
	    /**
	     * this method will maximise the window
	     */
     public void maximiseWindow(WebDriver driver) {
    	 driver.manage().window().maximize();
     }
     /**
      * this method will select from the dropdown using visible text
      * @param element
      * @param value
      */
     
     public void select(WebElement element,String value) {
    	 Select sel=new Select(element);
    	 sel.selectByValue(value);
     }
     /**
      * this method will select from the dropdown using Index
      * @param element
      * @param index
      */
     public void select(WebElement element,int index) {
    	 Select sel=new Select(element);
    	 sel.selectByIndex(index);
     }
     /**
      * this method will do mouse over action on webelement
      * @param element
      * @param driver
      */
     public void mouseover(WebDriver driver,WebElement element) {
    	 Actions act=new Actions(driver);
    	 act.moveToElement(element).perform();
    	 }
     /**
      * this method will perform right click on webelement
      */
     public void rightClick(WebDriver driver,WebElement element) {
    	 Actions act=new Actions(driver);
    	act.contextClick() .perform();
    	 
     }
     /**
      * this method will perform double click on webelement
      * @param driver
      * @param element
      */
     public void doubleClick(WebDriver driver,WebElement element) {
    	 Actions act=new Actions(driver);
    	act.doubleClick() .perform();
    	 
     }
     /**
      * this method will select accept on alert popup
      * @param driver
      */
     public void acceptAlert(WebDriver driver) {
    	 driver.switchTo().alert().accept();
     }
     
      /**
       * this method print the alert msg
       * @param driver
     * @return 
       */
     
     public String printalertmsg(WebDriver driver) {
    	 String popupname=driver.switchTo().alert().getText();
    	 System.out.println(popupname);
    	return popupname;
    	 
     }
     
     /**
      * this method will select dismiss option in alert popup
      * @param driver
      */
     public void dismissAlert(WebDriver driver) {
    	 driver.switchTo().alert().dismiss();
     }
     /**
      * this method will switch to frame wrt value
      * @param driver
      * @param index
      */
     public void switchToFrame(WebDriver driver,int index) {
    	 driver.switchTo().frame(index);
     }
     /**
      * this method will switch to frame wrt id
      * @param driver
      * @param Frameid
      */
     
     public void switchToFrame(WebDriver driver,String Frameid) {
    	 driver.switchTo().frame(Frameid);
     }
     /**
      * this method will switch to frame wrt element
      * @param driver
      * @param Frameid
      */
     
     public void switchToFrame(WebDriver driver,WebElement Frameelement) {
    	 driver.switchTo().frame(Frameelement);
     }
     /**
      * this method will switch to window wrt to partial window title
      * @param driver
      * @param Frameid
      */
     
     public void switchToWindow(WebDriver driver,String partalwindotitle) {
    	Set<String> windohandels = driver.getWindowHandles();
    	Iterator<String> it = windohandels.iterator();
    	while(it.hasNext()) {
    		String winid=it.next();
    		String acttitle=driver.switchTo().window(winid).getTitle();
    		
    		if(acttitle.contains(partalwindotitle)) {
    		//driver.switchTo().window(acttitle);
    		break;
    		}
    	}	
     }
     /**
      * this method will wait for element to be visible
      */
     public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
    	 WebDriverWait wait=new WebDriverWait(driver,20);
    	 wait.until(ExpectedConditions.visibilityOf(element));
    	 
     }
}



























