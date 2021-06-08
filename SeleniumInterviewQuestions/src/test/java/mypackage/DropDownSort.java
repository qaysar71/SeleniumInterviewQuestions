package mypackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownSort {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://www.twoplugs.com/newsearchserviceneed");
		 driver.manage().window().maximize();
		 
		 driver.findElement(By.xpath("//div[text()='All']")).click();
		WebElement drpElement =  driver.findElement(By.xpath("//select[@name='category_id']"));
		Select drpselect = new Select(drpElement);
		List<WebElement>options =drpselect.getOptions();
		
		
		ArrayList originallist = new 	ArrayList();
		ArrayList templist = new 	ArrayList();
		
		for(WebElement option : options) 
		{
			originallist.add(option.getText());
		    templist.add(option.getText());
		}
		System.out.println("Original list" +originallist);
		System.out.println("Temp list" +templist);
		
		Collections.sort(templist);//sorting
		
		System.out.println("Original list" +originallist);
		System.out.println("Temp list After Sorting" +templist);
		
		if(originallist.equals(templist))
		{
			System.out.println("DropDown Sorted");
		}
		else
		{
			System.out.println("DropDown Not Sorted");
		}
	}

}
