package Set7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.testing.base.TestBase;

public class Set7_Question2 extends TestBase{
	
	By search=By.xpath("//input[@id='suggestion-search']");
	By result=By.xpath("(//div[@class='searchResults__ResultTextItem-sc-1pmqwbq-2 lolMki _26kHO_8bFBduUIYADnVHFY'])[1]");
	By time=By.xpath("//ul[@data-testid='hero-title-block__metadata']/li[3]");
	By MPAA=By.xpath("//ul[@data-testid='hero-title-block__metadata']/li[2]");
	By genre=By.xpath("(//div[@data-testid='genres']/a/span)[1]");
	By reviewsLink=By.xpath("//div[@data-testid='reviews-header']/a/h3");
	By username=By.xpath("(//div[@class='display-name-date']/span/a)[1]");
	
	

	@Before
	public void initiateDriver() throws InterruptedException {
		init("Chrome", "https://www.imdb.com/");
	}
	@Test
	public void testCase1() throws Exception{
		checkPageReady();
		sendText(search, "Gangs of New York");
		wait(2);
		gClick(result);
		String duration=gettext(time);
		System.out.println("Total run time: "+gettext(time));
		int hrs=Integer.parseInt(duration.split("h")[0]);
		int  min=Integer.parseInt(duration.split(" ")[1].replaceAll("[^0-9]", ""));
		int totalmins=(hrs*60)+min;
		System.out.println("Total run time in minutes: "+totalmins);
		if(totalmins<180)
		System.out.println("Run time is less than 180 minutes");
		else
			System.out.println("Run time is not less than 180 minutes");
		String MPAArating=gettext(MPAA);
		if (MPAArating.equals("R"))
			System.out.println("MPAA rating is as expected");
		else
			System.out.println("MPAA rating is not as expected");
		String gen=gettext(genre);
		if (gen.equals("Crime"))
			System.out.println("Genre is as expected");
		else
		System.out.println("Genre is not as expected");
		gClick(reviewsLink);
		checkPageReady();
		String name=gettext(username);
		System.out.println(name);
		
		
			
		
	}
	
	
		@After
	public void AfterTest() {
		terminate();
	}
}
