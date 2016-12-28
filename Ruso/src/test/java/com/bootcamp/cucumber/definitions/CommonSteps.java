package com.bootcamp.cucumber.definitions;

import com.bootcamp.framework.runner.GenericWebAutomationTest;
import com.bootcamp.framework.web.Browser;
import com.bootcamp.pageobjects.CheapTicketsHome;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;

/**
 * @author Juan Krzemien
 */
public class CommonSteps extends GenericWebAutomationTest<CheapTicketsHome> {

    @After
    public void tearDown() {
        super.tearDown();
    }

    @Given("^I open my \"([^\"]*)\" browser$")
    public void iOpenMyBrowser(String browser) throws Throwable {
        setUp(Browser.valueOf(browser));
    }

}
