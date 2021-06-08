package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextvsGetAttributeValue {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login/");
		WebElement emailinputbox = driver.findElement(By.id("Email"));
		emailinputbox.clear();
		emailinputbox.sendKeys("Admin123@gmail.com");
		System.out.println(emailinputbox.getAttribute("value"));
		
		WebElement loginbutton = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
		System.out.println(loginbutton.getAttribute("type"));
		System.out.println(loginbutton.getAttribute("class"));
		System.out.println(loginbutton.getText());
		
		String title = driver.findElement(By.xpath("//div[@class='page-title']//h1")).getText();
		System.out.println(title);
		
	
		

	}

}
