package com.bootcamp.pageObjects;

import javafx.util.converter.LocalDateTimeStringConverter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Created by leonardoluisvicario on 21/12/16.
 */
public class FlightSearchForm extends PageObjectBase {

    // componente html donde se pone aeropuerto origen
    @FindBy (id="flight-origin")
    private WebElement origen;

    // componente html donde se pone aeropuerto destino
    @FindBy (id="flight-destination")
    private WebElement destino;

    // componente html donde se pone fecha salida
    @FindBy (id = "flight-departing")
    private WebElement fechaSalida;

    // componente html donde se pone fecha regreso
    @FindBy (id = "flight-returning")
    private WebElement fechaRegreso;

    @FindBy (id = "search-button")
    private  WebElement boton;

    public FlightResultsPage doSearch(String las, String lax, int i, int i1) {

        type(origen, las);
        type(destino, lax);
        type(fechaSalida, this.calculate(i).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        type(fechaRegreso, this.calculate(i,i1).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));

        wait.until(ExpectedConditions.elementToBeClickable(boton));

        clickIt(boton);

        return new FlightResultsPage(driver);
    }

    private LocalDateTime calculate (int f) {

        // fecha actual mas los dias que deseo esperar antes de salir
        return LocalDateTime.now().plusDays(f);

    }

    private LocalDateTime calculate (int f, int f2) {

        // fecha actual mas los dias dentro de los cuales salgo y permanezco alla
        return LocalDateTime.now().plusDays(f+f2);

    }

    public FlightSearchForm (WebDriver driver) {
        super(driver);
    }
}
