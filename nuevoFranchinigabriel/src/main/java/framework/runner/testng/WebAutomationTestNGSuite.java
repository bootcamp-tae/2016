package framework.runner.testng;

import framework.runner.GenericWebAutomationTest;
import framework.web.Browser;
import framework.web.PageObjectBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * Base test class for all TestNG based test suites.
 *
 * @author Juan Krzemien
 */
public class WebAutomationTestNGSuite<T extends PageObjectBase> extends GenericWebAutomationTest<T> {

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(Browser browser) {
        super.setUp(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        super.tearDown();
    }

}
