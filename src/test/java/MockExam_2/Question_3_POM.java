package MockExam_2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.testing.base.TestBase;

public class Question_3_POM extends TestBase {

	public Question_3_POM() {
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = "//i[@class='eicon-close']")
	public WebElement crossicon;

	@FindBy(linkText = "ABOUT")
	public WebElement about;

	@FindBy(xpath = "//h2[text()='List of Candidates']")
	public WebElement Candidates;

	@FindBy(xpath = "//input[@placeholder='Search']")
	public WebElement search;

	@FindBys({@FindBy (xpath= "//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr/td[1]")})
	public List<WebElement> citynames;
	
	@FindBys({@FindBy (xpath= "//table[@data-ninja_table_instance='ninja_table_instance_0']//tbody/tr/td[3]")})
	public List<WebElement> participants;
	
	
	
	
	public void selectingcrossicon() {
		jsClick(crossicon);
	}

	public void selectinabout() {
		about.click();
	}

	public void scrollingtoCandidates() {
		scrollIntoView(Candidates);
		wait(2);
		
	}

	public void Seaarch198() {
		search.clear();
		search.sendKeys("198");
		wait(3);
	}
	
	public void Seaarch199() {
		search.clear();
		search.sendKeys("199");
		wait(3);
	}
	
	public void Seaarch200() {
		search.clear();
		search.sendKeys("200");
		wait(3);
	}
	
	public void printingcitiesandcandidates()
	{
		List<WebElement> city=citynames;
		List<WebElement> candidates=participants;
		
		for (int i=0;i<city.size();i++)
			System.out.println("Number of candidates in "+city.get(i).getText()+": "+candidates.get(i).getText());
	}
}
