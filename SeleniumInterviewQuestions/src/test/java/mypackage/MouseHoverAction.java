package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverAction {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 driver.manage().window().maximize();
		 
		WebElement mouseHover =   driver.findElement(By.xpath("//button[@id='mousehover']"));
		WebElement top =   driver.findElement(By.xpath("//a[normalize-space()='Top']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(mouseHover).moveToElement(top).click().perform();
		

	}

}
