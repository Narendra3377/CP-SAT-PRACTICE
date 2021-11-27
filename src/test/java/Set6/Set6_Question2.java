package Set6;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set6_Question2 extends TestBase {

	@Before
	public void initiateDriver() throws InterruptedException {
		init("Chrome", "https://www.wikipedia.org/");
	}

	@Test
	public void testCase1() throws Exception {
		checkPageReady();
		WebElement w1 = d.findElement(By.xpath("//div[@lang='en']//small/bdi"));
		String s = w1.getText().replaceAll("[^0-9]", "");
		System.out.println("Number of articles in English: " + s);
		d.findElement(By.xpath("//div[@lang='en']//strong")).click();
		d.findElement(By.xpath("//input[@placeholder='Search Wikipedia']")).clear();
		d.findElement(By.xpath("//input[@placeholder='Search Wikipedia']")).sendKeys("Anna University");
		d.findElement(By.xpath("//input[@id='searchButton']")).click();

		WebElement motto = d
				.findElement(By.xpath("(//table[@class='infobox vcard']/tbody/tr/td[@class='infobox-data'])[1]"));
		String mottoEnglish = motto.getText().trim();
		System.out.println(mottoEnglish);
		if (mottoEnglish.contains("Knowledge"))
			System.out.println("Knowledge word is present in the motto in english");
		else
			System.out.println("Knowledge word is not present in the motto in english");

		scrollIntoView(d.findElement(By.xpath("//span[@id='Notable_alumni']")));

		List<WebElement> notable_person = d
				.findElements(By.xpath("//span[@id='Notable_alumni']/../following-sibling::ul/li"));
		for (int i = 0; i < notable_person.size(); i++) {
			WebElement notable = notable_person.get(i);
			wait(1);
			String person = notable.getText();
			if (person.contains("Madan Babu")) {
				System.out.println("Madan Babu is present in the notable person list");
			}
		}

	}

	@After
	public void AfterTest() {
		terminate();
	}

}
