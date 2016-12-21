package com.bootcamp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class FlightResult {

    @FindBy(css = "button[data-test-id='select-button']")
    private List<WebElement> buttons;

    public void selectFlight(int p) {
        buttons.get(p).click();
    }
}
