package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.testing.base.TestBase;

public class Set4_Question1_POM extends TestBase {

	public Set4_Question1_POM() {
		PageFactory.initElements(TestBase.d, this);
	}

	By icons = By.xpath("//div[@class='icons-container']//a/span");

	@FindBy(xpath = "//span[@class='cross-btn']")
	private WebElement close;

	@FindBy(linkText = "CII Services")
	private WebElement menuItem1;

	@FindBy(linkText = "Sectoral Portfolio")
	private WebElement menuItem2;

	@FindBy(linkText = "Food & Agricultural")
	private WebElement menuItem3;

	@FindBy(linkText = "Agriculture")
	private WebElement menuItem4;

	@FindBy(xpath = "//a[contains(text(),'Contact Us')]")
	private WebElement contactUS;

	public void closepopup() {
		jsClick(close);
	}
	
	
	@FindBys({@FindBy(xpath="//div[@class='icon']/a/img")})
	List<WebElement> iList;
	

	
	public void printSocialList()
	{
		for (int i=0; i<iList.size(); i++)
		{
			System.out.println("Tool Tip: " + iList.get(i).getAttribute("title").trim());
		}
	}
	
	
	public void clickAgri(Actions action) throws Exception
	{
		action.moveToElement(menuItem1).build().perform();
		Thread.sleep(1000);
		action.moveToElement(menuItem2).build().perform();
		Thread.sleep(1000);
		action.moveToElement(menuItem3).build().perform();
		Thread.sleep(1000);
		action.moveToElement(menuItem4).click().build().perform();
	}

}
