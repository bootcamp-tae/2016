package java.com.bootcamp.pageobjects;

/**
 * Created by Matias on 27/12/2016.
 */

public class PopUp {

    @FindBy(id = "xSellHotelForcedChoice")
    private WebElement popUp;

    @FindBy(id = "forcedChoiceNoThanks")
    private WebElement noThanksButton;

    public PopUp (WebDriver driver) { super(driver); }

    public boolean popUpYes () {
        return popUp.isDisplayed();
    }

    public void popUpNo () {
        Click(noThanksButton);
    }


}
