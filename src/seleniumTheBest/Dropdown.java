package seleniumTheBest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Dasha's projects\\Crome_driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		WebElement forShowElement = driver.findElement(By.xpath("//div[@id='divpaxinfo'] //div[@class='passengers-wrap2']"));
		
		driver.get("https://www.spicejet.com/");
		Thread.sleep(500);
		WebElement forShowElement = driver.findElement(By.xpath("//div[@id='flightSearchContainer'] //div[@class='row1 adult-infant-child'] //div[@id='divpaxinfo']"));
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(500);
		driver.findElement(By.id("ctl00_mainContent_ddl_Adult")).click();
		Thread.sleep(500);
		System.out.println("Should be 5:");
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_Adult > option:nth-child(5)")).click();
		Thread.sleep(500);

		System.out.println(forShowElement.getText());
		Thread.sleep(500);
//		driver.findElement(By.id("divpaxinfo")).click();
//		Select s = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));

		
		WebElement findElement = driver.findElement(By.xpath("//div[@class='passengers-wrap2'] //select[@name='ctl00$mainContent$ddl_Adult']"));
		findElement.click();
		System.out.println("Click to choose adalts");
		Select s = new Select(findElement);
		
//		Thread.sleep(4000);
//		System.out.println("Should be 2:");
//		s.selectByValue("2");
		Thread.sleep(2000);
		System.out.println("Index = 5; adults = 6:");
		s.selectByIndex(5);
		System.out.println(forShowElement.getText());
//		driver.findElement(By.xpath("//div[@class='passengers-wrap2'] //select[@name='ctl00$mainContent$ddl_Adult']")).click();
		Thread.sleep(2000);
		System.out.println("Should be 4:");
		driver.findElement(By.xpath("//div[@class='passengers-wrap2'] //select[@name='ctl00$mainContent$ddl_Adult'] //option[@value='4']")).click();
		System.out.println(forShowElement.getText());
//		s.selectByVisibleText("9");
		
		
//		driver.findElement(By.xpath("//div[@class='left1']/input")).click(); //also works
//		driver.findElement(By.xpath("//div[@class='left1'] //input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();//parent-child relationship
//		driver.findElement(By.xpath("//a[@value='BLR']")).click();
//		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		

}}
