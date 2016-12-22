package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by Colegio on 21/12/2016.
 */
public class FligthResultPage extends PageObjectBase {

    @FindBy(css="button[class='btn-secondary btn-action t-select-btn']")
    private List<WebElement> btnsSelectFligths;

    public FligthResultPage(WebDriver driver){
        super(driver);
    }

    public void selectFligth(int i) {
        btnsSelectFligths.get(i).click();
    }
}
