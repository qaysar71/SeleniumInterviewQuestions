package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDropDownWithGenericMethod {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com");
		driver.manage().window().maximize();
		
		 driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();
		List <WebElement> productTypes  = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
	
		selectzOptionFromDropDown( productTypes, "Accounts");
		
		
		driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click();
		List <WebElement> products = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']/li"));
	
		selectzOptionFromDropDown( products, "Savings Accounts");
		

	}
   public static void selectzOptionFromDropDown(List<WebElement>options, String value) 
   {
	   for(WebElement option : options) 
		{
			if(option.getText().equals(value)) 
			{
				option.click();
				break;
			}
		}
   }
}
