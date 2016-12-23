package com.bootcamp.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


/**
 * Created by Gabriel on 12/21/2016.
 */
public class FlightSearchForm extends PageObjectBase{

    @FindBy(id="flight-origin")
        private WebElement originBox;
    @FindBy(id="flight-destination")
        private WebElement destinationBox;
    @FindBy(id="flight-departing")
        private WebElement departingBox;
    @FindBy(id="flight-returning")
        private WebElement returningBox;
    @FindBy(id="search-button")
        private WebElement searchBtn;



    public FlightResultForm doSearch(String las, String lax, int c, int c1) {
        type(originBox, las);
        type(destinationBox, lax);
        type(departingBox, this.fecha(c).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        type(returningBox, this.fecha(c1).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        //formatea localdatetime a un string MM/dd/yyyy
        click(searchBtn);
        //llena cada campo con sus datos respectivos y clickea el boton Search

        return new FlightResultForm(driver);
    }
    public FlightSearchForm(WebDriver d){
        super(d);
    }


    private LocalDateTime fecha(int c){
        return LocalDateTime.now().plusDays(c);
    }

}
