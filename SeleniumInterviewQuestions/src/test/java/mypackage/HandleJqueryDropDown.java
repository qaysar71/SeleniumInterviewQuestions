package mypackage;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleJqueryDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		driver.get("https:www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();
	    selctChoiceVaalues( driver, "choice 1") ;
		selctChoiceVaalues( driver, "choice 2", "choice 2 3", "choice 6", "choice 6 2 1", "choice 6 2") ;
		selctChoiceVaalues( driver, "all") ;

	}
    public static void selctChoiceVaalues(WebDriver driver, String...value) 
    {
    	List<WebElement>choiceList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
    	if(!value[0].equalsIgnoreCase("all")) 
    	{
    		for(WebElement item :choiceList ) 
    		{
    			String text =item.getText();
    			for(String val : value) 
    			{
    				if(text.equals(val)) 
    				{
    					item.click();
    					break;
    				}
    			}
    					
    		}
    	}
    	else 
    	{   try 
    	{
    		for(WebElement item :choiceList) 
    		{
    			item.click();
    		}
    	}
    	catch(Exception e) 
    	{
    		
    	}
    		
    	}
    }
	
}
