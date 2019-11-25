package sec_13_14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableSort {
	public static void main(String[] args) {
		WebDriver driver = setCromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<WebElement> originalTable = driver.findElements(By.cssSelector("tr td:nth-child(2)"));
//		driver.findElement(By.xpath("//b[contains(text(),'Veg/fruit name')]")).click();
//		driver.findElement(By.xpath("//b[contains(text(),'Veg/fruit name')]")).click();
		
		ArrayList<String> originalList = new ArrayList<String>();
		for (int i = 0; i < originalTable.size(); i++) {
			originalList.add(originalTable.get(i).getText());
		}
		
		
		ArrayList<String> copiedList = new ArrayList<String>();
		for (int i = 0; i < originalList.size(); i++) {
			copiedList.add(originalList.get(i));
		}
		Collections.sort(copiedList);
		System.out.println("******Copied and sorted******");
		for (String s:copiedList) {
			System.out.println(s);
			
		}
		System.out.println("*****Original******");
		for (String s:originalList) {
			System.out.println(s);
			
		}
		
		Assert.assertTrue(copiedList.equals(originalList));

		}

	
	
	private static WebDriver setCromeDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

}
