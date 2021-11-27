package MockExam_1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Question_1 extends TestBase {

	@BeforeMethod
	public void initiateDriver() throws InterruptedException {
//		init("Chrome", "https://mockexam1cpsat.agiletestingalliance.org/");

		String url = "https://mockexam1cpsat.agiletestingalliance.org/";
		d.get(url);
		d.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		System.out.println(url + " is Opened - ");
	}

	@Test
	public void testCase1() throws Exception {
		checkPageReady();
		jsClick(d.findElement(By.xpath("//i[@class='eicon-close']")));
		gClick(By.xpath("//li[@class='slideout-toggle menu-item-align-right ']"));
		List<WebElement> l1 = d.findElements(By.xpath("//ul[@class=' slideout-menu']//li"));
		System.out.println("Below are the Side Menu Names");
		for (int i = 0; i < l1.size(); i++) {

			System.out.println(l1.get(i).getText());
		}

		System.out.println();
		System.out.println("Below are the Social Media Links");
		List<WebElement> l2 = d.findElements(By.xpath("//ul[@class='lsi-social-icons icon-set-lsi_widget-1']//a"));
		for (int i = 0; i < l2.size(); i++) {
			System.out.println(l2.get(i).getAttribute("href"));
		}

		String mainWindow = d.getWindowHandle();
		System.out.println();
		System.out.println("Below are the Social Media Title Names");
		for (int i = 0; i < 3; i++) {
			W_Rightclick(l2.get(i));
			newWindowkeypress();
			switchWindow();
			System.out.println(d.getTitle());
			d.close();
			d.switchTo().window(mainWindow);

		}

	}

	@AfterMethod
	public void AfterTest() {
		terminate();
	}

}
