package sec_13_14;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment7 {
	public static void main(String[] args) {
		WebDriver driver = setCromeDriver();
		driver.get("http://qaclickacademy.com/practice.php#");
		
		WebElement table = driver.findElement(By.xpath("//table[@id='product']"));
		int rows = table.findElements(By.tagName("tr")).size();
		System.out.println("Row nums " + rows);
		WebElement secondRow = table.findElement(By.xpath("//tr[3]"));
		List<WebElement> readSecondRow = secondRow.findElements(By.tagName("td"));
		int columns = readSecondRow.size();
		System.out.println("Column nums " + columns);
		for (int i = 0; i < columns; i++) {
			System.out.println(secondRow.findElements(By.tagName("td")).get(i).getText());
		}
	}

	private static WebDriver setCromeDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}

//Output:
//Row nums 11
//Column nums 3
//Rahul Shetty
//Learn SQL in Practical + Database Testing from Scratch
//25
