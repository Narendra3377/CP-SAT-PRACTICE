package Set6;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;
import com.testing.base.XLUtils;

public class Set6_Question1 extends TestBase {

	public void isSorted(ArrayList<Integer> arr, String filter) {
		for (int b = 0; b < 8; b++) {
			for (int c = b + 1; c < 8; c++) {
				if (arr.get(c) < arr.get(b)) {
					System.out.println("Prices for " + filter + " not in ascending order");

				}
				break;
			}

		}

		System.out.println("Prices for " + filter + " are in ascending order");

	}

	@BeforeMethod
	public void method1() throws InterruptedException {
		init("Chrome", "https://www.pepperfry.com/");
	}

	@Test
	public void method2() throws Exception {
		checkPageReady();

		if (d.findElements(By.xpath("//div[@class='popup-box gb-modal reg_modal']/a")).size() > 0) {
			if (d.findElements(By.xpath("//div[@class='popup-box gb-modal reg_modal']/a")).get(0).isDisplayed()) {
				d.findElements(By.xpath("//div[@class='popup-box gb-modal reg_modal']/a")).get(0).click();
			}
		}
		d.switchTo().frame(d.findElement(By.name("notification-frame-b8a51171")));
		jsClick(d.findElement(By.xpath("//span[@class='wewidgeticon we_close icon-large']")));
		d.switchTo().defaultContent();

		checkPageReady();

		for (int i = 31; i < 34; i++) {
			String keyword = XLUtils.getCellData(path, "Sheet1", i, 0);
			d.findElement(By.xpath("//input[@placeholder='Search']")).clear();
			d.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(keyword + Keys.ENTER);
			wait(5);
			
			d.findElement(By.id("curSortType")).click();
			d.findElement(By.xpath("//li[@data-sort='price-asc']")).click();
			wait(5);
			List<WebElement> l1 = d.findElements(By.xpath("//div[@class='pf-col xs-12']/span[1]"));
			ArrayList<Integer> a1 = new ArrayList<Integer>();
			for (int j = 0; j < l1.size(); j++) {
				String s=l1.get(j).getText().split(" ")[1];
				String s1=s.replace(",", "");
				int a = Integer.parseInt(s1);
				a1.add(a);
			}

//			for (int k = 0; k < a1.size(); k++)
//				System.out.println(a1.get(k));

			isSorted(a1,keyword);
		}

	}

	@AfterMethod
	public void mathod3() {
		terminate();
	}
}
