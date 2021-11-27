package Set1B;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.testing.base.TestBase;

import pageObjects.HomePage;

public class Set1B_Question3 extends TestBase{

	@Before
	public void method1()
	{
		init("Chrome","https://www.rediff.com/");
	}
	
	
	@Test
	public void test() throws Exception
	{
		HomePage hm=new HomePage();
		checkPageReady();
		String mainWin=d.getWindowHandle();
		
		d.switchTo().frame(0);
		System.out.println(hm.bsevalue());
		System.out.println(hm.nsevalue());
		hm.Kotak();
		
		switchWindow();
		checkPageReady();
		
		String newWinTitle=d.getTitle();
		System.out.println("New Window Title: "+newWinTitle);
		Assert.assertEquals(newWinTitle.contains("KOTAK"),true);
		
		d.switchTo().window(mainWin);
		String mainWinTitle=d.getTitle();
		System.out.println("Old Window Title: "+mainWinTitle);
		Assert.assertEquals(mainWinTitle.contains("Rediff.com:"),true);
		
	}
	@After
	public void method3()
	{
		terminate();
	}
	
}
