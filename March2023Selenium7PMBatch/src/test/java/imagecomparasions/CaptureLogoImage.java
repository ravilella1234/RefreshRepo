package imagecomparasions;

import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class CaptureLogoImage 
{

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.vmware.com/in.html");
		WebElement logoImageElement = driver.findElement(By.xpath("//*[@id=\"nav-pzn\"]/header/div[1]/div[2]/div/div/div/div/div/nav/a[1]/picture/img"));
		Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImageElement);
		ImageIO.write(logoImageScreenshot.getImage(), "png", new File("D:\\logos\\vmwarelogo.png"));
		
		File f = new File("D:\\logos\\vmwarelogo.png");
		
		if(f.exists())
			System.out.println("image File Captured");
		else
			System.out.println("image File not Captured");
	}

}
