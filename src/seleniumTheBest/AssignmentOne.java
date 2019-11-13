package seleniumTheBest;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Dasha
 * 
 */

public class AssignmentOne {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://qaclickacademy.com/practice.php");
		Thread.sleep(2000);
//		WebElement checkBox = driver.findElement(By.id("checkBoxOption1"));
//
//		System.out.println(checkBox.isSelected());
//		checkBox.click();
//		System.out.println(checkBox.isSelected());

		// how many check boxes?
		List<WebElement> checkboxList = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(checkboxList.size() + " check boxes present in the page");
	}
}
