package Set3;

import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set3_Question2 extends TestBase {

	@BeforeMethod
	public void method1() {
		init("Chrome", "https://code.makery.ch/library/dart-drag-and-drop/");
	}

	@Test
	public void method2() throws InterruptedException {
		checkPageReady();

		scrollIntoView(d.findElement(By.xpath("//h3[@id='custom-drag-avatar']")));
		d.switchTo().frame(1);
		List<WebElement> images = d.findElements(By.xpath("//div[@class='container']/img"));
		WebElement trash = d.findElement(By.xpath("(//div[@class='trash'])[1]"));
		Actions actions = new Actions(d);
		System.out.println("Number of images: " + images.size());
		for (int i = 0; i < images.size(); i++) {
			int j = i + 1;
			takeScreenShotTip("Set3_Question2", "image" + j);
			actions.dragAndDrop(images.get(i), trash).build().perform();
			checkPageReady();
		}

	}

	@AfterMethod
	public void method3() {
		terminate();
	}

}
