package sec_13_14;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment8 {
	public static void main(String[] args) {
		WebDriver driver = setCromeDriver();
		driver.get("http://qaclickacademy.com/practice.php#");
		
		driver.findElement(By.id("autocomplete")).sendKeys("uni");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String script = "return document.getElementById(\"autocomplete\").value;";
		String text = (String) js.executeScript(script);
		int i=0;
		String country = "United Kingdom";
		
		while(!text.equalsIgnoreCase(country)) {
			driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.DOWN);
			text = (String) js.executeScript(script);
			System.out.println(text);
			if(text.equalsIgnoreCase(country)) {
				break;
			}
			i++;
			if(i>10) {
				System.out.println("Element not found");
				break;
			}
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
