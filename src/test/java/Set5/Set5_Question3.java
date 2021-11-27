package Set5;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;



public class Set5_Question3 extends TestBase{
	
	@Before
	public void method1()
	{
		init("firefox", "https://qaagility.com/");
	}
	
	@Test
	public void method2() throws Exception
	{
		checkPageReady();
		String title=d.getTitle();
		Assert.assertEquals(title.contains("QAAgility"), true);
		System.out.println("The Title of the page matches as expected");
		
		int width = d.findElement(By.xpath("(//img[@class='header-image'])[1]")).getSize().getWidth();
		int height = d.findElement(By.xpath("(//img[@class='header-image'])[1]")).getSize().getHeight();
		System.out.println("Img Height: " + height);
		System.out.println("Img Width: " + width);
		
		WebElement w1=d.findElement(By.xpath("//i[@class='fab fa-twitter']//parent::a"));
		String s=w1.getAttribute("href");
		System.out.println("twitter link: "+s);
		
		String text=d.getPageSource();
		Assert.assertEquals(text.contains("QAAgility Technologies © 2020. All Rights Reserved"),true);
		System.out.println("The footer text of the page matches as expected");
		
	}
	
	@After
	public void method3()
	{
		terminate();
	}
	

}
