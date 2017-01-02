package generalpackage.junit;

import framework.runner.junit.WebAutomationJUnitSuite;
import generalpackage.pageobjects.Mlhome;
import generalpackage.pageobjects.Mlresults;
import generalpackage.pageobjects.Mlselected;
import org.junit.Test;

public class SuiteJunit extends WebAutomationJUnitSuite<Mlhome> {
    @Test
    public void searchItem() throws InterruptedException {
        Mlhome home          = getStartingPage();
        Mlresults results    = home.execQuery("Reloop");
        Mlselected selected  = results.selectItem(2);
    }
}
