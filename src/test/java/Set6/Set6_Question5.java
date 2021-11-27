package Set6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

public class Set6_Question5 extends TestBase {

	By menu1 = By.linkText("ACADEMICS");
	By menu2 = By.linkText("FACULTY");
	By menu3 = By.linkText("SCIENCE & TECHNOLOGY");
	By IT = By.linkText("DEPARTMENT OF INFORMATION TECHNOLOGY");
	By vision = By.xpath("(//div[@class='feature-col-item init-animate slideInUp1']/p)[3]");
	By contact = By.xpath("(//h2[@class='widget-title']/span)[5]");
	By address = By.xpath("//div[@class='fs-text-desc']/p[1]");
	By phoneEmail = By.xpath("//div[@class='fs-text-desc']/p[2]");

	@Before
	public void initiateDriver() throws InterruptedException {
		init("Chrome", "https://mu.ac.in/");
	}

	@Test
	public void testCase1() throws Exception {
		checkPageReady();
		Actions a1 = new Actions(d);
		a1.moveToElement(d.findElement(menu1)).build().perform();
		a1.moveToElement(d.findElement(menu2)).build().perform();
		gClick(menu3);
		gClick(IT);
		switchWindow();
		checkPageReady();
		System.out.println(gettext(vision).split("\n")[0]);
		gScrollIntoView(contact);
		wait(2);
		if (gettext(phoneEmail).contains("022-26500208") && gettext(phoneEmail).contains("uditoffice@gmail.com"))
			System.out.println("Phone number and Email are matched");
		else
			System.out.println("Phone number and Email are not matched");
		wait(2);
		takeScreenShotTip("Set6_Question5", "contact");

	}

	@After
	public void AfterTest() {
		terminate();
	}

}
