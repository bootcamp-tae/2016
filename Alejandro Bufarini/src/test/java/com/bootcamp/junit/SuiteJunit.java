package com.bootcamp.junit;

import com.bootcamp.pageobjects.CheapTicketHomePage;
import com.bootcamp.pageobjects.FligthResultPage;
import com.bootcamp.pageobjects.FligthSearchForm;
import org.junit.Test;

/**
 * Created by Colegio on 19/12/2016.
 */
public class SuiteJunit {

    @Test
    public void FligthSearch() {
        CheapTicketHomePage cheapTickecthomePage = new CheapTicketHomePage();
        FligthSearchForm fligthSearchForm = cheapTickecthomePage.clickOnFligthTab();
        FligthResultPage fligthResultPage = fligthSearchForm.doSearch("LAS", "LAX", 7, 7);
        fligthResultPage.selectFligth(4).selectFligth(4);

    }
}
