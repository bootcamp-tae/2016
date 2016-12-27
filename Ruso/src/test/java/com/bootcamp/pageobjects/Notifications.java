package com.bootcamp.pageobjects;

import com.bootcamp.framework.web.PageObjectBase;
import org.openqa.selenium.*;

import java.util.Collections;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;

/**
 * @author Juan Krzemien
 */
public class Notifications extends PageObjectBase {

    private final By notifications = By.cssSelector("div.notification");

    protected Notifications(WebDriver driver) {
        super(driver);
    }

    public boolean areDisplayed() {
        return getNotifications().size() > 0;
    }

    public void dismiss() {
        try {
            getNotifications().forEach(n -> n.findElements(By.tagName("button")).forEach(WebElement::click));
        } catch (StaleElementReferenceException sere) {
            // May have faded due to timeout...
        }
    }

    private List<WebElement> getNotifications() {
        try {
            return waitOn(getDriver(), 5).until(visibilityOfAllElementsLocatedBy(notifications));
        } catch (TimeoutException toe) {
            return Collections.emptyList();
        }
    }

}
