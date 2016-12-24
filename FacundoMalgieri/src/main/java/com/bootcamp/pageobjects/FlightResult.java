package com.bootcamp.pageobjects;

import com.google.common.base.Predicate;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightResult extends Base {

    @FindBy(css = "button[data-test-id='select-button']")
    private List<WebElement> buttons;
    private PopUp popup;
    private Notifier notifier;

    public FlightResult(WebDriver driver) {
        super(driver);
        popup = new PopUp(getDriver());
    }

    public FlightResult selectFlight(int p) {
        getWait().until(ExpectedConditions.visibilityOfAllElements(buttons));
        if (popup.isThere()) {
            popup.close();
        }
        /**
         * The idea is to iterate through the notifier's list
         * closing every notification spotted and saved there
         *
         * @return FlightResult
         */
        if (notifier.isThere()) {
            for (WebElement x : notifier.getList()) {
                notifier.close(x);
            }
        }
        click(buttons.get(p));
        return new FlightResult(getDriver());
    }
}
