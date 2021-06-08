package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InnerIFrame {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.get("http://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		
		/*driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']")).click();
		WebElement outerFrame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(outerFrame);
		
		WebElement innerFrame = driver.findElement(By.cssSelector("iframe[src='SingleFrame.html']"));
		driver.switchTo().frame(innerFrame);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Success");
		
		driver.switchTo().defaultContent();*/
		
		
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		driver.switchTo().frame("iframeResult");//switch to outer iframe
		driver.switchTo().frame(0);//switch to inner iframe
		System.out.println(driver.findElement(By.xpath("//h1")).getText());
		
		driver.switchTo().parentFrame();//switch to outer iframe
		String text =driver.findElement(By.xpath("//p[contains(text(),'You can use the height and width attributes to spe')]")).getText();
		System.out.println(text);
		driver.switchTo().defaultContent();
		
		
		
		
		
		
		
		
		
		
	}

}
