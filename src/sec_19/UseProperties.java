package sec_19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UseProperties {
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Dasha\\eclipse-workspace\\seleniumTheBest\\src\\sec_19\\myfile.properties");
		prop.load(fis);
		WebDriver driver = null;
		System.out.println(prop.getProperty("username"));
		if(prop.getProperty("browser").equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			
		}else if(prop.getProperty("browser").equals("chrome")){
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		driver.get(prop.getProperty("url"));
		
	}

}
