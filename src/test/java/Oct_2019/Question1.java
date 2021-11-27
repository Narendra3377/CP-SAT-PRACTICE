package Oct_2019;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.JavaScriptExecutor_Methods;
import com.testing.base.TestBase;

import pageObjects.Oct_2019_POM;

public class Question1 extends TestBase {

	Oct_2019_POM obj = new Oct_2019_POM();

	@BeforeMethod
	public void initiateDriver() throws InterruptedException {
		init("Chrome", "https://www.ndtv.com/business");
	}

	@Test
	public void testCase1() throws Exception {
		checkPageReady();
		String main = d.getWindowHandle();
		List<WebElement> l1 = gGetLlist(obj.topStories);
		System.out.println("Below are the top stories links on the home page");
		for (int i = 0; i < l1.size(); i++)
			System.out.println(l1.get(i).getAttribute("href"));
		String tooltiptext = d.findElement(obj.news).getAttribute("title");
		Assert.assertEquals(tooltiptext, "News");
		JavaScriptExecutor_Methods.drawBorder(d.findElement(obj.news), d);
		MovetoElement(obj.news);
		wait(10);
		takeScreenShotTip("Question1", "tooltip");
		Rightclick(obj.news);
		newWindowkeypress();
		checkPageReady();
		switchWindow();

		List<WebElement> l2 = gGetLlist(obj.trend);
		System.out.println("Below are the top trending stories links on the News page");
		for (int i = 0; i < 3; i++)
			System.out.println(l2.get(i).getAttribute("href"));
		takeScreenShotTip("Question1", tooltiptext);
		d.switchTo().window(main);
		System.out.println("Main page title: " + d.getTitle());
	}

	@AfterMethod
	public void AfterTest() {
		terminate();
	}

}
