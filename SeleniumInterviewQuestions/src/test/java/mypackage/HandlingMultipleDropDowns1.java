package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingMultipleDropDowns1 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath(" //a[normalize-space()='Create New Account']")).click();
		;
		Thread.sleep(5000);

		WebElement day_drp = driver.findElement(By.xpath(" //select[@id='day']"));
		day_drp.click();
		SelectoptionFromDropDown(day_drp, "12");
		Thread.sleep(5000);

		WebElement month_drp = driver.findElement(By.xpath(" //select[@id='month']"));
		month_drp.click();
		SelectoptionFromDropDown(month_drp, "May");
		Thread.sleep(5000);

		WebElement year_drp = driver.findElement(By.xpath(" //select[@id='year']"));
		year_drp.click();
		SelectoptionFromDropDown(year_drp, "2020");

	}

	public static void SelectoptionFromDropDown(WebElement ele, String value) {
		Select drp = new Select(ele);
		List<WebElement> alloptions = drp.getOptions();
		for (WebElement option : alloptions) {
			if (option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

}
