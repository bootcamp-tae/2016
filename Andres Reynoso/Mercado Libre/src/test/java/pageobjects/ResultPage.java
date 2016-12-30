package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Colegio on 30/12/2016.
 */
public class ResultPage extends Base {

    @FindBy(id="sortFilter")
    private WebElement filter;

    @FindBy(linkText = "Menor precio")
    private WebElement cheapest;

    @FindBy(css = "h2[class ='list-view-item-title']")
    private List<WebElement> itemsList;

    public ResultPage selectCheapest() {
        clic(filter);
        clic(cheapest);
        return selectProduct();
    }

    public ResultPage selectProduct(int i) {
        ResultPage.clicList(i);
        return productPage();
    }
}
