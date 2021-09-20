package Practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RemoteExecution {
	
	@Test
	public void remoteExecutioTest() throws MalformedURLException {
		
		URL url=new URL("http://192.168.43.79:4444/wd/hub");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		RemoteWebDriver driver= new RemoteWebDriver(url, cap);
		driver.get("http://gmail.com");
		
	}

}
