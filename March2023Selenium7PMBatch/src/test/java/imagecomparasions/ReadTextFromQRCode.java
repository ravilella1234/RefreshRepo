package imagecomparasions;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadTextFromQRCode 
{

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qrcode.tec-it.com/en");
		String qrcodeurl = driver.findElement(By.xpath("//*[@id=\"barcodeGeneratorForm\"]/div[7]/div[1]/img")).getAttribute("src");
		URL url = new URL(qrcodeurl);
		BufferedImage bufferedImage = ImageIO.read(url);
		LuminanceSource ls = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap bbm = new BinaryBitmap(new HybridBinarizer(ls));
		Result result = new MultiFormatReader().decode(bbm);
		System.out.println(result.getText());
	}

}
