package BenefitsCal;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class CreateAccountandLogin extends TestBase {

	public static By SecurityQuestion1 = By.xpath("//select[@id='sec_qn_1']");
	public static By Answer1 = By.xpath("(//input[@class='ux-form-control ux-inline-input'])[1]");
	public static By SecurityQuestion2 = By.xpath("//select[@id='sec_qn_2']");
	public static By Answer2 = By.xpath("(//input[@class='ux-form-control ux-inline-input'])[2]");
	public static By SecurityQuestion3 = By.xpath("//select[@id='sec_qn_3']");
	public static By Answer3 = By.xpath("(//input[@class='ux-form-control ux-inline-input'])[3]");

	public static By CreateButton = By.xpath("(//div[@class='ux-btn-label-wrapper'])[3]");

	public static String randomestring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}

	static String email = randomestring() + "@mailinator.com";
	static String pwd = "Calsaws03!";

	@BeforeMethod
	@Parameters({ "browser", "url" })
	public void initiateDriver(String br, String url) throws InterruptedException {
		init(br, url);
	}

	@Test
	public void testCase1() throws Exception {

		checkPageReady();
		d.findElement(By.linkText("Create An Account")).click();
		checkPageReady();
		wait(3);
		d.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Sam");
		wait(2);
		d.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Doe");
		wait(2);
		d.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(email);
		wait(2);
		d.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(pwd);
		wait(2);
		d.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(pwd);
		wait(5);
		WebElement checkbox = d.findElement(By.xpath("(//input[@id='terms_conditions_agreement'])"));
		System.out.println(checkbox.isEnabled());
		scrollIntoView(checkbox);
		wait(3);
		Actions a1 = new Actions(d);
		a1.moveToElement(checkbox);
		wait(3);
		checkbox.click();

		WebElement nextButton = d.findElement(By.xpath("//button[@name='CreateCustomerAccount_continue']"));
		nextButton.click();
		wait(5);

		gListSelect(SecurityQuestion1, "What is your favorite color?");
		sendText(Answer1, "Answer");
		gListSelect(SecurityQuestion2, "What is your favorite movie?");
		sendText(Answer2, "Answer");
		gListSelect(SecurityQuestion3, "What is your favorite food?");
		sendText(Answer3, "Answer");
		wait(2);
		Robot robot = new Robot();
		robot.delay(1000);
		gScrollIntoView(CreateButton);
		a1.moveToElement(d.findElement(CreateButton));
		wait(3);
		d.findElement(CreateButton).click();
		wait(5);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		wait(2);
		String main = d.getWindowHandle();
		switchWindow();
		wait(5);

		d.navigate().to("https://www.mailinator.com/");
		wait(5);
		d.findElement(By.xpath("//input[@placeholder='Enter Public Mailinator Inbox']")).sendKeys(email + Keys.ENTER);
		checkPageReady();
		d.findElement(By.xpath("//table[@class='table-striped jambo_table']//tr[1]//td[3]")).click();
		d.switchTo().frame(d.findElement(By.xpath("//iframe[@id='html_msg_body']")));
		String code = d.findElement(By.xpath("//td[contains(text(),'Your BenefitsCal verification code is: ')]/b"))
				.getText();
		System.out.println("OTP: " + code);
		d.switchTo().window(main);
		d.findElement(By.xpath("//input[@id='customer_otp']")).sendKeys(code);
		wait(3);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		wait(5);
		System.out.println("Account Created successfully. Below are the details");
		System.out.println("Email: " + email);
		System.out.println("Password: " + pwd);

		wait(5);

	}

	@AfterMethod
	public void AfterTest() {

		d.quit();

	}
}