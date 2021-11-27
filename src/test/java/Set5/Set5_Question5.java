package Set5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.testing.base.TestBase;

public class Set5_Question5 extends TestBase {

	@Before
	public void initiateDriver() throws InterruptedException {
		init("Chrome", "http://ata123456789123456789.appspot.com/");
	}

	@Test
	public void testCase1() {

		d.findElement(By.id("gwt-uid-7")).click();
		d.findElement(By.xpath("//input[@id='ID_nameField1']")).clear();
		d.findElement(By.xpath("//input[@id='ID_nameField1']")).sendKeys("7");
		d.findElement(By.xpath("//input[@id='ID_nameField2']")).clear();
		d.findElement(By.xpath("//input[@id='ID_nameField2']")).sendKeys("4");
		d.findElement(By.xpath("//button[@id='ID_calculator']")).click();
		wait(2);
		String value = d.findElement(By.xpath("//input[@id='ID_nameField3']")).getAttribute("value");
		int generatedvalue = Integer.parseInt(value);
		int expectedvalue = (7 * 7) - 2 * (7 * 4) + (4 * 4);
		System.out.println(expectedvalue);
		if (generatedvalue == expectedvalue) {
			System.out.println("Value is generated as expected");
		} else {
			System.out.println("Value is not generated as expected");
		}

	}

	@After
	public void AfterTest() {
		terminate();
	}

}
