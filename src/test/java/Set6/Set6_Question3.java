package Set6;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set6_Question3 extends TestBase {

	By search = By.id("searchboxinput");
	By direction = By.xpath("//div[@data-value='Directions']");
	By address = By.xpath("//div[@jsan='7.x3AX1-LfntMc-header-title-ij8cu']/h2");
	By from = By.xpath("(//input[@class='tactile-searchbox-input'])[4]");
	By time = By.xpath("(//div[@class='section-directions-trip-duration delay-light']/span)[1]");
	By distance = By.xpath("(//div[@class='section-directions-trip-distance section-directions-trip-secondary-text']/div)[1]");

	@Before
	public void initiateDriver() throws InterruptedException {
		init("Chrome", "https://www.google.com/maps/");
	}

	@Test
	public void testCase1() throws Exception {
		checkPageReady();
		sendText(search, "Dornipadu");
		d.findElement(search).sendKeys(Keys.ENTER);
		wait(5);
		List<WebElement> w1 = gGetLlist(address);
		for (int i = 0; i < w1.size(); i++)
			System.out.println(w1.get(i).getText());

		takeScreenShotTip("Set6_Question3", "Home");
		gScrollIntoView(direction);
		gClick(direction);

		wait(3);
		sendText(from, "Hyderabad");
		d.findElement(from).sendKeys(Keys.ENTER);
		wait(10);
		takeScreenShotTip("Set6_Question3", "HometoWork");
		String s=gettext(time);
		System.out.println("Time of arrival for the first search result is: "+s);
		String s1=gettext(distance);
		System.out.println("Distance for the first search result is: "+s1);
	}

	@After
	public void AfterTest() {
		terminate();
	}

}
