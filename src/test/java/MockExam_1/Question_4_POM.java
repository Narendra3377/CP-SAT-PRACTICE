package MockExam_1;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.testing.base.TestBase;

public class Question_4_POM extends TestBase {

	public Question_4_POM() {
		PageFactory.initElements(d, this);
	}

	public By crossicon = By.xpath("//i[@class='eicon-close']");
	public By menuicon = By.xpath("//li[@class='slideout-toggle menu-item-align-right ']");
	public By Ch1 = By.linkText("Challenge 1");
	public By color = By.xpath("//div[@id='para1-tamil']");
	public By tamil = By.xpath("//div[@id='para1-tamil']");
	public By hindi = By.xpath("//div[@id='para2-hindi']");
	public By kannada = By.xpath("//div[@id='para3-kannada']");
	public By gujarati = By.xpath("//div[@id='para-4-gujarati']");
	public By french = By.xpath("//div[@id='para-5-french']");
	public By paragraph1 = By.xpath("//div[@id='elementor-tab-content-2171']/p[2]");
	public By paragraph2 = By.xpath("//div[@id='elementor-tab-content-2172']/p[2]");
	public By paragraph3 = By.xpath("//div[@id='elementor-tab-content-2173']/p[2]");
	public By paragraph4 = By.xpath("//div[@id='elementor-tab-content-2174']/p[2]");
	public By paragraph5 = By.xpath("//div[@id='elementor-tab-content-2175']/p[2]");
	public By speakernames = By.xpath("//div[@class='elementor-section-wrap']//h6/a");
	public By tweets = By.xpath("//div[@class='eael-twitter-feed-item-content']/p");
}
