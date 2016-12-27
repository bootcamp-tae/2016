package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

/**
 * Created by Colegio on 23/12/2016.
 */
public class popUp extends PageObjectBase {  //VER CLASE !!

    @FindBy(id= "xSellHotelForcedChoice")
    private WebElement popUp;

    @FindBy(id = "forcedChoiceNoThanks")
    private WebElement noThanksLink;


    public popUp(WebDriver driver){
        super(driver);
    }


   public void dismiss(){
        getWait().until(elementToBeClickable(noThanksLink)).click();
   }

   public boolean isVisible(){
       return elementExists(popUp);
   }

}
