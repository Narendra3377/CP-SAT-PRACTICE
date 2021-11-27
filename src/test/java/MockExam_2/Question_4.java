package MockExam_2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Question_4 extends TestBase {

	@BeforeMethod
	@Parameters("browser")
	public void initiateDriver(String browser) throws InterruptedException {
		init(browser, "https://mockexam2cpsat.agiletestingalliance.org/");

	}

	@Test
	public void testCase1() throws Exception {
		checkPageReady();
		jsClick(d.findElement(By.xpath("//i[@class='eicon-close']")));
		gClick(By.linkText("ABOUT"));

		List<WebElement> l1 = d.findElements(By.xpath("//div[@class='eael-adv-accordion']/div"));
		List<WebElement> l2 = d.findElements(By.xpath("//div[@class='eael-accordion-content clearfix']/p[2]"));
		scrollIntoView(l1.get(0));
		int i = 0;
		while (i < l1.size()) {
			String color1 = l1.get(i).getCssValue("color");
			System.out.println("Before clicking + icon: " + color1);
			l1.get(i).click();
			String color2 = l1.get(i).getCssValue("color");
			System.out.println("After clicking + icon: " + color2);
			System.out.println(l2.get(i).getText());
			wait(3);
			takeScreenShotTip("M2_Q4", "Image");
			i++;
		}

		gScrollIntoView(By.xpath("//h2[text()='CP-SAT Advisory Board']"));
		List<WebElement> l3 = d.findElements(By.xpath("//div[@class='elementor-image-box-content']//a"));
		for (int j = 0; j < l3.size(); j++)
			System.out.println(l3.get(j).getText());

		gScrollIntoView(By.xpath("//h2[text()='#ATAGTR2021 Twitter Feed']"));
		wait(2);
		List<WebElement> tweets = d.findElements(By.xpath("//div[@class='eael-twitter-feed-item-content']/p"));
		System.out.println("Below are the tweets");
		for (int l = 0; l < tweets.size(); l++) {
			waitForElementToVisible(tweets.get(l));
			System.out.println(tweets.get(l).getText());
			System.out.println();
		}

		gScrollIntoView(By.xpath("//div[@id='cp-sat-java']"));
		wait(2);

		Actions a1 = new Actions(d);

		List<WebElement> tooltip = d.findElements(By.xpath("//article[@id='post-434']/div[1]//img"));
		for (int n = 0; n < 3; n++) {
			a1.moveToElement(tooltip.get(n)).build().perform();
			wait(5);
			takeScreenShotTip("M2_Q4", "Tooltip");
			String s1 = d.findElement(By.xpath("//div[@class='tippy-content']")).getText();
			System.out.println(s1);
		}

	}

	@AfterMethod
	public void AfterTest() {
		terminate();
	}

}
