package Oct_2019;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

import pageObjects.Oct_2019_POM;

public class Question4 extends TestBase {

	Oct_2019_POM obj = new Oct_2019_POM();

	@BeforeMethod
	public void initiateDriver() throws InterruptedException {
		init("Chrome", "https://www.ndtv.com/business");
	}

	@Test
	public void testCase1() throws Exception {
		checkPageReady();
		List<WebElement> topmenu = gGetLlist(obj.top);
		System.out.println("Below are the top menu links: ");
		for (int i = 0; i < topmenu.size(); i++)
			System.out.println(topmenu.get(i).getAttribute("href"));

		String news = getattributevalue(obj.T_news, "href").split("#")[0];
		String business = getattributevalue(obj.T_business, "href").split("#")[0];
		String hindi = getattributevalue(obj.T_hindi, "href").split("#")[0];
		String movies = getattributevalue(obj.T_movies, "href").split("#")[0];
		String cricket = getattributevalue(obj.T_cricket, "href").split("#")[0];
		String food = getattributevalue(obj.T_food, "href").split("#")[0];
		String tech = getattributevalue(obj.T_tech, "href").split("#")[0];
		String auto = getattributevalue(obj.T_auto, "href").split("#")[0];
		String art = getattributevalue(obj.T_art, "href").split("#")[0];
		ArrayList<String> top = new ArrayList<String>();
		top.add(news);
		top.add(business);
		top.add(hindi);
		top.add(movies);
		top.add(cricket);
		top.add(food);
		top.add(tech);
		top.add(auto);
		top.add(art);
		for (int i = 0; i < 10; i++)
			scrollDown();
		List<WebElement> bottom = gGetLlist(obj.Bottom);
		System.out.println("Below are the bottom menu links: ");
		for (int i = 0; i < bottom.size(); i++)
			System.out.println(bottom.get(i).getAttribute("href"));

		for (int i = 0; i < 9; i++) {
			int j;
			if (i == 8) {
				j = i + 1;
				String s = bottom.get(j).getAttribute("href");

				if (s.equals(top.get(i))) {
					Assert.assertTrue(true);
					System.out.println("Top link: " + top.get(i));
					System.out.println("Bottom link: " + s);
					System.out.println("Both the links are matched");
					System.out.println();
				} else
					Assert.assertTrue(false);
				break;
			}

			String s = bottom.get(i).getAttribute("href");

			if (s.equals(top.get(i))) {
				Assert.assertTrue(true);
				System.out.println("Top link: " + top.get(i));
				System.out.println("Bottom link: " + s);
				System.out.println("Both the links are matched");
				System.out.println();
			} else {
				System.out.println("Top link: " + top.get(i));
				System.out.println("Bottom link: " + s);
				Assert.assertTrue(false);
			}
		}

	}

	@AfterMethod
	public void AfterTest() {
		terminate();
	}
}