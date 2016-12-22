package com.bootcamp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class FlightResult extends Base {

    @FindBy(css = "button[data-test-id='select-button']")
    private List<WebElement> buttons;

    public FlightResult(WebDriver driver) {
        super(driver);
    }

    public void selectFlight(int p) {
        buttons.get(p).click();
    }
}
