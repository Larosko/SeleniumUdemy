package sec_13_14;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HiddenText {
	public static void main(String[] args) {
		WebDriver driver = setCromeDriver();
		driver.get("https://ksrtc.in/oprs-web/guest/home.do");
		driver.findElement(By.id("fromPlaceName")).sendKeys("ben");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return document.getElementById(\"fromPlaceName\").value;";
		String text = (String) js.executeScript(script);
		int i = 0;

//		while (!text.contains("airport")) {
		while (!text.equalsIgnoreCase("CHIKKALSANDRA BENGALURU")) {
			i++;
			System.out.println(text);
			driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
			text = (String) js.executeScript(script);
			if(i>10) {
				break;
			}
		}
//		driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.ENTER);
//		System.out.println(driver.findElement(By.id("fromPlaceName")).getText());

	}

	private static WebDriver setCromeDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}
