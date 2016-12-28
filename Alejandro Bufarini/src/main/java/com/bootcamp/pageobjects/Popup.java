package com.bootcamp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Colegio on 27/12/2016.
 */
public class Popup extends PageObjectBase {
    @FindBy(css= "class='modal-inner'")
    private List<WebElement> popup;

    @FindBy(css= "class'no-thanks-content'")
    private WebElement btnNoThanks;

    public Popup (WebDriver driver){super(driver);}

    public void ClickNoThanks(){
        click(btnNoThanks);
    }

}
