package sec_11_12;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/intl/ru/gmail/about/#");
		driver.findElement(By.xpath("//a[@class='h-c-button h-c-header__cta-li-link h-c-header__cta-li-link--primary']")).click();
		System.out.println("First window");
		System.out.println(driver.getTitle());
		Set<String> myIds = driver.getWindowHandles();
		Iterator<String> it = myIds.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println("Second window");
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentId);
		System.out.println("Again first window");
		System.out.println(driver.getTitle());
		
		
		
		
		
	}
}
