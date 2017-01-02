package generalpackage.pageobjects;

import framework.web.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

/**
 * Created by Facu on 30/12/2016.
 */
public class Mlresults extends PageObjectBase {
    @FindBy(css = "h2 > a")
    private List<WebElement> items;

    public Mlresults(WebDriver driver) {
        super(driver);
    }

    public Mlselected selectItem(int p) {
        getWait().until(visibilityOfAllElements(items));
        click(items.get(p - 1));
        return new Mlselected(getDriver());
    }
}
