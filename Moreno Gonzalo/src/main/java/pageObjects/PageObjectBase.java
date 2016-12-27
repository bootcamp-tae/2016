package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Function;



import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

/**
 * Created by Colegio on 21/12/2016.
 */
public abstract class PageObjectBase {

    private static final int TIME_OUT_IN_SECONDS = 60;

    private WebDriver driver;
    private final WebDriverWait wait;

    public PageObjectBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        PageFactory.initElements(driver, this);
    }


    protected WebDriverWait getWait() {
        return wait;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected void click(WebElement element) {
        getWait().until(elementToBeClickable(element)).click();
    }

    protected void type(WebElement element, String text){
        getWait().until(elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }

    protected <K> FluentWait<K> waitOn(K object, int timeOutSeconds) {
        return new FluentWait<>(object)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withTimeout(timeOutSeconds, SECONDS)
                .pollingEvery(1, SECONDS);
    }

    protected boolean elementExists(WebElement element) {
        try {
            return waitOn(element, 3).until((Function<? super WebElement, Boolean>) WebElement::isDisplayed);
        } catch (TimeoutException toe) {
            return false;
        }
    }




}
