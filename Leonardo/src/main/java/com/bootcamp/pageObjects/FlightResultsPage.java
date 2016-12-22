package com.bootcamp.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by leonardoluisvicario on 21/12/16.
 */
public class FlightResultsPage extends PageObjectBase {

    @FindBy (css = "button[data-test-id='select-button']")
    private List<WebElement> botonesSelect;

    public void selectFlight(int i) {

        // obtengo el listado completo, selecciono el de x posicion y le hago click
        botonesSelect.get(i).click();
    }

    public FlightResultsPage (WebDriver driver) {
        super(driver);
    }
}
