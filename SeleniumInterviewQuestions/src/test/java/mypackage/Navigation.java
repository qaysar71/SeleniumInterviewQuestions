package mypackage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigation {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.snapdeal.com");
		
        driver.navigate().to("http://www.amazon.com");
		driver.navigate().back();//snapdeal
		driver.navigate().forward();//amazon
		driver.navigate().refresh();//reload the page 

	}

}
