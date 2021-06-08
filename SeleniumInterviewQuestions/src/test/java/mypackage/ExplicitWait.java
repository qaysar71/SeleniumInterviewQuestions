package mypackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
	   
		By elelocator = By.xpath(" //h3[contains(text(),'Selenium Webdriver Tutorial with Examples | Browse')]");
		waitForElementPresent(driver,elelocator,10 ).click();
	
	}
	
	public static WebElement waitForElementPresent(WebDriver driver, By locator, int timeout) 
	{
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(timeout));
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				return driver.findElement(locator);
	}

}
