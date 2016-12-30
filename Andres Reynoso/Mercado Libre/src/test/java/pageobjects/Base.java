package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Colegio on 30/12/2016.
 */
public abstract class Base {


    private WebDriverWait getWait;

    private WebDriver driver;
    protected WebDriver getDriver(){
        return driver;
    }

    protected WebDriverWait getWait() {

        return new WebDriverWait(driver,10);

    }
    protected void clic (WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
    protected void clicList (List<WebElement> element, int i) {
        getWait().until(ExpectedConditions.visibilityOfAllElements(element));
        element.get(i).click();
    }
}
