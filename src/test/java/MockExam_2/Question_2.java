package MockExam_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Question_2 extends TestBase {

	@BeforeMethod
	@Parameters("browser")
	public void initiateDriver(String browser) throws InterruptedException {
		init(browser, "https://mockexam2cpsat.agiletestingalliance.org/");

	}

	@Test(dataProvider = "data")
	public void testCase1(String a, String b, String c, String e) throws Exception {

		int i, j;
		checkPageReady();
		String Exp_City = a;
		String Exp_Year = b;
		String Exp_candidates = c;
		System.out.println(Exp_City);
		System.out.println(Exp_Year);
		System.out.println(Exp_candidates);
		checkPageReady();
		if (Exp_Year.equals("1987")) {
			i = 1;
			j = 1;
		} else if (Exp_Year.equals("1991")) {
			i = 2;
			j = 1;
		} else if (Exp_Year.equals("2000")) {
			i = 3;
			j = 2;
		} else if (Exp_Year.equals("२०१०")) {
			i = 4;
			j = 1;
		} else {
			i = 5;
			j = 1;
		}
		jsClick(d.findElement(By.xpath("//i[@class='eicon-close']")));
		gClick(By.linkText("ABOUT"));
		gScrollIntoView(By.xpath("//h2[text()='List of Candidates']"));
		gScrollIntoView(By.xpath("//input[@placeholder='Search']"));
		sendText(By.xpath("//input[@placeholder='Search']"), Exp_Year);
		wait(3);
		WebElement City = d.findElement(
				By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr[" + j + "]/td[1]"));
		WebElement Year = d.findElement(
				By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr[" + j + "]/td[2]"));
		WebElement candidates = d.findElement(
				By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr[" + j + "]/td[3]"));
		String Act_City = City.getText();
		String Act_Year = Year.getText();
		String Act_candidates = candidates.getText();
		if (Exp_City.equals(Act_City) && Exp_Year.equals(Act_Year) && Exp_candidates.equals(Act_candidates)) {
			setData(path, "MockExam", i, 3, "Matched");
			System.out.println("Test" + i + ": Matched");
		} else {
			setData(path, "MockExam", i, 3, "Not Matched");
			System.out.println("Test" + i + ": Not Matched");
		}

	}

	@DataProvider(name = "data")
	public Object[][] passData() throws Exception {

		Object[][] data = readData(path, "MockExam");
		return data;

	}

	@AfterMethod
	public void AfterTest() {
		terminate();
	}

}
