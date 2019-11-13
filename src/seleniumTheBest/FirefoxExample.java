package seleniumTheBest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.rediff.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.cssSelector("a[title*='Sign in']")).click();;
		
		driver.findElement(By.xpath("//input[contains(@id,'login')]")).sendKeys("abrakadabra");
	}

}
