package browserOptions;

import java.util.Collections;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptionsDemo 
{

	public static void main(String[] args) 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		//options.addArguments("--headless");
		options.addArguments("--disable-notifications");
		//options.addArguments("disable-infobars");
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.addArguments("--ignore-certificate-errors");
		//options.addArguments("--proxy-server=http://192.168.10.10:1947");
		options.addArguments("user-data-dir=C:\\Users\\ravi\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 5");
		//options.addArguments("--incognito");
		
		//WebDriver driver = WebDriverManager.chromedriver().capabilities(options).create();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		//driver.switchTo().newWindow(WindowType.WINDOW);
		//driver.get("https://www.hdfc.com/");
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}

}
