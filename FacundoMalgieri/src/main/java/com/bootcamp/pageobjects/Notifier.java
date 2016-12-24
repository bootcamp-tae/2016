package com.bootcamp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
/**
 * Created by Facu on 24/12/2016.
 */
public class Notifier extends Base {
    @FindBy(css = "div[class='notification']")
    private List<WebElement> notifiers;

    @FindBy(css = "button[data-track='FLT.SR.Events.Close']")
    private WebElement x;

    public Notifier(WebDriver driver) {
        super(driver);
    }

    public void close(WebElement x) {
        click(x);
    }

    /**
     * I tried to make a generalization of the exists() method so now
     * it belongs to Base abstract class.
     * I'm trying to iterate through all the elements of notifiers list
     * checking if they exist or not.
     *
     * @return boolean
     */
    public boolean isThere() {
        if(exists(x)) {
            for (WebElement x : notifiers) {
                exists(x);
            }
            return true;
        } else { return false; }
    }

    public List<WebElement> getList() {
        return notifiers;
    }

    public WebElement getX() {
        return x;
    }
}
