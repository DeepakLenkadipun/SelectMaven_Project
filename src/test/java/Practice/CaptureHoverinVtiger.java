package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureHoverinVtiger {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
	            "E:\\ocsm 14 -automation\\chromedriver\\Chromedriver.exe");
	     WebDriver driver=new ChromeDriver();
	     driver.get("http://localhost:8888");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     
	     driver.findElement(By.name("user_name")).sendKeys("admin");
	     driver.findElement(By.name("user_password")).sendKeys("root"); 
	     driver.findElement(By.id("submitButton")).click(); 
	     driver.findElement(By.linkText("Organization")).click(); 
	     
	     WebElement createcontact=driver.findElement(By.xpath("//img[@title='Create Organization...']"));
	     
	     System.out.println(createcontact.getAttribute("title"));
	}
}
