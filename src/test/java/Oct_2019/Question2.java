package Oct_2019;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.JavaScriptExecutor_Methods;
import com.testing.base.TestBase;

import pageObjects.Oct_2019_POM;

public class Question2 extends TestBase{
	
	JavaScriptExecutor_Methods js=new JavaScriptExecutor_Methods();
	Oct_2019_POM obj = new Oct_2019_POM();
	
	@BeforeMethod
	public void initiateDriver() throws InterruptedException {
		init("Chrome", "https://www.ndtv.com/business");
	}

	@Test
	public void testCase1() throws Exception {
		checkPageReady();
		d.switchTo().frame(1);
		gClick(obj.site);
		wait(5);
		takeScreenShotTip("Question2", "SiteExpand");
		wait(2);
		new Select(d.findElement(obj.site)).selectByValue("Stock");
		wait(5);
		takeScreenShotTip("Question2", "Stock");
		d.switchTo().defaultContent();
		for (int i=0;i<10;i++)
		scrollDown();
		wait(5);
		sendText(obj.search, "Infosys");
		checkPageReady();
		gScrollIntoView(obj.videoresults);
		List<WebElement> l1=gGetLlist(obj.total);
		System.out.println(l1.size());
		Assert.assertTrue(l1.size()>1);
		System.out.println(getattributevalue(obj.firstvideo, "href"));
		gClick(obj.firstvideo);
		takeScreenShotTip("Question2", "VideoPage");
		
		
		

	}

	@AfterMethod
	public void AfterTest() {
		terminate();
	}}