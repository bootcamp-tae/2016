package PageObjets;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by Colegio on 21/12/2016.
 */
public class FlightSearchForm extends PageObjectBase {

    @FindBy(id = "flight-origin")
    private WebElement inputFrom;

    @FindBy(id = "flight-destination")
    private WebElement inputTo;

    @FindBy(id="flight-departing")
    private WebElement fechaFrom;

    @FindBy(id = "flight-returning")
    private WebElement fechaTo;

    @FindBy(id = "search-button")
    private WebElement btnSearch;

    public FlightSearchForm(WebDriver driver) {
        super(driver);
    }

    public FlightResultPage DoSearch(String lax, String las, int fecha1, int fecha2) {
        Type(inputFrom,lax);
        Type(inputTo,las);
        Type(fechaFrom, this.CalculateFechas(fecha1).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        Type(fechaTo, this.CalculateFechas(fecha1,fecha2).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        Click(btnSearch);
        return new FlightResultPage(driver);
    }

    private LocalDateTime CalculateFechas(int days) {
        return LocalDateTime.now().plusDays(days);
    }

    private LocalDateTime CalculateFechas(int days, int days2) {
        return LocalDateTime.now().plusDays(days + days2 );
    }
}