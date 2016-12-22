package PageObjets;

import com.google.common.base.Function;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Colegio on 21/12/2016.
 */
abstract class PageObjectBase {

    protected WebDriver driver;
    private WebDriverWait wait;
    private static final int TIME_OUT_IN_SECONDS = 30;


    public PageObjectBase(){
       if(driver == null) {
           ChromeDriverManager.getInstance().setup();
           driver = new ChromeDriver();
       }
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
   }

    public PageObjectBase(WebDriver brow){
        driver = brow;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
    }

    protected void Type(WebElement elemento, String texto) {
        wait.until(ExpectedConditions.visibilityOf(elemento));
        elemento.clear();
        elemento.sendKeys(texto);
    }

    protected void Click(WebElement elemento) {
        wait.until(ExpectedConditions.elementToBeClickable(elemento));
        elemento.click();
    }
    protected WebDriverWait getWait() {
        return wait;
    }
}
