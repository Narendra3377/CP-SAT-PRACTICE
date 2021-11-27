package Set2B;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.testing.base.TestBase;

public class Set2B_Question2 extends TestBase{
	
	@Before
	public void setUp() {
		init("Chrome", "https://www.cii.in/OnlineRegistration.aspx");

	}

	@Test
	public void method2() throws InterruptedException {

		new Select(d.findElement(By.id("drpAttendee"))).selectByVisibleText("3");

		List<WebElement> lst = d.findElements(By.xpath("//table[@id='Gridview1']//tr//select"));
		Assert.assertEquals(3, lst.size());

		Select fstrow = new Select(lst.get(0));
		fstrow.selectByVisibleText("Admiral");
		Thread.sleep(1000);

		Select sndrow = new Select(lst.get(1));
		sndrow.selectByValue("CA");
		Thread.sleep(1000);

		Select thirdrow = new Select(lst.get(2));
		thirdrow.selectByIndex(19);
		Thread.sleep(1000);

		List<WebElement> l1 = d.findElements(By.xpath("//table[@id='Gridview1']/tbody/tr[2]/td/select/option"));
		int j;

		System.out.println("Options are: ");

		for (j = 0; j < l1.size(); j++) {
			int k = j + 1;
			System.out.println("Option " + k + ": " + l1.get(j).getText());
		}
	}

	@After
	public void tearDown() {
		terminate();
	}

}
