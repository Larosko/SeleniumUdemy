package seleniumTheBest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "C:\\Dasha's projects\\fireFox_driver\\geckodriver.exe");
//		System.setProperty("webdriver.chrome.driver", "C:\\Dasha's projects\\Crome_driver\\chromedriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.rediff.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.cssSelector("a[title*='Sign in']")).click();;
		
		driver.findElement(By.xpath("//input[contains(@id,'login')]")).sendKeys("abrakadabra");
	}

}
