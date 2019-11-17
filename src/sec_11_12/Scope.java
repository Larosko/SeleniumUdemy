package sec_11_12;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scope {
	public static void main(String[] args) {
		WebDriver driver = setCromeDriver();
		driver.get("https://the-internet.herokuapp.com");
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
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerElement = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerElement.findElements(By.tagName("a")).size());
		
		
		driver.switchTo().frame(0);
		System.out.println(driver.findElements(By.tagName("frame")).size());
		driver.switchTo().frame(1);
		System.out.println(driver.findElement(By.id("content")).getText());
	}

}
