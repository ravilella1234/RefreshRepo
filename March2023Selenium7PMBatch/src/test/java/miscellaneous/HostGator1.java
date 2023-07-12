package miscellaneous;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HostGator1 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.hostgator.in/dedicated-servers-windows.php");
		WebElement element = driver.findElement(By.xpath("//div[@class='col-xs-12 col-sm-6 col-md-7 text-center']/a"));
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();",element);
		List<WebElement> prices = driver.findElements(By.cssSelector("div.selected-term span.term-price"));
		
		/*for(WebElement p:prices)
		{
			System.out.println(p.getText() +"--->"+ p.getText().getClass().getSimpleName());
		}*/
		
		int expensive = 0;
		int expensiveIndex = 0;
		
		for(int i=0;i<prices.size();i++)
		{
			System.out.println(prices.get(i).getText() +"--->"+prices.get(i).getText().getClass().getSimpleName());
			int price = Integer.parseInt(prices.get(i).getText().split(" ")[1].replace(",", ""));
			System.out.println(price +"--->"+((Object)price).getClass().getSimpleName());
			
			if(price>expensive)
			{
				expensive = price;
				expensiveIndex = i;
			}
			System.out.println(expensiveIndex);
			List<WebElement> buttons = driver.findElements(By.xpath("//button[@class='btn btn-info dropdown-toggle block-level shared hidden-xs']"));
			int y = buttons.get(expensiveIndex).getLocation().y;
			js.executeScript("window.scrollTo(0,"+(y-70)+")");
			buttons.get(expensiveIndex).click();
		}
		
	}

}
