package bootcamp.junit;

import bootcamp.pageobjects.MercadoLibreHome;
import bootcamp.pageobjects.QueryResultForm;
import bootcamp.pageobjects.QuerySearchForm;
import framework.runner.junit.WebAutomationJUnitSuite;
import org.junit.Test;

/**
 * Created by Colegio on 19/12/2016.
 */


public class SuiteJUnit extends WebAutomationJUnitSuite<MercadoLibreHome> {

    @Test
        public void buyNewStuff() {
            MercadoLibreHome home = getStartingPage();

            QuerySearchForm searchForm = home.beginQuerySearch();

            QueryResultForm result = searchForm.doSearch("AMD fx8350");

            result.selectResult(3);
            result.doBid();
        }

}
