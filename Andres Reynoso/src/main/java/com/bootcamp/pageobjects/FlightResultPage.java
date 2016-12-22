package com.bootcamp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


/**
 * Created by Colegio on 21/12/2016.
 */
public class FlightResultPage extends PageObjectBase {

    public FlightResultPage(WebDriver driver){
        super(driver);
    }
    @FindBy(css = "button[data-test-id='select-button']")
    private List<WebElement> buttons;

    public void selectFlight(int i) {
        buttons.get(i).click();
    }
}
