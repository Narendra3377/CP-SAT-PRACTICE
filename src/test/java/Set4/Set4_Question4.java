package Set4;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;
import com.testing.base.XLUtils;

public class Set4_Question4 extends TestBase {

	@Before
	public void method1() {
		init("Chrome", "https://www.shoppersstop.com/");
	}

	@Test
	public void method2() throws Exception {
		checkPageReady();
		String path = "./testdata.xlsx";
		Boolean flag=true;
		for (int i = 22; i < 24; i++) {

			String searchKey = XLUtils.getCellData(path, "Sheet1", i, 0);
			d.findElement(By.id("js-site-search-input")).clear();
			d.findElement(By.id("js-site-search-input")).sendKeys(searchKey + Keys.ENTER);
			wait(10);
			d.findElement(By.xpath("//li[@sortcode='price-desc']")).click();
			wait(10);

	
			List<WebElement> r_Price = d.findElements(By.xpath("//div[@class='li-inner']//div[@class='price_div']"));
			for (int j = 1; j < r_Price.size(); j++) {
				flag=true;
				System.out.println(r_Price.get(j).getText().toString());
				System.out.println((r_Price.get(j).getText().replaceAll("[^0-9]", " ").trim().split(" "))[0].trim());
				if (Float.parseFloat((r_Price.get(j-1).getText().replaceAll("[^0-9]", " ").trim().split(" "))[0].trim()) < Float.parseFloat((r_Price.get(j).getText().replaceAll("[^0-9]", " ").trim().split(" "))[0].trim())) {
					flag = false;
					System.out.println("Items are not in descending order for the item: "+searchKey);
					break;
				} else {
					continue;
				}
			}
			if (flag == true) {
				System.out.println("Items are placed in descending order for the item: "+searchKey);

			}

		}}

	

	@After
	public void method3() {
		terminate();
	}

}
