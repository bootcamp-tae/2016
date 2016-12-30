package com.bootcamp.pageobjects;

import com.bootcamp.framework.web.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



/**
 * Created by Gabriel on 12/21/2016.
 */
public class CheapTicketsHome extends PageObjectBase {

    private static final String CHEAPTICKETS_URL = "http://www.cheaptickets.com";

    @FindBy(id="tab-flight-tab")
    private WebElement flightTab;

    public CheapTicketsHome(WebDriver driver){
        super(driver);
        driver.navigate().to(CHEAPTICKETS_URL);
    }
    //id es tab-flight-tab
    public FlightSearchForm clickOnFlightTab() {
        click(flightTab);//clickea en la tab de flight
        return new FlightSearchForm(getDriver());
    }

}
