package com.bootcamp.pageobjects;

import com.bootcamp.framework.web.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.not;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class FlightResult extends PageObjectBase {

    @FindBy(css = "button[data-test-id='select-button']")
    private List<WebElement> buttons;
    private PopUp popup;
    private By notification = By.cssSelector("div.notification");

    public FlightResult(WebDriver driver) {
        super(driver);
        popup = new PopUp(getDriver());
    }

    public FlightResult selectFlight(int p) {
        getWait().until(ExpectedConditions.visibilityOfAllElements(buttons));
        if (popup.isThere()) {
            popup.close();
        }
        getWait().until(not(presenceOfElementLocated(notification)));
        click(buttons.get(p-1));

        if (popup.isThere()) {
            popup.close();
        }
        return new FlightResult(getDriver());
    }
}
