package generalpackage.pageobjects;

import framework.web.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Mlhome extends PageObjectBase{

    private static final String MERCADOLIBRE_URL = "https://www.mercadolibre.com.ar/";

    @FindBy(id = "query")
    private WebElement searchBox;

    @FindBy(name = "mlSearchBtn")
    private WebElement searchBtn;

    public Mlhome(WebDriver driver) {
        super(driver);
        driver.navigate().to(MERCADOLIBRE_URL);
    }

    public Mlresults execQuery(String s) {
        type(searchBox, s);
        click(searchBtn);
        return new Mlresults(getDriver());
    }

    public boolean isVisible() {
        return getDriver().getCurrentUrl().equals(MERCADOLIBRE_URL) && exists(searchBox);
    }
}
