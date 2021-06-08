package mypackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTableWithPagination {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();

		// Login
		WebElement username = driver.findElement(By.id("input-username"));
		username.clear();
		username.sendKeys("demo");

		WebElement password = driver.findElement(By.id("input-password"));
		password.clear();
		password.sendKeys("demo");

		driver.findElement(By.xpath("//div[@class='text-right']/button")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();

		// Table
		// 1. Find Total numbers of pages in Table

		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
		System.out.println(text);

		int total_pages = Integer.valueOf(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));
		System.out.println(total_pages);// Showing 1 to 20 of 9012 (451 Pages)
		// text.indexOf("(");
		// text.indexOf("Pages");

		// 2. Find How Many Rows Exists in Each Page in Table

		for (int p = 1; p <= 5; p++) {
			WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//li/span"));
			System.out.println("Active page" + active_page.getText());
			active_page.click();

			int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr"))
					.size();
			System.out.println("Number of rows" + rows);

			// 3. Read all the rows data from each page

			for (int r =1; r<=rows; r++) {
					String orderId=driver
						.findElement(
								By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr[+r+]/td[3]"))
						.getText();
				
				String customerName = driver
						.findElement(
								By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr[+r+]/td[3]"))
						.getText();
				String status = driver
						.findElement(
								By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr[+r+]/td[4]"))
						.getText();
				
				if(status.equals("Pending")) {
					System.out.println(orderId+"    " +customerName + "   " + status);
				}
				
			}

			String pageno = Integer.toString(p + 1);

			driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()=" + pageno + "]")).click();
			
			

		}

	}

}
