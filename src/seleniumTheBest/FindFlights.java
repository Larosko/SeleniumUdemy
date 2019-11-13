package seleniumTheBest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindFlights {
	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(2000);

		// choose directions:
		driver.findElement(By.xpath("//div[@class='left1']/input")).click(); // also works
		driver.findElement(By.xpath("//div[@class='left1'] //input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"))
				.click();// parent-child relationship
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[contains(text(),'Bengaluru (BLR)')]")).click();
		driver.findElement(
				By.xpath("//div[@class='right1'] //input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']"))
				.click();
		
		Thread.sleep(500);
		driver.findElement(By.xpath(
				"//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[contains(text(),'Chennai (MAA)')]"))
				.click();

		// choose dates:
		WebElement depDate = driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active"));
		System.out.println(depDate.getText());
		depDate.click();

		WebElement forShowElement = driver.findElement(By.xpath(
				"//div[@id='flightSearchContainer'] //div[@class='row1 adult-infant-child'] //div[@id='divpaxinfo']"));
		Thread.sleep(500);
		System.out.println("Click to choose adults");
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(500);
		driver.findElement(By.id("ctl00_mainContent_ddl_Adult")).click();
		Thread.sleep(500);
		System.out.println("Should be 5:");
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_Adult > option:nth-child(5)")).click();
		Thread.sleep(500);
		System.out.println(forShowElement.getText());
		Thread.sleep(500);

		// use Select class:
		WebElement findElement = driver.findElement(
				By.xpath("//div[@class='passengers-wrap2'] //select[@name='ctl00$mainContent$ddl_Adult']"));
		findElement.click();
		Select s = new Select(findElement);

		// imitate changing amount of people; use different methods:
		Thread.sleep(500);
		System.out.println("Should be 2:");
		s.selectByValue("2");
		System.out.println(forShowElement.getText());
		Thread.sleep(500);
		System.out.println("Index = 5; adults = 6:");
		s.selectByIndex(5);
		System.out.println(forShowElement.getText());
		Thread.sleep(500);
		System.out.println("Should be 4:");
		driver.findElement(By.xpath(
				"//div[@class='passengers-wrap2'] //select[@name='ctl00$mainContent$ddl_Adult'] //option[@value='4']"))
				.click();
		System.out.println(forShowElement.getText());
		findElement.click();
		System.out.println("Should be 9:");
		s.selectByVisibleText("9");
		System.out.println(forShowElement.getText());

	}
}
