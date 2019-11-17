package sec_11_12;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rozetka.com.ua/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//		driver.findElement(By.xpath("//input[@class='lang-switcher-popup-close novisited']")).click();
		driver.switchTo().alert().dismiss();
		Actions a = new Actions(driver);
//		a.moveToElement(driver.findElement(By.xpath("//a[@data-title='Бытовая техника']"))).build().perform();
		a.moveToElement(driver.findElement(By.xpath("//input[@class='rz-header-search-input-text passive']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
	}

}
