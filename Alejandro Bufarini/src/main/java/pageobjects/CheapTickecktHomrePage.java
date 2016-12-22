package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Colegio on 21/12/2016.
 */
public class CheapTickecktHomrePage extends PageObjectBase {

    @FindBy(id = "tab-flight-tab")
    private WebElement btnFligths;

    public CheapTickecktHomrePage() {
        getDriver().navigate().to("https://www.cheaptickets.com");
    }

    public FligthSearchForm clickOnFligthTab() {
        click(btnFligths);
        return new FligthSearchForm(getDriver());
    }
}
