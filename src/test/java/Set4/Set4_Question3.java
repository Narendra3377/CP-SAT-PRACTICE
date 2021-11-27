package Set4;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set4_Question3 extends TestBase {

	@Before
	public void method1() {
		init("Chrome", "https://www.nytimes.com/");
	}

	@Test
	public void method2() throws Exception {
		checkPageReady();
		List<WebElement> language = d.findElements(By.xpath("//ul[@data-testid='masthead-edition-menu']//a"));
		for (int i = 0; i < language.size(); i++) {
			System.out.println("Available languages :" + language.get(i).getText());
		}

		List<WebElement> menuLinks = d.findElements(By.xpath("//a[@class='css-1wjnrbv']"));
		for (int j = 0; j < menuLinks.size(); j++) {
			if (menuLinks.get(j).getAttribute("href").contains("politics"))
				System.out.println(menuLinks.get(j).getAttribute("href"));
			break;

		}
		takeScreenShotTip("Set4_Question3", "NewYorkTimes");
		wait(5);

		String pageTitle = d.getTitle().trim();
		if (pageTitle.contains("The New York Times"))
			System.out.println("The page title is matched");
		else
			System.out.println("The page title does not match");

		d.findElement(By.xpath("//span[text()='SEARCH']//parent::button[@data-test-id='search-button']")).click();
		d.findElement(By.xpath("//input[@data-testid='search-input']")).clear();
		d.findElement(By.xpath("//input[@data-testid='search-input']")).sendKeys("arts", Keys.ENTER);
		checkPageReady();
		List<WebElement> searchRes = d
				.findElements(By.xpath("//ol[@data-testid='search-results']//li[@data-testid='search-bodega-result']"));
		System.out.println("The total search results :" + searchRes.size());
	}

	@After
	public void method3() {
		terminate();
	}

}
