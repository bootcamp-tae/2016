package com.bootcamp.junit;

import pageobjects.CheapTickecktHomrePage;
import pageobjects.FligthResultPage;
import pageobjects.FligthSearchForm;
import org.junit.Test;

/**
 * Created by Colegio on 19/12/2016.
 */
public class SuiteJunit {

    @Test
    public void FligthSearch() {
        CheapTickecktHomrePage cheapTickecthomePage = new CheapTickecktHomrePage();
        FligthSearchForm fligthSearchForm = cheapTickecthomePage.clickOnFligthTab();
        FligthResultPage fligthResultPage = fligthSearchForm.doSearch("LAS", "LAX", 7, 7);
        fligthResultPage.selectFligth(4);
    }
}
