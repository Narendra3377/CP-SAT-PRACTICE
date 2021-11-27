package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.base.TestBase;

public class Set3_Question3_POM extends TestBase {

	public Set3_Question3_POM() {
		PageFactory.initElements(TestBase.d, this);
	}
	
	By icons=By.xpath("//div[@class='icons-container']//a/span");

	@FindBy(xpath = "//span[@class='cross-btn']")
	private WebElement close;

	
	@FindBy(xpath = "//a[contains(text(),'Contact Us')]")
	private WebElement contactUS;

	public void closepopup() {
		jsClick(close);
	}

	public void contactUsclick() {
		scrollIntoView(contactUS);
		contactUS.click();
	}
	
	public int getIconsCount() {
		return d.findElements(icons).size();
	}
	
	public String getIconName(int i) {
		List<WebElement> iconNames=d.findElements(icons);
		String[] parts=iconNames.get(i).getText().split("/");
		return parts[parts.length-1];
	}
}
