package MockExam_1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.testing.base.TestBase;

public class Question_2 extends TestBase {

	@BeforeMethod
	public void initiateDriver() throws InterruptedException {
//		init("Chrome", "https://mockexam1cpsat.agiletestingalliance.org/");

		String url = "https://mockexam1cpsat.agiletestingalliance.org/";
		d.get(url);
		d.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		System.out.println(url + " is Opened - ");
	}

	@Test
	public void test_1() throws Exception {

		String Exp_Name = readData(path, "Mock", 1, 1);
		String Exp_Designation = readData(path, "Mock", 1, 2);
		String Exp_Organization = readData(path, "Mock", 1, 3);
		checkPageReady();
		jsClick(d.findElement(By.xpath("//i[@class='eicon-close']")));
		gClick(By.xpath("//li[@class='slideout-toggle menu-item-align-right ']"));
		gScrollIntoView(By.linkText("List of Participants"));
		gClick(By.linkText("List of Participants"));
		gScrollIntoView(By.xpath("//input[@placeholder='Search']"));
		sendText(By.xpath("//input[@placeholder='Search']"), Exp_Name);
		wait(3);
		WebElement Name = d
				.findElement(By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr/td[2]"));
		WebElement Designation = d
				.findElement(By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr/td[3]"));
		WebElement Organization = d
				.findElement(By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr/td[4]"));
		String Act_Name = Name.getText();
		String Act_Designation = Designation.getText();
		String Act_Organization = Organization.getText();
		if (Exp_Name.equals(Act_Name) && Exp_Designation.equals(Act_Designation)
				&& Exp_Organization.equals(Act_Organization)) {
			setData(path, "Test1", 0, 0, "Matched");
			System.out.println("Test 1: Matched");
		} else {
			setData(path, "Test1", 0, 0, "Not Matched");
			System.out.println("Test 1: Not Matched");
		}
	}

	@Test
	public void test_2() throws Exception {

		String Exp_Name = readData(path, "Mock", 2, 1);
		String Exp_Designation = readData(path, "Mock", 2, 2);
		String Exp_Organization = readData(path, "Mock", 2, 3);
		checkPageReady();
		jsClick(d.findElement(By.xpath("//i[@class='eicon-close']")));
		gClick(By.xpath("//li[@class='slideout-toggle menu-item-align-right ']"));
		gClick(By.linkText("List of Participants"));
		sendText(By.xpath("//input[@placeholder='Search']"), Exp_Name);
		wait(3);
		WebElement Name = d
				.findElement(By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr/td[2]"));
		WebElement Designation = d
				.findElement(By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr/td[3]"));
		WebElement Organization = d
				.findElement(By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr/td[4]"));
		String Act_Name = Name.getText();
		String Act_Designation = Designation.getText();
		String Act_Organization = Organization.getText();
		if (Exp_Name.equals(Act_Name) && Exp_Designation.equals(Act_Designation)
				&& Exp_Organization.equals(Act_Organization)) {
			setData(path, "Test2", 0, 0, "Matched");
			System.out.println("Test 2: Matched");
		} else {
			setData(path, "Test2", 0, 0, "Not Matched");
			System.out.println("Test 2: Not Matched");
		}
	}

	@Test
	public void test_3() throws Exception {

		String Exp_Name = readData(path, "Mock", 3, 1);
		String Exp_Designation = readData(path, "Mock", 3, 2);
		String Exp_Organization = readData(path, "Mock", 3, 3);
		checkPageReady();
		jsClick(d.findElement(By.xpath("//i[@class='eicon-close']")));
		gClick(By.xpath("//li[@class='slideout-toggle menu-item-align-right ']"));
		gClick(By.linkText("List of Participants"));
		sendText(By.xpath("//input[@placeholder='Search']"), Exp_Name);
		wait(3);
		WebElement Name = d
				.findElement(By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr/td[2]"));
		WebElement Designation = d
				.findElement(By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr/td[3]"));
		WebElement Organization = d
				.findElement(By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr/td[4]"));
		String Act_Name = Name.getText();
		String Act_Designation = Designation.getText();
		String Act_Organization = Organization.getText();
		if (Exp_Name.equals(Act_Name) && Exp_Designation.equals(Act_Designation)
				&& Exp_Organization.equals(Act_Organization)) {
			setData(path, "Test3", 0, 0, "Matched");
			System.out.println("Test 3: Matched");
		} else {
			setData(path, "Test3", 0, 0, "Not Matched");
			System.out.println("Test 3: Not Matched");
		}
	}

	@Test
	public void test_4() throws Exception {

		String Exp_Name = readData(path, "Mock", 4, 1);
		String Exp_Designation = readData(path, "Mock", 4, 2);
		String Exp_Organization = readData(path, "Mock", 4, 3);
		checkPageReady();
		jsClick(d.findElement(By.xpath("//i[@class='eicon-close']")));
		gClick(By.xpath("//li[@class='slideout-toggle menu-item-align-right ']"));
		gClick(By.linkText("List of Participants"));
		sendText(By.xpath("//input[@placeholder='Search']"), Exp_Name);
		wait(3);
		WebElement Name = d
				.findElement(By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr/td[2]"));
		WebElement Designation = d
				.findElement(By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr/td[3]"));
		WebElement Organization = d
				.findElement(By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr/td[4]"));
		String Act_Name = Name.getText();
		String Act_Designation = Designation.getText();
		String Act_Organization = Organization.getText();
		if (Exp_Name.equals(Act_Name) && Exp_Designation.equals(Act_Designation)
				&& Exp_Organization.equals(Act_Organization)) {
			setData(path, "Test4", 0, 0, "Matched");
			System.out.println("Test 4: Matched");
		} else {
			setData(path, "Test4", 0, 0, "Not Matched");
			System.out.println("Test 4: Not Matched");
		}
	}

	@Test
	public void test_5() throws Exception {

		String Exp_Name = readData(path, "Mock", 5, 1);
		String Exp_Designation = readData(path, "Mock", 5, 2);
		String Exp_Organization = readData(path, "Mock", 5, 3);
		checkPageReady();
		jsClick(d.findElement(By.xpath("//i[@class='eicon-close']")));
		gClick(By.xpath("//li[@class='slideout-toggle menu-item-align-right ']"));
		gClick(By.linkText("List of Participants"));
		sendText(By.xpath("//input[@placeholder='Search']"), Exp_Name);
		wait(3);
		WebElement Name = d
				.findElement(By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr/td[2]"));
		WebElement Designation = d
				.findElement(By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr/td[3]"));
		WebElement Organization = d
				.findElement(By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr/td[4]"));
		String Act_Name = Name.getText();
		String Act_Designation = Designation.getText();
		String Act_Organization = Organization.getText();
		if (Exp_Name.equals(Act_Name) && Exp_Designation.equals(Act_Designation)
				&& Exp_Organization.equals(Act_Organization)) {
			setData(path, "Test5", 0, 0, "Matched");
			System.out.println("Test 5: Matched");
		} else {
			setData(path, "Test5", 0, 0, "Not Matched");
			System.out.println("Test 5: Not Matched");
		}

	}

	@AfterMethod
	public void AfterTest() {
		terminate();
	}

}
