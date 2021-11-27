package Set1B;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;
import com.testing.base.XLUtils;

public class Set1B_Question2 extends TestBase {

	@BeforeMethod
	public void method1() {
		init("Chrome", "https://www.rediff.com/");
	}

	@Test
	public void test() throws Exception {
		String path = "./testdata.xlsx";
		checkPageReady();
		for (int i = 7; i < 11; i++) {

			String expmenu = XLUtils.getCellData(path, "Sheet1", i, 0);
			String actmenu = d.findElement(By.xpath("//li[@class='" + expmenu + "']")).getText().toLowerCase();
			Assert.assertEquals(expmenu, actmenu);
			d.findElement(By.xpath("//li[@class='" + expmenu + "']")).click();
			String expsubmenu = XLUtils.getCellData(path, "Sheet1", i, 1);
			String s = expsubmenu.toLowerCase();
			String actsubmenu = d.findElement(By.xpath("//a[text()='" + expsubmenu + "']")).getText().toLowerCase();
			Assert.assertEquals(s, actsubmenu);
			String explink = XLUtils.getCellData(path, "Sheet1", i, 2);
			String actlink = d.findElement(By.xpath("//a[text()='" + expsubmenu + "']")).getAttribute("href");
			Assert.assertEquals(explink, actlink);
			String submenu = XLUtils.getCellData(path, "Sheet1", i, 1);
			d.findElement(By.xpath("//a[text()='" + submenu + "']")).click();
			wait(5);
			takeScreenShotTip("Set1B_Question2", submenu);
			wait(5);
			d.navigate().back();
			checkPageReady();

		}

	}

	@AfterMethod
	public void method2() {
		terminate();
	}

}
