package com.bootcamp.pageobjects;

import com.bootcamp.framework.web.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

/**
 * @author Juan Krzemien
 */
public class PopUp extends PageObjectBase {

    @FindBy(id = "xSellHotelForcedChoice")
    private WebElement popUp;

    @FindBy(id = "forcedChoiceNoThanks")
    private WebElement noThanksLink;

    public PopUp(WebDriver driver) {
        super(driver);
    }

    public void dismiss() {
        getWait().until(elementToBeClickable(noThanksLink)).click();
    }

    public boolean isVisible() {
        return elementExists(popUp);
    }

}
