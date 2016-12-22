package PageObjets;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by Colegio on 21/12/2016.
 */
public class FlightSearchForm extends PageObjectBase {

    @FindBy(id = "package-origin")
    private WebElement inputFrom;

    @FindBy(id = "package-destination")
    private WebElement inputTo;

    @FindBy(id = "package-departing")
    private WebElement fechaFrom;

    @FindBy(id = "package-returning")
    private WebElement fechaTo;

    @FindBy(id = "search-button")
    private WebElement btnSearch;

    public FlightSearchForm(WebDriver driver) {
        super(driver);
    }

    public FlightResultPage DoSearch(String lax, String las, int fecha1, int fecha2) {
        inputFrom.sendKeys(lax);
        inputTo.sendKeys(las);
        fechaFrom.sendKeys(this.CalculateFechas(fecha1).format(DateTimeFormatter.ofPattern("mm/dd/yyyy")));
        fechaTo.sendKeys(this.CalculateFechas(fecha1,fecha2).format(DateTimeFormatter.ofPattern("mm/dd/yyyy")));
        btnSearch.click();
        return new FlightResultPage(driver);
    }

    private LocalDateTime CalculateFechas(int days) {
        return LocalDateTime.now().plusDays(days);
    }

    private LocalDateTime CalculateFechas(int days, int days2) {
        return LocalDateTime.now().plusDays(days + days2 );
    }
}