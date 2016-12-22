package pageobjects;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Colegio on 21/12/2016.
 */
public abstract class PageObjectBase {

    protected  WebDriver driver ;

    public PageObjectBase(){
        if(driver == null){
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
        }
        PageFactory.initElements(driver,  this);
    }

    public PageObjectBase(WebDriver webDriver) {
        driver = webDriver;
        PageFactory.initElements(driver,  this);
    }
}
