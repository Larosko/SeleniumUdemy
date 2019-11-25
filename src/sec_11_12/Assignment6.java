package sec_11_12;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment6 {
	public static void main(String[] args) {
		WebDriver driver = setCromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		checkBox(driver);
	}

	private static WebDriver setCromeDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	private static void checkBox(WebDriver driver) {
		WebElement option =driver.findElement(By.id("checkBoxOption2"));
		option.click();
		String textOption = driver.findElement(By.xpath("//label[@for='benz']")).getText();		
		System.out.println(textOption);
		
		driver.findElement(By.id("dropdown-class-example")).click();
		//option[contains(text(),'Option2')]
//		String xpathToFind = ("\"//option[contains(text()='" + textOption + "')]\"");
		String xpathToFind = ("//*[text()[contains(.,'" + textOption + "')]]");
		System.out.println(xpathToFind);
//		System.out.println("\"//option[contains(text(),'Option2')]\"");
//		WebElement selectOption = driver.findElement(By.xpath("//*[text()[contains(.,'Option2')]]"));             //+
//		WebElement selectOption = driver.findElement(By.xpath("//option[contains(text(),'Option2')]"));           //+
//		WebElement selectOption = driver.findElement(By.xpath("//*[text()[contains(.,'" + textOption + "')]]"));  //+
		WebElement selectOption = driver.findElement(By.xpath(xpathToFind));
		selectOption.click();
		driver.findElement(By.id("name")).sendKeys(textOption);
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		String alert = driver.switchTo().alert().getText();
		System.out.println(alert.contains(textOption));
		
	}

}
