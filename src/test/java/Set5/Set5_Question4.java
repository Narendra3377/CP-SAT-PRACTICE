package Set5;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set5_Question4 extends TestBase {

	@Before
	public void method1() {
		init("firefox", "https://www.allmovie.com/");
	}

	@Test
	public void method2() throws Exception {
		int count = 0;
		checkPageReady();
		d.findElement(By.xpath("//input[@class='site-search-input']")).click();
		d.findElement(By.xpath("//input[@class='site-search-input']")).clear();
		d.findElement(By.xpath("//input[@class='site-search-input']")).sendKeys("The Godfather" + Keys.ENTER);
		wait(3);
		String s = d.findElement(By.xpath("//div[@class='results']/h1")).getText().split(" ")[0];
		System.out.println("Number of Results Found: " + s);

		List<WebElement> searchresults = d.findElements(By.xpath("//h4[contains(text(),'Movie')]//following::div"));
		for (int i = 1; i <= searchresults.size(); i++) {
			String result = d.findElement(By.xpath("(//h4[contains(text(),'Movie')]//following::div)[" + i + "]"))
					.getText();
			if (result.contains("1972")) {
				count = i;
				break;
			}
		}
		d.findElement(By.xpath("(//h4[contains(text(),'Movie')]//following::div)[" + count + "]//a")).click();
		wait(2);
		checkPageReady();
		if ((d.findElement(By.xpath("//div[@class='details']/span[1]")).getText()).contains("Crime")) {
			System.out.println("The genre is displayed as crime");
			if (d.findElement(By.xpath("//div[@class='details']/span[6]")).getText().contains("R")) {
				System.out.println("The MPAA is displayed as 'R'");
				d.findElement(By.xpath("//ul[@class='tabs overview']/li[4]")).click();
				wait(2);
				checkPageReady();
				if (d.findElement(By.xpath("//h2[contains(text(),'Director')]//following::dt//a[1]")).getText()
						.contains("Francis Ford Coppola")) {
					System.out.println("The director name is displayed as expected");
					if (d.findElement(By.xpath("(//a[contains(text(),'Al Pacino')]//following::div)[1]")).getText()
							.contains("Michael Corleone")) {
						System.out.println("The casting crew name is displayed as expected");
					}
				}
			}
		}

	}

	@After
	public void method3() {
		terminate();
	}

}
