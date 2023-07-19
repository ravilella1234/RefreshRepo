package imagecomparasions;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ImageComparison 
{

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.vmware.com/in.html");
		
		BufferedImage expectedImage = ImageIO.read(new File("D:\\logos\\vmwarelogo.png"));
		WebElement logoImageElement = driver.findElement(By.xpath("//*[@id=\"nav-pzn\"]/header/div[1]/div[2]/div/div/div/div/div/nav/a[1]/picture/img"));
		Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImageElement);
		BufferedImage actualImage = logoImageScreenshot.getImage();
		
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);
		if(diff.hasDiff()==true)
			System.out.println("Images are not same.");
		else
			System.out.println("Images are same.");
	}

}
