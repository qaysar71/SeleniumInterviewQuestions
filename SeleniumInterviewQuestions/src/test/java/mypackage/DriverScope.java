package mypackage;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverScope {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		int totalLinks = driver.findElements(By.tagName("a")).size();
		System.out.println("Page links" + "   " + totalLinks);

		WebElement footerdriver = driver.findElement(By.id("navLinks"));
		int footerLinks = footerdriver.findElements(By.tagName("a")).size();
		System.out.println("Footer links" + "    " + footerLinks);

		WebElement coloumndriver = footerdriver.findElement(By.cssSelector(".footer-section"));
		int coloumnlinks = coloumndriver.findElements(By.tagName("a")).size();
		System.out.println("Coloumn links" + "   " + coloumnlinks);

		/*
		 * for(int i=1; i<coloumnlinks; i++) { String clickonlink =
		 * String clickonlink = Keys.chord(Keys.COMMAND, Keys.ENTER);
		 * coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);
		 * 
		 * }
		 */
	

		List<WebElement> tabLinks = driver.findElements(By.cssSelector(".nav-links div:nth-child(1)"));
		for (WebElement tabLink : tabLinks) {
			String clickonlink = Keys.chord(Keys.COMMAND, Keys.ENTER);
			tabLink.sendKeys(clickonlink);

			Set<String> abc = driver.getWindowHandles();
			Iterator<String> it = abc.iterator();

			while (it.hasNext()) {

				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());

			}

		}

		driver.quit();

	}

}
