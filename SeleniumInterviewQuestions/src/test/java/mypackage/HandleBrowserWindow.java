package mypackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindow {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		//getWindowHamdle()
		
		//String windowID= driver.getWindowHandle();
		//System.out.println(windowID); 
		
		//getWindowHamdles()
		
		 driver.findElement(By.xpath("//button[@id='openwindow']")).click();
		 
		 Set<String>windowIDs=driver.getWindowHandles();
		
		 // First method - iterator
		 
		/* Iterator<String> it = windowIDs.iterator();
		String parentWindowID = it.next();
		String childWindowID=it.next();
		System.out.println("Parent window ID :"+parentWindowID);
		System.out.println("Child window ID :"+childWindowID);*/
		
		//Second method - List/ArrayList
		
		List<String>winIDsList = new ArrayList(windowIDs);
	
		/*String parentWindowID =winIDsList.get(0);
		String childWindowID = winIDsList.get(1);
		System.out.println("Parent window ID :"+parentWindowID);
		System.out.println("Child window ID :"+childWindowID);
		
		// How to use window ID for switch
		
		driver.switchTo().window(parentWindowID);
		System.out.println("Parent window title :"+driver.getTitle());
		
		driver.switchTo().window(childWindowID);
		System.out.println("Child window title :"+driver.getTitle());*/
		
		//For each loop
		
		/*for(String winID :winIDsList) 
		{
			String title = driver.switchTo().window(winID ).getTitle();
			System.out.println(title);
			
			
		}*/
	
		//driver.close();// close single browser window which driver pointing
		//driver.quit();// close all the browser windows
		for(String winID :winIDsList) 
		{
			String title = driver.switchTo().window(winID ).getTitle();
			if(title.equals("Practice Page")) 
			{
				driver.close();
			}
			
			
		}
		 
		 

	}

}
