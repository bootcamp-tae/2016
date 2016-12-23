package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Created by Colegio on 21/12/2016.
 */
public class FligthResultPage extends PageObjectBase {

    @FindBy(css = "button[data-test-id='select-button']")
    private List<WebElement> btnsSelectFligths;

    @FindBy(css = "[class='notification-text']")
    private List<WebElement> notificaciones;


    public FligthResultPage(WebDriver driver) {
        super(driver);
    }

    public FligthResultPage selectFligth(int i) {
        getWait().until(visibilityOfAllElements(btnsSelectFligths));
        click(btnsSelectFligths.get(i - 1));
        if (notificaciones.size() != 1) {
            getWait().until(visibilityOfAllElements(notificaciones));
            for (int a = 0; a < notificaciones.size(); a++) {
                notificaciones.get(a).findElement(By.cssSelector("[class='icon icon-close']"));
            }
            getWait().until(invisibilityOfAllElements(notificaciones));
        }
        return new FligthResultPage(getDriver());
    }
}
