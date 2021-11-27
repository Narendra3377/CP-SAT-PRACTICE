package Oct_2019;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;
import com.testing.base.XLUtils;

import pageObjects.Oct_2019_POM;

public class Question5 extends TestBase {

	Oct_2019_POM obj = new Oct_2019_POM();

	@BeforeMethod
	public void initiateDriver() throws InterruptedException {
		init("Chrome", "https://www.ndtv.com/business");
	}

	@Test
	public void testCase1() throws Exception {
		String path = "./testdata.xlsx";
		checkPageReady();
		for (int i = 0; i < 4; i++) {

			List<WebElement> topmenu = gGetLlist(obj.top);
			String expmenu = XLUtils.getCellData(path, "Sheet2", i, 0);
			String actmenu = topmenu.get(i).getText();
			Assert.assertEquals(expmenu, actmenu);
			System.out.println("Menu names are matched for " + actmenu);

			String actlink = topmenu.get(i).getAttribute("href");
			String explink = XLUtils.getCellData(path, "Sheet2", i, 1);
			Assert.assertEquals(explink, actlink);
			System.out.println(actlink);
			System.out.println("Links are are matched for " + actmenu);

		}

	}

	@AfterMethod
	public void AfterTest() {
		terminate();
	}

}
