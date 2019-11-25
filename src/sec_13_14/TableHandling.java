package sec_13_14;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableHandling {
	public static void main(String[] args) {
		int sum = 0;
		WebDriver driver = setCromeDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/23938/paku23-vs-indu23-1st-semi-final-acc-emerging-teams-asia-cup-2019");
		WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		List<WebElement> firstCol = table.findElements(By.cssSelector("div[class='cb-col cb-col-8 text-right text-bold']"));
		int count = firstCol.size();
		System.out.println("Rows in  column " + count);
		for (int i = 1; i < count; i++) {
			String num = firstCol.get(i).getText();
			int value = Integer.parseInt(num);
			sum = sum+value;
			
		}
		System.out.println(sum);
		int extras = Integer.parseInt(table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText());
		sum = sum+extras;
		int total = Integer.parseInt(table.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText());
		
		if (sum==total) {
			System.out.println("Sum " + sum +" is the same as total " + total);
		}else {
			System.out.println("Sum" + sum +" doesn't mutch total" + total);
		}

	}
	
	private static WebDriver setCromeDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

}
