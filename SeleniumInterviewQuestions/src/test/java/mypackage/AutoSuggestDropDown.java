package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("in");
		Thread.sleep(5000);
		List<WebElement>countries = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		
		for(WebElement country : countries ) 
		{
			if(country.getText().trim().equalsIgnoreCase("India")) 
			{
				country.click();
				break;
			}
		}
	
	}

}
