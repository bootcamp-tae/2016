package com.bootcamp.framework.junit;

import com.bootcamp.framework.runner.GenericWebAutomationTest;
import com.bootcamp.framework.web.Browser;
import com.bootcamp.framework.web.PageObjectBase;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

/**
 * @author Juan Krzemien
 */

@RunWith(Parameterized.class)
public abstract class WebAutomationJUnitSuite<T extends PageObjectBase> extends GenericWebAutomationTest<T> {

    public WebAutomationJUnitSuite(Browser browser) {
        super(browser);
    }

    @Parameters(name = "Browser {0}")
    public static Iterable<Object[]> browsers() {
        return Arrays.asList(new Browser[][]{
                {Browser.CHROME},
                {Browser.FIREFOX},
                {Browser.IE},
        });
    }

    @Before
    public void setUp() {
        super.setUp();
    }

    @After
    public void tearDown() {
        super.tearDown();
    }

}
