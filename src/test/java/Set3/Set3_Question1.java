package Set3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set3_Question1 extends TestBase{
	
	@BeforeMethod
	public void setup()
	{
		init("chrome", "https://jqueryui.com/checkboxradio/");
	}
	
	@Test
	public void test() throws Exception
	{
		WebElement iframe=d.findElement(By.xpath("//iframe[@class='demo-frame']"));
		d.switchTo().frame(iframe);
		WebElement radio=d.findElement(By.xpath("//label[@for='radio-2']"));
		if(radio.isSelected())
			System.out.println("Paris radio btn is already selected");
		else
		{
			radio.click();
			System.out.println("Paris radio btn is now selected");
			
		}
		
		List<WebElement> l1=d.findElements(By.xpath("//span[@class='ui-checkboxradio-icon-space']"));
		
		for (int i=3; i<11;i++)
		{
			l1.get(i).click();
		}
		
		System.out.println("All checkboxes are selected successfully");
		
		Thread.sleep(3000);
		takeScreenShotTip("Set3_Question1", "checkboxradio");
	}
	
	@AfterMethod
	public void method2()
	{
		terminate();
	}

}
