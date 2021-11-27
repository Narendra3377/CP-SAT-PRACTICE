package BenefitsCal;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Login extends TestBase {

	public static By loginButton = By.xpath("(//div[@class='ux-btn-label-wrapper'])[1]");
	public static By emailbox = By.xpath("//input[@type='text']");
	public static By pwdbox = By.xpath("//input[@type='password']");
	public static By login = By.xpath("//button[@id='login']");
	public static By iAccept = By.xpath("(//button[@type='button'])[2]");
	public static By dashboardText = By.xpath("//h2[text()='Things to do']");

	@BeforeMethod
	@Parameters({ "browser", "url" })
	public void initiateDriver(String br, String url) throws InterruptedException {
		init(br, url);
	}

	@Test
	@Parameters({ "email", "pwd" })
	public void login(String email, String pwd) throws Exception {

		checkPageReady();
		d.findElement(loginButton).click();
		wait(5);
		d.findElement(emailbox).clear();
		d.findElement(emailbox).sendKeys(email + Keys.TAB + pwd);
		wait(3);
		scrollIntoView(d.findElement(login));
		wait(3);
		Actions a1 = new Actions(d);
		wait(3);
		a1.moveToElement(d.findElement(login));
		wait(3);
		d.findElement(login).click();
		wait(10);
		scrollIntoView(d.findElement(iAccept));
		wait(2);
		a1.moveToElement(d.findElement(iAccept));
		wait(2);
		d.findElement(iAccept).click();
		wait(15);
		String text = d.findElement(By.linkText("Documents")).getText();
//		scrollIntoView(d.findElement(dashboardText));
		if (text.equals("Documents")) {
			System.out.println("Login Successful");
		} else {
			System.out.println("Test Failed");
		}

	}

	@AfterMethod
	public void AfterTest() {

		d.quit();

	}

}
