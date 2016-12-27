package com.bootcamp.pageobjects;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightResult extends Base {

    @FindBy(css = "button[data-test-id='select-button']")
    private List<WebElement> buttons;

    @FindBy(id = "FlightUDPBookNowButton1")
    private WebElement continueBooking;

    public FlightResult(WebDriver driver) {
        super(driver);
    }

    public FlightResult selectFlight(int p) {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfAllElements(buttons));
        Click(buttons.get(p));

        return new FlightResult(driver);
    }
}
