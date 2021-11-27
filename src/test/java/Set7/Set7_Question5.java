package Set7;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set7_Question5 extends TestBase{
	@BeforeMethod
	public void initiateDriver() throws InterruptedException {
		init("Chrome", "https://letterboxd.com/");
	}
	@Test
	public void testCase1() throws Exception{
		checkPageReady();
		
		
		
	}
	
	
		@AfterMethod
	public void AfterTest() {
		terminate();
	}

}
