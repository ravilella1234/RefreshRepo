package miscellaneous;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HostGator 
{

	public static void main(String[] args) 
	{
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hostgator.in/dedicated-servers-windows.php");
		WebElement element = driver.findElement(By.xpath("//div[@class='col-xs-12 col-sm-6 col-md-7 text-center']/a"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
		List<WebElement> prices = driver.findElements(By.cssSelector("div.selected-term span.term-price"));
		int expensive =0;
		int expensiveindex =0;
		
		for(int i=0;i<prices.size();i++)
		{
			System.out.println(prices.get(i).getText());
			int price = Integer.parseInt(prices.get(i).getText().split(" ")[1].replace(",", ""));
			System.out.println(price);
			if(price>expensive)
			{
				expensive = price;
				expensiveindex = i;
			}
			System.out.println(expensiveindex);
			List<WebElement> buttons = driver.findElements(By.xpath("//button[@class='btn btn-info dropdown-toggle block-level shared hidden-xs']"));
			int y = buttons.get(expensiveindex).getLocation().y;
			js.executeScript("window.scrollTo(0,"+(y-70)+")");
			buttons.get(expensiveindex).click();
			List<WebElement> yearplan = driver.findElements(By.xpath("//form[@id='hostingplan_463_in']//div[@class='btn-group open']/ul/li/a/span[1]"));
			for(int j=0;j<yearplan.size();j++)
			{
				if(yearplan.get(j).getText().equals("6 Months"))
				{
					yearplan.get(j).click();
				}
			}
			
		}
	}

}
