package Set5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;
import com.testing.base.XLUtils;

public class Set5_Question1 extends TestBase {

	@BeforeTest
	public void launchBrowser() {
		init("firefox", "https://www.meripustak.com");
	}

	@Test
	public void test() throws Exception {

		String path = "./testdata.xlsx";
		checkPageReady();
		for (int i = 26; i < 29; i++) {
			String keyWord = XLUtils.getCellData(path, "Sheet1", i, 0);
			d.findElement(By.id("txtsearch")).clear();
			d.findElement(By.id("txtsearch")).sendKeys(keyWord + Keys.ENTER);
			wait(5);

			System.out.println("Below are the " + keyWord + " book prices:");
			for (int j = 1; j <= 10; j++) {
				String bookname = d.findElement(By.xpath("(//span[contains(@itemprop,'name')])[" + j + "]")).getText()
						.trim();
				String L_Price = d.findElement(By.xpath("(//div[contains(@class,'price left')])[" + j + "]")).getText();
				String s = L_Price.replace("Rs.", "");
				String s1 = s.replace("/-", "").trim();
				int leftprice = Integer.parseInt(s1);
				String R_Price = d.findElement(By.xpath("(//div[contains(@class,'price right')])[" + j + "]"))
						.getText();
				String b = R_Price.replace("Rs.", "");
				String b1 = b.replace("/-", "").trim();
				int rightprice = Integer.parseInt(b1);
				if (leftprice > rightprice) {
					System.out.println("The book name is: " + bookname + " and the discounted price is: " + rightprice);
					log("The book name is: " + bookname + " and the discounted price is: " + rightprice);
				}
			}
		}
	}

	@AfterTest
	public void closeBrowser() {
		terminate();
	}

}
