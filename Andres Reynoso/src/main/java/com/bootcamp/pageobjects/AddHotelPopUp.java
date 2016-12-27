package com.bootcamp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Colegio on 27/12/2016.
 */
public class AddHotelPopUp extends PageObjectBase {
    public AddHotelPopUp (WebDriver driver) {super(driver); }

    @FindBy(id = "xsellAddHotelNow")
    protected WebElement addHotelNow;


    public boolean isPopUp() {
        return exist(addHotelNow);
    }

    @FindBy(id = "forcedChoiceNoThanks")
    private WebElement popUpCloseButton;

    public  FlightResultPage popUpClose(){

        clic(popUpCloseButton);
        return  new FlightResultPage(driver);

    }
}
