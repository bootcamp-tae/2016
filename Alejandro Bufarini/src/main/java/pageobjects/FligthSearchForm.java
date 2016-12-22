package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Colegio on 21/12/2016.
 */
public class FligthSearchForm extends PageObjectBase {

    @FindBy(id = "flight-origin")
    private WebElement inputFlyingFrom;

    @FindBy(id = "flight-destination")
    private WebElement inputFlyingTo;

    @FindBy(id = "flight-departing")
    private WebElement inputFlightDeparting;

    @FindBy(id = "flight-returning")
    private WebElement inputFlightReturning;

    @FindBy(id = "flight-adults")
    private WebElement inputFlightAdults;

    @FindBy(id = "flight-children")
    private WebElement inputFlightChilden;

    @FindBy(id = "search-button")
    private WebElement btnSearch;

    public FligthSearchForm (WebDriver driver){
        super(driver);
    }


    public FligthResultPage doSearch(String las, String lax, int i, int i1) {
        inputFlyingFrom.sendKeys(las);
        inputFlyingTo.sendKeys(lax);
        inputFlightDeparting.sendKeys(CalculateDate(i).format(DateTimeFormatter.ofPattern("mm/dd/yyyy")));
        inputFlightReturning.sendKeys(CalculateDate(CalculateDate(i),i1).format(DateTimeFormatter.ofPattern("mm/dd/yyyy")));
        btnSearch.click();
        return new FligthResultPage(driver);
    }

    private LocalDateTime CalculateDate(int days) {
        return LocalDateTime.now().plusDays(days);
    }

    private LocalDateTime CalculateDate(LocalDateTime date, int days) {
        return date.plusDays(days);
    }
}
