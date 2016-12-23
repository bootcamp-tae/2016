package com.bootcamp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Gabriel on 12/21/2016.
 */
public class FlightResultForm extends PageObjectBase {

    @FindBy(css="button[data-test-id='select-button']")
    private List<WebElement> buttonList;

    public FlightResultForm(WebDriver driver){
        super(driver);
    }

    public void selectFlight(int i) {

        click(buttonList.get(i));

    }
}
