package com.bootcamp.pageobjects;

import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Created by Colegio on 21/12/2016.
 */
public class FligthResultPage extends PageObjectBase {

    @FindBy(css = "button[data-test-id='select-button']")
    private List<WebElement> btnsSelectFligths;

    public FligthResultPage(WebDriver driver) {
        super(driver);
    }

    public FligthResultPage selectFligth(int i) {
        Notifer notifer= new Notifer(getDriver());
        Popup popup = new Popup(getDriver());
        if (notifer.getCantidadNotificaciones() != 1) {
            notifer.waitCloseNotifers();
        }
        getWait().until(visibilityOfAllElements(btnsSelectFligths));
        click(btnsSelectFligths.get(i - 1));

        if(getWait().until((Predicate<WebDriver>) ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("[class='modal-inner']")))){
            popup.ClickNoThanks();
        }
        return new FligthResultPage(getDriver());
    }
}
