package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Colegio on 21/12/2016.
 */
public class CheapTicketsHomePage extends PageObjectBase{

    @FindBy(id = "tab-flight-tab")
    private WebElement flightTab;

    public CheapTicketsHomePage(WebDriver driver){
        super(driver);
        driver.navigate().to("http://cheaptickets.com");
    }

    public FlightSearchForm clickOnFlightTab() {
        click(flightTab);
        return  new FlightSearchForm(getDriver());

    }
}
