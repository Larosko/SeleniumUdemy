package seleniumTheBest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Dasha's projects\\Crome_driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
////		System.out.println(driver.getPageSource());
//		driver.get("https://www.yahoo.com");
//		driver.wait(2000);
//		driver.navigate().back();
//		driver.get("https://www.yahoo.com");

	}

}
