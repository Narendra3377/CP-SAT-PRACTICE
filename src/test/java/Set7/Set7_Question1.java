package Set7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

public class Set7_Question1 extends TestBase {

	By menu1 = By.linkText("BRANDS");
	By menu2 = By.linkText("HauteCurry");
	By contact = By.xpath("//a[@class='tpcontactus']");
	By follow = By.xpath("//div[@class='footer-light-graysection']/div/div/div[3]");
	By insta = By.linkText("//li[contains(@class,'twitter')]//a");

	@Before
	public void initiateDriver() throws InterruptedException {
		init("Chrome", "https://www.shoppersstop.com/");
	}

	@Test
	public void testCase1() throws Exception {
		checkPageReady();
		Actions a1 = new Actions(d);
		a1.moveToElement(d.findElement(menu1)).build().perform();
		wait(2);
		a1.moveToElement(d.findElement(menu2)).build().perform();
		gClick(menu2);
		checkPageReady();
		wait(5);
//		jsClick(d.findElement(By.className("close cookieExitButton")));
		takeScreenShotTip("Set7_Question1", "HauteCurry");
		String title = d.getTitle();
		System.out.println(title);
		if (title.equals("Buy Haute Curry Clothing & Accessories Online | Shoppers Stop"))
			System.out.println("Title is as expected");
		else
			System.out.println("Title is not as expected");

		gClick(contact);
		checkPageReady();
//		gScrollIntoView(follow);
		wait(2);
		System.out.println(getattributevalue(insta, "href"));

	}

	@After
	public void AfterTest() {
		terminate();
	}

}
