package MockExam_1;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Question_3 extends TestBase {

	@Before
	public void initiateDriver() throws InterruptedException {
		init("Chrome", "https://mockexam1cpsat.agiletestingalliance.org/");

	}

	@Test
	public void testCase1() throws Exception {

		Question_3_POM obj = new Question_3_POM();
		checkPageReady();
		obj.selectingcrossicon();
		obj.selectingmenuicon();
		wait(2);
		obj.scrollingandclicking();
		wait(2);
		obj.scrollingtoSeaarch();
		System.out.println("Below are the participant names:");
		List<WebElement> l1 = d.findElements(obj.names);
		for (int i = 0; i < l1.size(); i++)
			System.out.println(l1.get(i).getText());
		System.out.println("Below are the designation names:");
		List<WebElement> l2 = d.findElements(obj.designations);
		for (int i = 0; i < l2.size(); i++)
			System.out.println(l2.get(i).getText());
		System.out.println("Below are the organization names:");
		List<WebElement> l3 = d.findElements(obj.organizations);
		for (int i = 0; i < l3.size(); i++)
			System.out.println(l3.get(i).getText());
	}

	@After
	public void AfterTest() {
		d.close();
	}
}
