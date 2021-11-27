package Oct_2019;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.JavaScriptExecutor_Methods;
import com.testing.base.TestBase;

import pageObjects.Oct_2019_POM;

public class Question3 extends TestBase {

	JavaScriptExecutor_Methods js = new JavaScriptExecutor_Methods();
	Oct_2019_POM obj = new Oct_2019_POM();

	@BeforeMethod
	public void initiateDriver() throws InterruptedException {
		init("Chrome", "https://www.ndtv.com/business");
	}

	@Test
	public void testCase1() throws Exception {
		checkPageReady();
		d.switchTo().frame(d.findElement(obj.iframe));
//		d.switchTo().frame(3);
//		d.switchTo().frame(2);
		
		/*
		 * waitForElementToVisible(d.findElement(obj.sensex));
		 * System.out.println("SENSEX: " + gettext(obj.sensex));
		 * waitForElementToVisible(d.findElement(obj.sensexchangepercentage)); String s
		 * = gettext(obj.sensexchangepercentage).substring(0, 6);
		 * System.out.println("SENSEX Change:" + s); String s1 =
		 * gettext(obj.sensexchangepercentage).substring(7, 11);
		 * System.out.println("SENSEX Percentage Change:" + s1);
		 */
		 

		/*
		 * waitForElementToVisible(d.findElement(obj.nifty));
		 * System.out.println("NIFTY: " + gettext(obj.nifty));
		 * waitForElementToVisible(d.findElement(obj.niftychangepercentage)); String s2
		 * = gettext(obj.sensexchangepercentage).substring(0, 6);
		 * System.out.println("NIFTY Change:" + s2); String s3 =
		 * gettext(obj.niftychangepercentage).substring(7, 11);
		 * System.out.println("NIFTY Percentage Change:" + s3);
		 */

//		d.switchTo().frame(d.findElement(By.xpath("//iframe[contains(@src,'marketdata')]")));

//		System.out.println("NIFTY: "
//				+ d.findElement(By.xpath("(//a[text()='NIFTY']/parent::td/following-sibling::td)[1]")).getText());
//		System.out.println("SENSEX: "
//				+ d.findElement(By.xpath("(//a[text()='SENSEX']/parent::td/following-sibling::td)[1]")).getText());
		
		
		
		List<WebElement> l1=d.findElements(By.xpath("//div[@class='market-indicator-right']//a/span[@class='clearfix']"));
		System.out.println(l1.size());
		for (int i=0;i<l1.size();i++)
		{
			waitForElementToVisible(l1.get(i));
			System.out.println(l1.get(i).getText());
		}
		  
		  

	}

	@AfterMethod
	public void AfterTest() {
		terminate();
	}
}