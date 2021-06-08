package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.opencart.com/index.php?route=account/register");
		WebElement drpCountryele = driver.findElement(By.id("input-country"));
		Select drpCountry= new Select(drpCountryele);
		//drpCountry.selectByValue("4");
		//drpCountry.selectByVisibleText("Australia");
		//drpCountry.selectByIndex(31);
		
		List<WebElement>options = drpCountry.getOptions();
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase("Australia")) {
				option.click();
				break;
			}
			
				
		}
		
		

	}

}
