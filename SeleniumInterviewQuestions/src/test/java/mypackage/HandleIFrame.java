package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleIFrame {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().maximize();
		
		System.out.println(driver.findElements(By.tagName("iFrame")).size());
		driver.switchTo().frame("packageListFrame");
	   driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium']")).click();
	   driver.switchTo().defaultContent();
	   Thread.sleep(3000);
		
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//span[normalize-space()='WebDriver']")).click();
		 driver.switchTo().defaultContent();
		 Thread.sleep(3000);
		
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//div[@class='topNav']//a[normalize-space()='Help']")).click();
		
		

	}

}
