package pageObjects;

import org.openqa.selenium.By;

public class Oct_2019_POM {

	// Question 1

	public By topStories = By.xpath("//div[@class='bud_otherstories1']//p/a");
	public By news = By.xpath("//a[@title='News']");
	public By trend = By.xpath("//div[@class='trndTxt']/div/a");

	// Question 2

	public By site = By.xpath("//select[@id='type']");
	public By search = By.xpath("//input[@placeholder='SEARCH']");
	public By alert = By.xpath("//a[@class='notnow']");
	public By videoresults = By.xpath("(//div[@class='srh_tab-ttl']/h2)[2]");
	public By total = By.xpath("//div[@class='src_crd-ttl']/a");
	public By firstvideo = By.xpath("(//div[@class='src_crd-ttl']/a)[1]");

	// Question 3

//	public By iframe=By.xpath("//iframe[@src='https://www.ndtv.com/business/marketdata/market-embedded3']");	
	public By iframe = By.xpath("(//iframe[contains(@src,'marketdata')])[1]");
	public By sensex = By.xpath("//div[@id='header-data']/a[2]//span[@class='num']");
//	public By sensex=By.xpath("(//div[@id='header-data']/a[@class='col sensex pager']//span[@class='num'])[1]");
	public By sensexchangepercentage = By.xpath("//div[@id='header-data']/a[2]//span[@class='green-btn fl']");
	public By niftychangepercentage = By.xpath("//div[@id='header-data']/a[3]//span[@class='green-btn fl']");
	public By nifty = By.xpath("//div[@id='header-data']/a[4]//span[@class='num']");
//	public By nifty=By.xpath("(//div[@id='header-data']/a[@class='col sensex pager']//span[@class='num'])[2]");

	// Question 4

	// top level
	public By top = By.xpath("//div[@class='nglobalnav_wrap']//a");

	public By T_news = By.xpath("//div[@class='nglobalnav_wrap']//a[text()='NDTV']");
	public By T_business = By.xpath("//div[@class='nglobalnav_wrap']//a[text()='BUSINESS']");
	public By T_hindi = By.xpath("//div[@class='nglobalnav_wrap']//a[text()='हिन्दी']");
	public By T_movies = By.xpath("//div[@class='nglobalnav_wrap']//a[text()='MOVIES']");
	public By T_cricket = By.xpath("//div[@class='nglobalnav_wrap']//a[text()='CRICKET']");
	public By T_food = By.xpath("//div[@class='nglobalnav_wrap']//a[text()='FOOD']");
	public By T_tech = By.xpath("//div[@class='nglobalnav_wrap']//a[text()='TECH']");
	public By T_auto = By.xpath("//div[@class='nglobalnav_wrap']//a[text()='AUTO']");
	public By T_art = By.xpath("//div[@class='nglobalnav_wrap']//a[text()='ART']");

	// bottom level

	public By Bottom = By.xpath("(//div[@class='footer_group']//a)");

}
