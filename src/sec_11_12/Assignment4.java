package sec_11_12;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Dasha
 * maven + WebDriverManager
 */
public class Assignment4 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
		handleMultipleWindows(driver);
	}

	private static void handleMultipleWindows(WebDriver driver) {
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
		String text1 = driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText();
		System.out.println("First window:");
		System.out.println(text1);
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		Set<String> myIds = driver.getWindowHandles();
		Iterator<String> it = myIds.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		String text2 = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText();
		System.out.println("Opening new window:");
		System.out.println(text2);
		driver.switchTo().window(parentId);
		System.out.println("Again first window:");
		System.out.println(text1);
	}
}
