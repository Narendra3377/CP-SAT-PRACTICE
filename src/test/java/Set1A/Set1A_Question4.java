package Set1A;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set1A_Question4 extends TestBase {

	@Before
	public void method1() {
		init("Chrome", "https://www.rediff.com/");
	}

	@Test
	public void method2() throws Exception {
		String path = "./testdata.xlsx";
		checkPageReady();

		List<WebElement> allStories = d.findElements(By.xpath("//div[@id='topdiv_0']/h2/a"));

		for (int i = 0; i < allStories.size(); i++) {

			System.out.println(allStories.get(i).getAttribute("href"));
			setData(path, "Set1A_Question4", i, 0, allStories.get(i).getAttribute("href"));
		}
	}

	@After
	public void method3() {
		terminate();
	}
}
