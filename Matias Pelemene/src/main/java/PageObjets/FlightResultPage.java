package PageObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by Colegio on 21/12/2016.
 */
public class FlightResultPage extends PageObjectBase {

    public FlightResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="button[data-test-id='select-button']")
    private List<WebElement> botones;
   
    private HotelPopUp notificacionPopUp;

    public FlightResultPage SelectFlight(int i) {
        getWait().until(ExpectedConditions.elementToBeClickable(botones.get(i)));
        Click(botones.get(i));

        notificacionPopUp = new HotelPopUp(getDriver());

        return new FlightResultPage(getDriver());
    }
}
