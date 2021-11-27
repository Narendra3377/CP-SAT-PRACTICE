package Set4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.testing.base.TestBase;

public class Set4_Question5 extends TestBase {

	@Before
	public void method1() {
		init("Chrome", "http://www.onlineconversion.com/length_common.htm");
	}

	@Test
	public void method2() throws Exception {

		checkPageReady();
		d.findElement(By.xpath("//input[@name='what']")).sendKeys("5");
		new Select(d.findElement(By.xpath("//select[@name='from']"))).selectByVisibleText("feet");
		new Select(d.findElement(By.xpath("//select[@name='to']"))).selectByVisibleText("inch");
		d.findElement(By.xpath("//input[@name='Go' and @type='button']")).click();
		waitForElementToVisible(d.findElement(By.xpath("//input[@name='answer']")));
		String expectedValue = "60";
		String actualValue = d.findElement(By.xpath("//input[@name='answer']")).getAttribute("value").trim();
		if (actualValue.contains(expectedValue)) {
			Assert.assertTrue(true);
			System.out.println("The result is verified");
		} else {
			Assert.assertTrue(false);
			System.out.println("The result is not verified");
		}

	}

	@After
	public void method3() {
		terminate();
	}

}
