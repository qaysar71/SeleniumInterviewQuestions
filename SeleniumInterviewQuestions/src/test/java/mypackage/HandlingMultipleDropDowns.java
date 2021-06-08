package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingMultipleDropDowns {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		WebElement noofEmpsele = driver.findElement(By.name("NoOfEmployees"));
		selectOptionFromDropDown(noofEmpsele, "16 - 20");
	
		WebElement industryele = driver.findElement(By.name("Industry"));
		selectOptionFromDropDown(industryele, "Healthcare");
	
		WebElement countryele = driver.findElement(By.name("Country"));
		selectOptionFromDropDown(countryele, "Australia");
		

	}
	public static void selectOptionFromDropDown(WebElement ele, String value) {
		Select drp = new Select(ele);
		List<WebElement>alloptions = drp.getOptions();
		for(WebElement option : alloptions) 
		{
			if(option.getText().equals(value)) 
			{
				option.click();
				break;
		
	}

}
	}
}
	
