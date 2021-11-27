package Set7;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;
import com.testing.base.XLUtils;

public class Set7_Question3 extends TestBase{
	
	
	
	@Before
	public void method1() {
		init("Chrome", "https://www.firstcry.com/");
	}

	@Test
	public void method2() throws Exception {
		checkPageReady();
		String path = "./testdata.xlsx";
		for (int i = 35; i < 37; i++) {

			String searchKey = XLUtils.getCellData(path, "Sheet1", i, 0);
			System.out.println(searchKey);
			d.findElement(By.id("search_box")).clear();
			d.findElement(By.id("search_box")).sendKeys(searchKey + Keys.ENTER);
			checkPageReady();
			Actions a1=new Actions(d);
			WebElement w1=d.findElement(By.xpath("//div[@class='sort-select-content L12_42']"));
			a1.moveToElement(w1).build().perform();
			d.findElement(By.linkText("Price")).click();
			d.findElement(By.linkText("Price")).click();
			wait(2);
			d.findElement(By.linkText("Price: High To Low")).click();
			d.findElement(By.linkText("Price: High To Low")).click();
			wait(5);

	
			List<WebElement> price = d.findElements(By.xpath("(//div[@class='rupee fw lft mbzero']//span[@class='r1 B14_42']/a)"));
			Double a[]=new Double[8];
			for (int j=0;j<8;j++)
			{
				String s=price.get(j).getText();
				a[j]=Double.parseDouble(s);
				System.out.println(a[j]);
				
			}
			
			
			isDescendingorder(a, searchKey);

		}}

	

	@After
	public void method3() {
		terminate();
	}

}
