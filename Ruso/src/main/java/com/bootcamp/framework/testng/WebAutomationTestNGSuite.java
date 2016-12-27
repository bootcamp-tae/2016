package com.bootcamp.framework.testng;

import com.bootcamp.framework.runner.GenericWebAutomationTest;
import com.bootcamp.framework.web.Browser;
import com.bootcamp.framework.web.PageObjectBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

/**
 * @author Juan Krzemien
 */
public class WebAutomationTestNGSuite<T extends PageObjectBase> extends GenericWebAutomationTest<T> {

    public WebAutomationTestNGSuite(Browser browser) {
        super(browser);
    }

    @DataProvider(name = "browsers")
    public static Object[][] data() {
        return new Object[][]{
                {Browser.CHROME},
                {Browser.FIREFOX},
                {Browser.IE},
        };
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        super.setUp();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        super.tearDown();
    }

}
