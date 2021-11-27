package Set3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;
import com.testing.base.XLUtils;

public class Set3_Question4 extends TestBase {

	@BeforeMethod
	public void method1() {
		init("Chrome", "http://www.mptourism.com/");
	}

	@Test
	public void Test1() throws Exception {
		String path = "./testdata.xlsx";

		for (int i = 17; i < 20; i++) {

			checkPageReady();
			String keyword = XLUtils.getCellData(path, "Sheet1", i, 0);
			WebElement w1 = d.findElement(By.xpath("(//a[@class='nav-link'])[5]"));
			jsClick(w1);
			wait(2);
			WebElement w2 = d.findElement(By.xpath("//input[@type='text']"));
			w2.clear();
			w2.sendKeys(keyword + Keys.ENTER);
			scrollDown();
			wait(2);
			takeScreenShotTip("Set3_Question4", keyword);
			d.navigate().back();

		}

	}

	@AfterMethod
	public void method2() {
		terminate();
	}

}
