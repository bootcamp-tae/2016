package PageObjets;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

/**
 * Created by Colegio on 21/12/2016.
 */
public class CheapTicketHome extends PageObjectBase {

    public CheapTicketHome(WebDriver driver) {
        super(driver);
    }

    public CheapTicketHome(){
        driver.navigate().to("http://www.cheaptickets.com");
    }
    @FindBy(id="tab-flight-tab")
    private WebElement flightTab;

    public FlightSearchForm ClickFlightTab() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(flightTab));
        flightTab.click();
        return new FlightSearchForm(driver);
    }
}
