package seleniumTheBest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Dasha
 * 
 */
public class AssignmentTwo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		Thread.sleep(2000);
		WebElement fromTag = driver.findElement(By.id("FromTag"));
		fromTag.click();
		fromTag.sendKeys("new");
		Thread.sleep(4000);
		fromTag.sendKeys(Keys.ARROW_DOWN);
		fromTag.sendKeys(Keys.ENTER);

		WebElement departDate = driver.findElement(By.id("DepartDate"));
		departDate.click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

		WebElement findElementAdults = driver.findElement(By.xpath("//select[@id='Adults']"));
		findElementAdults.click();
		Select s = new Select(findElementAdults);
		s.selectByIndex(5);

		WebElement findElementChildrens = driver.findElement(By.xpath("//select[@id='Childrens']"));
		findElementChildrens.click();
		Select s2 = new Select(findElementChildrens);
		s2.selectByValue("2");

		driver.findElement(By.xpath("//div[@id='MoreOptionsDiv'] //a[@id='MoreOptionsLink']")).click();
		WebElement findElementAirline = driver.findElement(By.xpath("//input[@id='AirlineAutocomplete']"));
		findElementAirline.sendKeys("indigo");
		findElementAirline.sendKeys(Keys.ENTER);

		driver.findElement(By.id("SearchBtn")).click();

		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());

	}

}
