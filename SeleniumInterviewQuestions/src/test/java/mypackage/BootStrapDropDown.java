package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com");
		driver.manage().window().maximize();
		
		 driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();
		List <WebElement> product_types  = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
		System.out.println(product_types.size());
		for(WebElement product_type : product_types) 
		{
			if(product_type.getText().equals("Loans")) 
			{
				product_type.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click();
		List <WebElement> products = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']/li"));
		System.out.println(products.size());
		for(WebElement product : products) 
		{
			if(product.getText().equals("Personal Loan")) 
			{
				product.click();
				break;
			}
		}
		

	}

}
