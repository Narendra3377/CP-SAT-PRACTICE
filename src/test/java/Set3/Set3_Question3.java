package Set3;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

import pageObjects.Set3_Question3_POM;

public class Set3_Question3 extends TestBase {

	@BeforeMethod
	public void method1() {
		init("Chrome", "https://www.cii.in/");
	}

	@Test
	public void method2() throws InterruptedException {
		checkPageReady();
		Set3_Question3_POM a1 = new Set3_Question3_POM();
//		a1.closepopup();

		int totalIcons = a1.getIconsCount();
		for (int i = 0; i < totalIcons; i++) {
			System.out.println(a1.getIconName(i));
		}

		a1.contactUsclick();
		checkPageReady();
		Assert.assertEquals(d.getPageSource().contains("1800 103 1244"), true);
		System.out.println("1800 103 1244 " + "is present. ");

	}

	@AfterMethod
	public void method3() {
		terminate();
	}

}
