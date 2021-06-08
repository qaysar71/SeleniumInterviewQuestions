package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatticWebTable1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();

		// how many rows in table
		int rows = driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr")).size();
		System.out.println(rows);

		// how many colomns in table
		int columns = driver.findElements(By.xpath("//table[@class='data-list']/thead/tr/th")).size();
		System.out.println(columns);

		// Retrieve the specific row/column data
		String value = driver.findElement(By.xpath("//table[@class='data-list']//tr[2]/td[1]")).getText();
		System.out.println("The value is" + value);

		// Retrieve all data from the table
		for (int r = 1; r <= rows; r++) {
			for (int c = 1; c <= columns; c++) {
				String data = driver.findElement(By.xpath("//table[@class='data-list']//tr[" + r + "]/td[" + c + "]"))
						.getText();

				System.out.println(data + "      ");
			}
			System.out.println();
		}

		// print release Date, VersionNo of Java Language of selenium
		for (int r = 1; r <= rows; r++) {
			String language = driver.findElement(By.xpath("//table[@class='data-list']//tr[" + r + "]/td[1]"))
					.getText();
			if (language.equals("Java")) {
				String versionNo = driver.findElement(By.xpath("//table[@class='data-list']//tr[" + r + "]/td[2]"))
						.getText();
				String releasedate = driver.findElement(By.xpath("//table[@class='data-list']//tr[" + r + "]/td[3]"))
						.getText();
				System.out.println(language + "     " + versionNo + "      " + releasedate);
			}
		}

	}

}
