package Set2A;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testing.base.TestBase;
import com.testing.base.XLUtils;

public class Set2A_Question4 extends TestBase {
	
	public void isSorted(int[] arr, String filter)
	{
		for (int b = 0; b < 8; b++) {
			for (int c=b+1; c < 8; c++) {
				if (arr[c] < arr[b]) {
					System.out.println("Prices for " + filter + " not in ascending order");

				}
				break;
			}

		}

		System.out.println("Prices for " + filter + " are in ascending order");

	}

	@BeforeClass
	public void setUp() {
		init("chrome", "https://www.woodlandworldwide.com/");
	}

	@Test
	public void test() throws Exception {
		String path = "./testdata.xlsx";
		for (int i = 13; i < 16; i++) {

			String filter = XLUtils.getCellData(path, "Sheet1", i, 0);
			d.findElement(By.id("searchKey")).clear();
			d.findElement(By.id("searchKey")).sendKeys(filter + Keys.ENTER);
			Thread.sleep(5000);

			Actions act = new Actions(d);
			WebElement w1 = d.findElement(By.xpath("//div[@class='sorting']"));
			act.moveToElement(w1).build().perform();
			d.findElement(By.xpath("//a[@data-id='price-asc']")).click();

			List<WebElement> price = d.findElements(By.xpath("//span[@class='price']"));
			int a[] = new int[8];
			for (int j = 0; j < 8; j++) {

				String s = price.get(j).getText();
				String s1 = s.replace("\n", "");
				String s2 = s1.replace("₹", "");
				String s3 = s2.replace(" ", "");
				a[j] = Integer.parseInt(s3);
				System.out.println(a[j]);

			}
			
			isSorted(a,filter);

			
		}
	}

	@AfterClass
	public void tearDown() {
		terminate();
	}
}
