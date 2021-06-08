package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementvsFindElements {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		searchbox.sendKeys("xyz");
		
	    WebElement ele = driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
	    System.out.println(ele.getText());
	    
	    List<WebElement> links = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
	    System.out.println(links.size());
	    for(WebElement link : links) {
	    	System.out.println(link.getText());
	    }
	    	
	    
	    

	
		
		
	}

}
