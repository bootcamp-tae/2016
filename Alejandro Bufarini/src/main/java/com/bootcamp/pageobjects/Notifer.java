package com.bootcamp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by Colegio on 27/12/2016.
 */
public class Notifer extends PageObjectBase {

    @FindBy(css = "[class='notification-text']")
    private List<WebElement> notificaciones;

    public Notifer(WebDriver driver) {
        super(driver);
    }

    protected int getCantidadNotificaciones(){
        return notificaciones.size();
    }

    protected void waitCloseNotifers() {
        getWait().until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[class='notification-text']"))));
    }

}
