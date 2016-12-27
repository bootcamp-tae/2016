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
    private By notifications = By.cssSelector("div.notifications");
    //private By popUpNoThanks = By.id("id=forcedChoiceNoThanks");

    public FlightResultPage SelectFlightOrigin(int i) {
        getWait().until(ExpectedConditions.elementToBeClickable(botones.get(i)));
        wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(notifications)));
        Click(botones.get(i));
        wait.until(ExpectedConditions.stalenessOf(botones.get(i)));
        return new FlightResultPage(getDriver());
    }

    public void SelectFlightReturn(int i) {
        wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(notifications)));
        wait.until(ExpectedConditions.elementToBeClickable(botones.get(i)));
        Click(botones.get(i));

    }
}
