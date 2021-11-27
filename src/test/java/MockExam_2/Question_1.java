package MockExam_2;

import java.util.List;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Question_1 extends TestBase {

	@BeforeMethod
	@Parameters("browser")
	public void initiateDriver(String browser) throws InterruptedException {
		init(browser, "https://mockexam2cpsat.agiletestingalliance.org/");

	}

	@Test
	public void testCase1() throws Exception {
		checkPageReady();
		jsClick(d.findElement(By.xpath("//i[@class='eicon-close']")));
		scrolltoBottom();
		wait(2);
		List<WebElement> l2 = d
				.findElements(By.xpath("//div[@class='elementor-social-icons-wrapper elementor-grid']//a"));
		for (int i = 0; i < l2.size(); i++) {
			System.out.println(l2.get(i).getAttribute("href"));
		}

		String mainWindow = d.getWindowHandle();
		System.out.println();
		System.out.println("Below are the Social Media Title Names");
		for (int i = 0; i < l2.size(); i++) {
			W_Rightclick(l2.get(i));
			newWindowkeypress();
			switchWindow();
			System.out.println(d.getTitle());
			d.close();
			d.switchTo().window(mainWindow);
		}

		List<WebElement> l3 = d.findElements(By.xpath("//div[@class='elementor-countdown-wrapper']//div/span[1]"));
		for (int i = 0; i < l3.size(); i++) {
			int a = Integer.parseInt(l3.get(i).getText());
			System.out.println(a);
		}
		int hour = Integer.parseInt(l3.get(1).getText());
		Assert.assertTrue(hour < 24);
		int minute = Integer.parseInt(l3.get(1).getText());
		Assert.assertTrue(minute < 60);
		int seconds = Integer.parseInt(l3.get(1).getText());
		Assert.assertTrue(seconds < 60);
	}

	@AfterMethod
	public void AfterTest() {
		terminate();
	}
}
