package Set2A;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

//Electronics is not available on the Website. Implemented below script with somther type

public class Set2A_Question3 extends TestBase {

	@Before
	public void launchBrowser() {
		init("chrome", "https://www.hometown.in/");
	}

	@Test
	public void validateApplication() throws InterruptedException {

		checkPageReady();
		try {
			d.findElement(By.xpath("//button[@id='onesignal-slidedown-cancel-button']")).click();
			System.out.println("Successfully clicked on Later");
		} catch (Exception e) {

			System.out.println("No alret present");
		}

		Thread.sleep(2000);
		Actions action = new Actions(d);
		WebElement more = d.findElement(By.xpath("//div[@class='sc-kpOJdX ereaXD']"));
		action.moveToElement(more).build().perform();
		d.findElement(By.xpath("//a[@title='Gifting Ideas']")).click();
		Thread.sleep(2000);

		WebElement search1 = d.findElement(By.xpath("//div[@class='dropparent']/p[contains(text(),'Color')]"));
		action.moveToElement(search1).click().build().perform();
		Thread.sleep(2000);
		d.findElement(By.xpath("//ul[@class='dropdown']/li[1]")).click();
		Thread.sleep(5000);

		String filter = d.findElement(By.xpath("//li[@class='selected-facet-name lt']/p")).getText();
		System.out.println(filter);
		Assert.assertEquals(filter, "white");

		String product = d.findElement(By.xpath("//div[@class='topname'][1]/div/p")).getText();
		System.out.println(product);
		Assert.assertEquals(product.contains("White"), true);

	}

	@After
	public void closeBrowser() {
		close();
	}
}
