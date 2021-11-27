package Set1B;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set1B_Question1 extends TestBase {

	@BeforeMethod
	public void method1() {
		init("Chrome", "https://www.rediff.com/");
	}

	@Test
	public void Test1() throws InterruptedException {
		waitForElementToClickable(d.findElement(By.xpath("//a[text()='BUSINESS']"))).click();
		takeScreenShotTip("Set1B_Question1", "Business");

		List<WebElement> subMenus = d.findElements(By.xpath("//div[@class='subnavbar business']/ul/li/a"));
		for (int i = 0; i < subMenus.size(); i++) {
			System.out.println(subMenus.get(i).getAttribute("href"));
		}
		Thread.sleep(5000);

		Assert.assertEquals(d.findElement(By.xpath("//a[text()='NEWS']")).getAttribute("title"), "News headlines");

		Actions act = new Actions(d);
		act.moveToElement(d.findElement(By.xpath("//a[text()='NEWS']"))).build().perform();
		Thread.sleep(3000);
		takeScreenShotTip("Set1B_Question1", "Tooltip");

		String bgcolor = d.findElement(By.xpath("//li[@class='business']")).getCssValue("background-color");
		String rgbClr = Color.fromString(bgcolor).asRgb();
		Assert.assertEquals(rgbClr, "rgb(159, 107, 63)");

		d.navigate().to("https://www.color-blindness.com/color-name-hue/");
		checkPageReady();
		d.switchTo().frame(d.findElement(By.xpath("//iframe[@src='/color-name-hue-tool/color-name-hue.html']")));

		d.findElement(By.xpath("//input[@id='cp1_Red']")).sendKeys("-");
		waitForElementToClickable(d.findElement(By.xpath("//input[@id='cp1_Red']")))
				.sendKeys("159" + Keys.TAB + "107" + Keys.TAB + "63");
		Thread.sleep(3000);
		takeScreenShotTip("Set1B_Question1", "Color");
		Assert.assertEquals(d.findElement(By.xpath("//div[@id='cp1_ColorNameText']")).getText(), "Desert");
	}

	@AfterMethod
	public void method2() {
		terminate();
	}

}
