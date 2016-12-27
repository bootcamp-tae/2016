package com.bootcamp.framework.runner.junit;

import com.bootcamp.framework.runner.GenericWebAutomationTest;
import com.bootcamp.framework.web.Browser;
import com.bootcamp.framework.web.PageObjectBase;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * PageObjectBase test class for all JUnit based test suites.
 *
 * @author Juan Krzemien
 */

@RunWith(Parallelism.class)
public abstract class WebAutomationJUnitSuite<T extends PageObjectBase> extends GenericWebAutomationTest<T> {

    @Parameter
    public Browser currentBrowser;

    @Parameters(name = "Browser {0}")
    public static Set<Browser> getBrowsers() {
        return Arrays.stream(Browser.values()).collect(toSet());
    }

    @Before
    public void setUp() {
        super.setUp(currentBrowser);
    }

    @After
    public void tearDown() {
        super.tearDown();
    }

}
