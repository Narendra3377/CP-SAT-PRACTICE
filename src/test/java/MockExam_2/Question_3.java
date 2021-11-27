package MockExam_2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.testing.base.TestBase;

public class Question_3 extends TestBase {

	@Before
	public void initiateDriver() throws InterruptedException {
		init("chrome", "https://mockexam2cpsat.agiletestingalliance.org/");

	}

	@Test
	public void testCase1() throws Exception {
		checkPageReady();
		Question_3_POM obj = new Question_3_POM();
		checkPageReady();
		obj.selectingcrossicon();
		obj.selectinabout();
		checkPageReady();
		obj.scrollingtoCandidates();
		obj.Seaarch198();
		obj.printingcitiesandcandidates();
		obj.Seaarch199();
		obj.printingcitiesandcandidates();
		obj.Seaarch200();
		obj.printingcitiesandcandidates();

	}

	@After
	public void AfterTest() {
		terminate();
	}

}
