package sec_11_12;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frameTest {

	public static void main(String[] args) {
		WebDriver driver = setCromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		dragAndDrop(driver);
	}

	private static WebDriver setCromeDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	private static void dragAndDrop(WebDriver driver) {
//		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
//		driver.findElement(By.id("draggable")).click();
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
		
	}
}
