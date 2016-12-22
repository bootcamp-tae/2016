package PageObjets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public FlightSearchForm ClickFligthTab() {
        flightTab.click();
        return new FlightSearchForm(driver);
    }
}
