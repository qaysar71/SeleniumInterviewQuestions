package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		int rows = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr ")) .size(); 
		System.out.println(rows);
		
		int columns = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr/th ")) .size(); 
		System.out.println(columns );
		
	    String value = driver.findElement(By.xpath("//table[@class='table-display']//tr[2]/td[1]")).getText();
	    System.out.println("The value is"+ "    " +  value);
	    
	    for(int r=2; r<=rows; r++) 
	    {
	    	for(int c=1; c<=columns;c++) 
	    	{
	    		String allData = driver.findElement(By.xpath("//table[@class='table-display']//tr["+r+"]/td["+c+"]")).getText();
	    		System.out.println(allData);
	    	}
	    	System.out.println();
	    }
	    
	    for(int r=2; r<=rows; r++) 
	    {
	    	String Instructorname= driver.findElement(By.xpath("//table[@class='table-display']//tr["+r+"]/td[1]")).getText();
	    	if(Instructorname.equals("Rahul Shetty"))
	    	{
	    		String Course= driver.findElement(By.xpath("//table[@class='table-display']//tr["+r+"]/td[2]")).getText();
	    		String Price= driver.findElement(By.xpath("//table[@class='table-display']//tr["+r+"]/td[3]")).getText();
	    		System.out.println(Instructorname + "     " + Course + "      " +Price);
	    	}
	    }
	  
	  List<WebElement>price = driver.findElements(By.xpath("//table[@class='table-display']//tr/td[3]")) ; 
	  int sum = 0;
	  for(WebElement value1:price ) 
	  {
		  sum =sum + Integer.parseInt(value1.getText());  
		   //..table-display td:nth-child(3) //div[@class='left-align']//td[3]
	  }
	    
	  System.out.println(sum); 
	    
	}
	
}
