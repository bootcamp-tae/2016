package pageObjects;

import net.sf.cglib.core.Local;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Colegio on 21/12/2016.
 */
public class FlightSearchForm extends PageObjectBase {

    @FindBy(id = "flight-origin")
    private WebElement inputOrigen;

    @FindBy(id = "flight-destination")
    private WebElement inputDestino;

    @FindBy(id= "flight-departing")
    private WebElement departing;

    @FindBy(id= "flight-returning")
    private WebElement returning;

    @FindBy(id="search-button")
    private  WebElement searchButton;

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public FlightSearchForm(WebDriver driver) {
        super(driver);
    }

    public FlightResultsPage doSearch(String origen, String destino, int i, int r) {
        type(inputOrigen, origen);
        type(inputDestino, destino);

        LocalDateTime departTime = calculateDate(i);
        LocalDateTime returnTime = calculateDate(i + r);

        type(departing, departTime.format(DATE_FORMAT));
        type(returning, returnTime.format(DATE_FORMAT));

        click(searchButton);


        return new FlightResultsPage(getDriver());
    }

    private LocalDateTime calculateDate(int days){

        return LocalDateTime.now().plusDays(days);
    }


}
