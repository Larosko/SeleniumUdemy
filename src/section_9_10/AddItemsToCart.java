package section_9_10;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

public class AddItemsToCart {
	public static void main(String[] args)  {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, 5);
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String[] items = { "Brocolli", "Cucumber", "Onion", "Tomato" };
		addItems(driver, items);
		checkCart(driver, items, w);

	}

	public static void addItems(WebDriver driver, String[] items) {
		String name = null;
		System.out.println("I want to buy:");
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i]);
		}
		List<String> itemsNeededList = Arrays.asList(items);

		// all products on site:
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		// add to cart all my products
		for (int i = 0; i < products.size(); i++) {
			String myXpath = ("//div[@class='products']/div[" + (i + 1) + "]/div[3]/button[1]");
			name = products.get(i).getText();
			String[] splitName = name.split("-");
			String formatedName = splitName[0].trim();
			if (itemsNeededList.contains(formatedName)) {
				driver.findElement(By.xpath(myXpath)).click();

			}
		}
	}

	public static void checkCart(WebDriver driver, String[] items, WebDriverWait w) {
//				
			driver.findElement(By.cssSelector("img[alt='Cart']")).click();
			driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
			
			driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
			driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
			
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));
			
			System.out.println(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText());
			
			//div[@class='action-block']/button
//			PROCEED TO CHECKOUT
					}

}
