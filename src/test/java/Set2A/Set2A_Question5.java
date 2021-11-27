package Set2A;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

public class Set2A_Question5 extends TestBase {

	@Before
	public void setUp() {
		init("Chrome", "https://www.premierleague.com/");

	}

	@Test
	public void testMethod1() throws InterruptedException {

		checkPageReady();

		try {
			d.findElement(By.xpath("//div[@class='btn-primary cookies-notice-accept']")).click();
			WebElement ele = d.findElement(By.xpath("//nav[@class='navBar']/a[2]"));
			jsClick(ele);

		} catch (Exception e) {
			WebElement ele = d.findElement(By.xpath("//nav[@class='navBar']/a[2]"));
			jsClick(ele);
		}

		d.findElement(By.xpath("//nav[@class='subNav']/ul/li/a[text()='Tables']")).click();
		checkPageReady();

		WebElement ele = d.findElement(By.xpath("//nav[@class='navBar']/a[2]"));
		jsClick(ele);

		scrollIntoView(d.findElement(By.xpath("(//th[text()='Club'])[1]")));
		scrollIntoView(d.findElement(By.xpath("(//td[@class='team']/a/span[text()='Arsenal'])[1]")));

		Actions act = new Actions(d);
		act.moveToElement(d.findElement(By.xpath("(//td[@class='team']/a/span[text()='Everton'])[1]"))).click().build()
				.perform();

		checkPageReady();

		String websiteUrl = d.findElement(By.xpath("//span[text()='Official Website:']/following-sibling::a"))
				.getText();

		System.out.println("Website Url is: " + websiteUrl);
		System.out.println("Page Title: " + d.getTitle());

	}

	@After
	public void tearDown() {
		terminate();
	}
}
