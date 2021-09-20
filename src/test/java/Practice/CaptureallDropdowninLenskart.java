package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureallDropdowninLenskart {
	
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", 
            "E:\\ocsm 14 -automation\\chromedriver\\Chromedriver.exe");
     WebDriver driver=new ChromeDriver();
     driver.get("https://www.lenskart.com/");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     
     driver.findElement(By.name("q")).click();
     
     List<WebElement> getallsuggetion=driver.findElements(By.xpath("//ul[@class='trending_list menu-link']/li"));
     for(WebElement wb:getallsuggetion) {
    	 System.out.println(wb.getText());
     }
     
  
	}

}
