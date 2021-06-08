package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusofWebElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		WebElement searchstore = driver.findElement(By.xpath(" //input[@id='small-searchterms']"));
        System.out.println(searchstore.isDisplayed());
        System.out.println(searchstore.isEnabled());
        
        WebElement male = driver.findElement(By.xpath(" //input[@id='gender-male']"));
        System.out.println(male.isSelected());
        
        WebElement female= driver.findElement(By.xpath("//input[@id='gender-female']"));
        System.out.println(female.isSelected());
        
        male.click();
        System.out.println(male.isSelected());
        female.click();
        System.out.println(female.isSelected());

	}

}
