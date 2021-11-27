package Set4;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

import pageObjects.Set4_Question1_POM;

public class Set4_Question1 extends TestBase {

	@BeforeMethod
	public void method1() {
		init("Chrome", "https://www.cii.in/");
	}

	@Test
	public void method2() throws Exception {
		checkPageReady();
		Actions act = new Actions(d);
		Set4_Question1_POM obj = new Set4_Question1_POM();
		obj.closepopup();

		obj.clickAgri(act);

		wait(5);
		Assert.assertEquals(d.getTitle(), "Sectors");

		obj.printSocialList();
		takeScreenShotTip("Set4_Question1", "Agriculture");

	}

	@AfterMethod
	public void method3() {
		terminate();
	}
}
