package com.bootcamp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Colegio on 21/12/2016.
 */
public class CheapTicketHomePage extends PageObjectBase {

    @FindBy(id = "tab-flight-tab")
    private WebElement btnFligths;

    public CheapTicketHomePage() {
        getDriver().navigate().to("https://www.cheaptickets.com");
    }

    public FligthSearchForm clickOnFligthTab() {
        click(btnFligths);
        return new FligthSearchForm(getDriver());
    }

}
