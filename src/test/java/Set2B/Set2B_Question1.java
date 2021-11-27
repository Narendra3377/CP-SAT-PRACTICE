package Set2B;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set2B_Question1 extends TestBase {

	@BeforeTest
	public void launchBrowser() {
		init("chrome", "https://www.meripustak.com");
	}

	@Test
	public void test() throws Exception {

		checkPageReady();
		int width = d.findElement(By.xpath("//a[@id='mpstkLogo']/img")).getSize().getWidth();
		int height = d.findElement(By.xpath("//a[@id='mpstkLogo']/img")).getSize().getHeight();
		System.out.println("Img Height: " + height);
		System.out.println("Img Width: " + width);

		List<WebElement> followUs = d.findElements(By.xpath("//div[@class='social links_right']/a/i"));
		for (int i = 0; i < followUs.size(); i++) {
			String s = followUs.get(i).getAttribute("class");
			if (s.contains("fa-twitter")) {
				WebElement w1 = d.findElement(By.xpath("//div[@class='social links_right']/a[2]"));
				System.out.println(w1.getAttribute("href"));
			}
		}

		d.findElement(By.xpath("//*[@href='https://www.meripustak.com/cart']")).click();
		Thread.sleep(5000);
		String cartText1 = d.findElement(By.xpath("//table[@class='table-striped table-bordered cart_table']//h4"))
				.getText().trim();
		Assert.assertEquals(cartText1, "No Item is Added In Cart yet.Cart is Empty!!!");
		System.out.println("Text present - No Item is Added In Cart yet.Cart is Empty!!!");
		d.navigate().back();
		Thread.sleep(5000);

		d.findElement(By.xpath("//input[@id='txtsearch']")).sendKeys("java book" + Keys.ENTER);
		Thread.sleep(5000);
		d.findElement(By.xpath("//div[@id='book_list']//child::li/a")).click();
		Thread.sleep(5000);
		d.findElement(By.xpath("//input[@id='ContentPlaceHolder1_AddtoCart']")).click();
		Thread.sleep(5000);
		try {
			String cartText2 = d.findElement(By.xpath("//table[@class='table-striped table-bordered cart_table']//h4"))
					.getText().trim();
			if (cartText2.equals("No Item is Added In Cart yet.Cart is Empty!!!"))
				System.out.println("Text present - No Item is Added In Cart yet.Cart is Empty!!!");
		} catch (Exception e) {
			System.out.println("Text is not present - No Item is Added In Cart yet.Cart is Empty!!!");
		}
	}

	@AfterTest
	public void closeBrowser() {
		terminate();
	}

}
