package com.bootcamp.junit.web.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Bootcamp on 20/12/2016.
 */
public class GoogleHomePage extends PageObjectBase {

    @FindBy(id = "lst-ib")
    private WebElement searchBox;

    public GoogleHomePage(WebDriver browser) {
        super(browser);
    }

    public GoogleResultsPage doSearch(String criteria) {
        searchBox.sendKeys(criteria + Keys.ENTER);
        return new GoogleResultsPage(getBrowser());
    }
}
