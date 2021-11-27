package Set2B;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

public class Set2B_Question4 extends TestBase {

	@Before
	public void setUp() {
		init("Chrome", "https://www.premierleague.com/");

	}

	@Test
	public void testMethod1() throws InterruptedException, Exception {

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

		String main = d.getWindowHandle();
		scrollIntoView(d.findElement(By.xpath("(//div[@class='current'])[1]")));

		Thread.sleep(2000);

		Actions a1 = new Actions(d);
		a1.contextClick(d.findElement(By.xpath("(//td[@class='team']/a/span[text()='Arsenal'])[1]"))).build().perform();
		
		Robot r1=new Robot();
		r1.keyPress(KeyEvent.VK_DOWN);
		r1.keyPress(KeyEvent.VK_DOWN);
		r1.keyPress(KeyEvent.VK_ENTER);

		checkPageReady();
		switchWindow();
		System.out.println("New Page Title: " + d.getTitle());
		d.navigate().back();
		d.switchTo().window(main);
		checkPageReady();
		System.out.println("Old Page Title: " + d.getTitle());

	}

	@After
	public void tearDown() {
		terminate();
	}

}
