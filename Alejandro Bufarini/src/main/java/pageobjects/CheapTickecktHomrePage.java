package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Colegio on 21/12/2016.
 */
public class CheapTickecktHomrePage extends PageObjectBase {

    @FindBy(id = "tab-flight-tab")
    private WebElement btnFligths;

    public CheapTickecktHomrePage() {
        driver.navigate().to("https://www.cheaptickets.com");
    }

    public FligthSearchForm clickOnFligthTab() {

        btnFligths.click();

        return new FligthSearchForm(driver);
    }
}
