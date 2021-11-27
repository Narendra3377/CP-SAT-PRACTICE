package Set1A;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set1A_Question1 extends TestBase {


	@BeforeMethod
	@Parameters("browser")
	public void method1(String br) {
		init(br, "https://www.rediff.com/");

		
	}

	@Test
	public void Test1() throws InterruptedException {
		waitForElementToClickable(d.findElement(By.xpath("//a[text()='NEWS']"))).click();
		takeScreenShotTip("Set1A_Question1", "News");

		List<WebElement> subMenus = d.findElements(By.xpath("//div[@class='subnavbar news']/ul/li/a"));
		for (int i = 0; i < subMenus.size(); i++) {
			System.out.println(subMenus.get(i).getAttribute("href"));
		}
		Thread.sleep(5000);

		Assert.assertEquals(d.findElement(By.xpath("//a[text()='BUSINESS']")).getAttribute("title"),
				"Business headlines");

		Actions act = new Actions(d);
		act.moveToElement(d.findElement(By.xpath("//a[text()='BUSINESS']"))).build().perform();
		Thread.sleep(3000);
		takeScreenShotTip("Set1A_Question1", "Tooltip");

		String bgcolor = d.findElement(By.xpath("//li[@class='news']")).getCssValue("background-color");
		String rgbClr = Color.fromString(bgcolor).asRgb();
		Assert.assertEquals(rgbClr, "rgb(188, 62, 49)");

		d.navigate().to("https://www.color-blindness.com/color-name-hue/");
		checkPageReady();
		d.switchTo().frame(d.findElement(By.xpath("//iframe[@src='/color-name-hue-tool/color-name-hue.html']")));

		d.findElement(By.xpath("//input[@id='cp1_Red']")).sendKeys("-");
		waitForElementToClickable(d.findElement(By.xpath("//input[@id='cp1_Red']")))
				.sendKeys("188" + Keys.TAB + "62" + Keys.TAB + "49");
		Thread.sleep(3000);
		takeScreenShotTip("Set1A_Question1", "Color");
		Assert.assertEquals(d.findElement(By.xpath("//div[@id='cp1_ColorNameText']")).getText(), "Grenadier");
	}

	@AfterMethod
	public void method2() {
		terminate();
	}
}
