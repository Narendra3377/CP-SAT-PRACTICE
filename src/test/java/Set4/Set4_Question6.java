package Set4;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set4_Question6 extends TestBase {


	@Before
	public void method1() {
		init("Chrome", "https://en.wikipedia.org/wiki/Main_Page");
	}

	@Test
	public void method2() throws Exception {

		checkPageReady();

		d.findElement(By.xpath("//input[@placeholder='Search Wikipedia']")).clear();
		d.findElement(By.xpath("//input[@placeholder='Search Wikipedia']")).sendKeys("Memento (film)");
		d.findElement(By.xpath("//input[@id='searchButton']")).click();
		wait(3);

		WebElement w1=d.findElement(By.xpath("//table[@class='infobox vevent']/tbody/tr[14]/td"));
		int actualRunningTime = Integer.parseInt(w1.getText().trim().split(" ")[0]);
		int actaulHour = actualRunningTime / 60;
		int actualMinute = actualRunningTime % 60;
		if (actaulHour == 1 && actualMinute == 53) {
			Assert.assertTrue(true);
			System.out.println("The run time is 113 minutes as expected");
		} else {
			Assert.assertTrue(false);
			System.out.println("The run time is not 113 minutes.");

		}

		String director = d.findElement(By.xpath("//table[@class='infobox vevent']/tbody/tr[3]/td")).getText().trim();

		if (director.equals("Christopher Nolan")) {
			Assert.assertTrue(true);
			System.out.println("The director name is as expected");
		} else {
			Assert.assertTrue(false);
			System.out.println("The director name is not as expected");

		}

		String BoxOffice=d.findElement(By.xpath("//table[@class='infobox vevent']/tbody/tr[18]/td")).getText().trim();
		if (BoxOffice.contains("$40 million")) {
			Assert.assertTrue(true);
			System.out.println("The box office collection is as expected");
		} else {
			Assert.assertTrue(false);
			System.out.println("The box office collection is not as expected");

		}

		System.out.println("Cast :");
		List<WebElement> cast2 = d
				.findElements(By.xpath("//div[@class='div-col']/ul/li"));
		for (int i = 0; i < cast2.size(); i++) {
			System.out.println(cast2.get(i).getText().trim());
		}

	}

	@After
	public void method3() {
		terminate();
	}

}
