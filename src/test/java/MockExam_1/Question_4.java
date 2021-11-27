package MockExam_1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Question_4 extends TestBase {

	
	@BeforeMethod
	public void initiateDriver() throws InterruptedException {
//		init("Chrome", "https://mockexam1cpsat.agiletestingalliance.org/");
		String url="https://mockexam1cpsat.agiletestingalliance.org/";
		d.get(url);
		d.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		System.out.println(url + " is Opened - ");
	}

	@Test
	public void testCase1() throws Exception {
		Question_4_POM obj = new Question_4_POM();
		checkPageReady();
		jsClick(d.findElement(obj.crossicon));
		gClick(obj.menuicon);
		gScrollIntoView(obj.Ch1);
		gClick(obj.Ch1);
		jsClick(d.findElement(obj.crossicon));
		checkPageReady();
		String color1 = d.findElement(obj.color).getCssValue("color");
		System.out.println("Before clicking + icon: " + color1);
		gScrollIntoView(obj.tamil);
		gClick(obj.tamil);
		System.out.println(gettext(obj.paragraph1));
		takeScreenShotTip("Mock_Question_4", "tamil");
		String color2 = d.findElement(obj.color).getCssValue("color");
		System.out.println("After clicking + icon: " + color2);
		Assert.assertNotEquals(color1, color2);
		System.out.println();
		gClick(obj.hindi);
		System.out.println(gettext(obj.paragraph2));
		takeScreenShotTip("Mock_Question_4", "hindi");
		System.out.println();
		gClick(obj.kannada);
		System.out.println(gettext(obj.paragraph3));
		takeScreenShotTip("Mock_Question_4", "kannada");
		System.out.println();
		gClick(obj.gujarati);
		System.out.println(gettext(obj.paragraph4));
		takeScreenShotTip("Mock_Question_4", "gujarati");
		System.out.println();
		gClick(obj.french);
		System.out.println(gettext(obj.paragraph5));
		takeScreenShotTip("Mock_Question_4", "french");
		System.out.println();
		d.navigate().to("https://mockexam1cpsat.agiletestingalliance.org/index.php/challenge-2/");
		checkPageReady();
		List<WebElement> speakers = d.findElements(obj.speakernames);
		System.out.println("Below are the speaker names");
		for (int i = 0; i < speakers.size(); i++)
			System.out.println(speakers.get(i).getText());
		System.out.println();
		d.navigate().to("https://mockexam1cpsat.agiletestingalliance.org/index.php/challenge-4/");
		checkPageReady();
		wait(5);
		List<WebElement> tweets = d.findElements(obj.tweets);
		System.out.println("Below are the tweets");
		for (int i = 0; i < tweets.size(); i++) {
			waitForElementToVisible(tweets.get(i));
			System.out.println(tweets.get(i).getText());

		}
	}

	@AfterMethod
	public void AfterTest() {
		terminate();
	}

}
