package com.bootcamp.junit.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

/**
 * Created by Bootcamp on 20/12/2016.
 */
public class GoogleResultsPage extends PageObjectBase {

    @FindBy(xpath = "//h3[@class='r']")
    private List<WebElement> results;

    public GoogleResultsPage(WebDriver browser) {
        super(browser);
    }

    public GoogleResultsPage clickOnResultNumber(int index) {
        getWait().until(visibilityOfAllElements(results));
        results.get(index).click();
        return this;
    }

}
