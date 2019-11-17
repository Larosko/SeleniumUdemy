package section_9_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//		WebDriverWait w = new WebDriverWait(driver, 5);
		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
		driver.findElement(By.xpath("//a[text()='Click to load get data via Ajax!']")).click();

		new WebDriverWait(driver, 5)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id ='results']")));

		System.out.println(driver.findElement(By.xpath("//div[@id ='results']")).getText());
	}
}
