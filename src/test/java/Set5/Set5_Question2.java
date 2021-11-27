package Set5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.testing.base.TestBase;

public class Set5_Question2 extends TestBase {

	SoftAssert softAssertion = new SoftAssert();

	@BeforeTest
	public void launchBrowser() {
		init("chrome", "https://www.google.com/maps/");
	}

	@Test
	public void test() throws Exception {

		checkPageReady();
		d.findElement(By.id("searchboxinput")).clear();
		d.findElement(By.id("searchboxinput")).sendKeys("Wankhede Stadium" + Keys.ENTER);
		wait(5);
		takeScreenShotTip("Set5_Question2", "Wankhede Stadium");
		Boolean getTxt = d.getPageSource().contains("Stadium");
		softAssertion.assertTrue(getTxt, "Stadium");

		String expectedTitle = "Wankhede Stadium Mumbai - Google Maps";
		String actualTitle = d.getTitle();
		System.out.println(actualTitle);
		softAssertion.assertEquals(actualTitle, expectedTitle);
		wait(2);
		String rating = d.findElement(By.xpath("//div[@class='gm2-display-2']")).getText().trim();
		System.out.println("Ratings: " + Double.parseDouble(rating));

		String review = d.findElement(By.xpath("//button[@class='gm2-button-alt HHrUdb-v3pZbf']")).getText()
				.split(" ")[0].trim();
		System.out.println("Number of Reviews: " + review);

		WebElement w1 = d.findElement(By.xpath("(//div[@class='rogA2c']/div[@jsan='7.QSFF4-text,7.gm2-body-2'])[1]"));
		scrollIntoView(w1);
		String address = w1.getText();
		System.out.println("Address: " + address);

		Boolean link = d.getPageSource().contains("mumbaicricket.com");
		softAssertion.assertTrue(link, "mumbaicricket.com");

		softAssertion.assertAll();

	}

	@AfterTest
	public void closeBrowser() {
		terminate();
	}

}
