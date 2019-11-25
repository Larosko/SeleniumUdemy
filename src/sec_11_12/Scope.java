package sec_11_12;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scope {
	public static void main(String[] args) {
		WebDriver driver = setCromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		coutLinks(driver);
	}

	private static WebDriver setCromeDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	private static void coutLinks(WebDriver driver) {
		// Count all links; then count some links only in last first column
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerElement = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerElement.findElements(By.tagName("a")).size());
		WebElement firstColomn = driver.findElement(By.xpath("//td[1]//ul[1]"));
		int column1 = firstColomn.findElements(By.tagName("a")).size();
		System.out.println(column1);

		for (int i = 1; i < column1; i++) {
			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			firstColomn.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			// open each link
		}
		// go through each window and get title
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> openWindows = allWindows.iterator();
		while (openWindows.hasNext()) {
			driver.switchTo().window(openWindows.next());
			System.out.println(driver.getTitle());

		}
	}
}
