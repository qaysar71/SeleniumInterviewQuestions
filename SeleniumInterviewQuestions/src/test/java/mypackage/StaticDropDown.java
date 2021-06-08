package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticDropDown {
         
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice//");
       Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
      /* s.selectByValue("option1");
       s.selectByIndex(3);
       s.selectByVisibleText("Option2");*/
       
       List<WebElement>alloptions = s.getOptions();
		for(WebElement option :alloptions) 
		{
			if(option.getText().equals("Option1")) 
			{
				option.click();
				break;
			}
		}
	}

}
