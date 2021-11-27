package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.base.TestBase;

public class HomePage {

	
	@FindBy(xpath="//span[@id='bseindex']")
	private WebElement bse;
	

	@FindBy(xpath="//span[@id='nseindex']")
	private WebElement nse;
	
	@FindBy(name="query")
	private WebElement inputBox;
	
	public HomePage()
	{
		PageFactory.initElements(TestBase.d, this);
	}
	
	public String bsevalue()
	{
		String s=bse.getText();
		return s;
	}
	
	public String nsevalue()
	{
		String s=nse.getText();
		return s;
	}
	
	public void Reliance()
	{
		inputBox.sendKeys("Reliance Industries"+Keys.ENTER);
	}

	public void Kotak()
	{
		inputBox.sendKeys("Kotak Mahindra Bank Ltd."+Keys.ENTER);
	}
}
