package Set1A;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set1A_Question2 extends TestBase {

	String url = "https://www.rediff.com/";

	@BeforeMethod
	@Parameters("browser")
	public void method1(String br) {
		init(br, "https://www.rediff.com/");

	}

	@Test
	public void test() throws Exception {
		String path = "./testdata.xlsx";
		checkPageReady();
		for (int i = 0; i < 4; i++) {

//			String expmenu = XLUtils.getCellData(path, "Sheet1", i, 0);
			String expmenu = readData(path, "Sheet1", i, 0);
			String actmenu = d.findElement(By.xpath("//li[@class='" + expmenu + "']")).getText().toLowerCase();
			Assert.assertEquals(expmenu, actmenu);
			d.findElement(By.xpath("//li[@class='" + expmenu + "']")).click();
//			String expsubmenu = XLUtils.getCellData(path, "Sheet1", i, 1);
			String expsubmenu = readData(path, "Sheet1", i, 1);
			String s = expsubmenu.toLowerCase();
			String actsubmenu = d.findElement(By.xpath("//a[text()='" + expsubmenu + "']")).getText().toLowerCase();
			Assert.assertEquals(s, actsubmenu);
//			String explink = XLUtils.getCellData(path, "Sheet1", i, 2);
			String explink = readData(path, "Sheet1", i, 2);
			String actlink = d.findElement(By.xpath("//a[text()='" + expsubmenu + "']")).getAttribute("href");
			Assert.assertEquals(explink, actlink);
//			String submenu = XLUtils.getCellData(path, "Sheet1", i, 1);
			String submenu = readData(path, "Sheet1", i, 1);
			d.findElement(By.xpath("//a[text()='" + submenu + "']")).click();
			wait(5);
			takeScreenShotTip("Set1A_Question2", submenu);
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
