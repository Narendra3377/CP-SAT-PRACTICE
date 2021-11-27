package MockExam_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.base.TestBase;

public class Question_3_POM extends TestBase {

	public Question_3_POM() {
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = "//i[@class='eicon-close']")
	public WebElement crossicon;

	@FindBy(xpath = "//li[@class='slideout-toggle menu-item-align-right ']")
	public WebElement menuicon;

	@FindBy(linkText = "List of Participants")
	public WebElement ListOfParticipants;

	@FindBy(xpath = "//input[@placeholder='Search']")
	public WebElement search;

	
	
	public void selectingcrossicon() {
		jsClick(crossicon);
	}

	public void selectingmenuicon() {
		menuicon.click();
	}

	public void scrollingandclicking() {
		scrollIntoView(ListOfParticipants);
		wait(2);
		ListOfParticipants.click();
	}

	public void scrollingtoSeaarch() {
		scrollIntoView(search);
		wait(2);
	}

	public By names = By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr/td[2]");
	public By designations = By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr/td[3]");
	public By organizations = By.xpath("//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr/td[4]");

}
