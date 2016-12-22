package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

/**
 * Created by Colegio on 21/12/2016.
 */
public class FligthResultPage extends PageObjectBase {

    @FindBy(css="button[class='btn-secondary btn-action t-select-btn']")
    private List<WebElement> btnsSelectFligths;

    public FligthResultPage(WebDriver driver){
        super(driver);
    }

    public FligthResultPage selectFligth(int i) {
        getWait().until(visibilityOfAllElements(btnsSelectFligths));
        click(btnsSelectFligths.get(i-1));
        return new FligthResultPage(getDriver());
    }
}
