package com.bootcamp.pageobjects;

import com.bootcamp.framework.web.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class FlightResult extends PageObjectBase {

    @FindBy(css = "button[data-test-id='select-button']")
    private List<WebElement> buttons;
    private By notification = By.cssSelector("div.notification");
    private PopUp popup;

    public FlightResult(WebDriver driver) {
        super(driver);
        popup = new PopUp(getDriver());
    }

    public FlightResult selectDepartureFlight(int p) {
        selectFlight(p);
        return new FlightResult(getDriver());
    }
    
    public ReviewTrip selectReturnFlight(int p) {
        selectFlight(p);
        return new ReviewTrip(getDriver());
    }

    private void selectFlight(int p) {
        getWait().until(visibilityOfAllElements(buttons));
        click(buttons.get(p - 1));
    }

    @Override
    protected void click(WebElement element) {
        if (popup.isThere()) {
            popup.close();
        }

        getWait().until(invisibilityOfElementLocated(notification));

        super.click(element);

        if (popup.isThere()) {
            popup.close();
        }
    }

    public boolean isVisible() {
        return getWait().until(visibilityOfAllElements(buttons)).size() > 0;
    }
}
