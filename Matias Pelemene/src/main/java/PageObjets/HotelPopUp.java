package PageObjets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Colegio on 23/12/2016.
 */
public class HotelPopUp extends PageObjectBase {

    @FindBy(id="forcedChoiceNoThanks")
    private WebElement btnNoThanks;

    public HotelPopUp(WebDriver driver) {
        super(driver);
    }

    public void ClickCerrar() {
        btnNoThanks.click();
    }
}
