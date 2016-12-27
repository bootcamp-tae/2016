package pageObjects;

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
public class FlightResultsPage extends PageObjectBase{

    @FindBy(css = "button[data-test-id='select-button']" )
    private List<WebElement> results;

    private By notification = By.cssSelector("div.notification");

    private popUp flightPlusHotelPopUp;

    public FlightResultsPage(WebDriver driver) {
        super(driver);
    }


    public FlightResultsPage selectDepartureFlight(int index) {
        getWait().until(visibilityOfAllElements(results));
        WebElement selectButton = results.get(index);
        click(selectButton);
        getWait().until(stalenessOf(selectButton));
        return new FlightResultsPage(getDriver());
    }

    public PageObjectBase selectReturnFlight(int index) {
        getWait().until(visibilityOfAllElements(results));
        WebElement selectButton = results.get(index);
        getWait().until(not(presenceOfAllElementsLocatedBy(notification)));
        click(selectButton);
        getWait().until(stalenessOf(selectButton));
        return new FlightResultsPage(getDriver());
    }

/*    @Override
    protected void click(WebElement element) {
        if (flightPlusHotelPopUp.isVisible()) {
            flightPlusHotelPopUp.dismiss();
        }

        getWait().until(invisibilityOfElementLocated(notification));

        super.click(element);

        if (flightPlusHotelPopUp.isVisible()) {
            flightPlusHotelPopUp.dismiss();
        }
    }*/

}
