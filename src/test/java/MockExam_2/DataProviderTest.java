package MockExam_2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class DataProviderTest extends TestBase {

	@Test(dataProvider = "data")
	public void testCase1(String a, String b, String c, String d) throws Exception {

	}

	@DataProvider(name = "data")
	public Object[][] passData() throws Exception {
		Object[][] data = readData(path, "MockExam");
		return data;
	}

}
