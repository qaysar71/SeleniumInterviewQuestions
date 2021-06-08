package mypackage;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {

	public static void main(String[] args) throws MalformedURLException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List<WebElement>links=driver.findElements(By.tagName("a"));
		int brokenLinks =0;
		
		for(WebElement element : links)
		{
			String url = element.getAttribute("href");
			
			if(url==null || url.isEmpty())
			{
				System.out.println("url is empty");
				continue;
			}
			URL link = new URL(url);
			
			try {
				
				HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
				httpconn.connect();
				if(httpconn.getResponseCode()>=400) 
				{
					System.out.println(httpconn.getResponseCode()+  url+"  is"+  "Broken link");
					brokenLinks++;
				}
				else 
				{
					System.out.println(httpconn.getResponseCode()+  url+"  is"+  "Valid link");
				}
				
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
			
			}
			System.out.println("Number of broken links"+   brokenLinks);
		}
		
	}

}
