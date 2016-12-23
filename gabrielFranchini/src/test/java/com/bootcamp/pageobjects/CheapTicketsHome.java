package com.bootcamp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Created by Gabriel on 12/21/2016.
 */
public class CheapTicketsHome extends PageObjectBase {



    @FindBy(id="tab-flight-tab")
    private WebElement flightTab;
    public CheapTicketsHome(){
        driver.manage().window().maximize();
        driver.navigate().to("https://www.cheaptickets.com/");
    }
    //id es tab-flight-tab
    public FlightSearchForm clickOnFlightTab() {
        click(flightTab);//clickea en la tab de flight
        return new FlightSearchForm(driver);
    }
    public CheapTicketsHome(WebDriver driver){
        super(driver);
    }
}
