package bootcamp.pageobjects;

import framework.web.PageObjectBase;
import org.openqa.selenium.WebDriver;
/**
 * Created by Gabriel on 12/30/2016.
 */
public class MercadoLibreHome extends PageObjectBase{
    private static final String MERCADOLIBRE_URL = "http://www.mercadolibre.com.ar/";


    public MercadoLibreHome(WebDriver driver){
        super(driver);
        driver.navigate().to(MERCADOLIBRE_URL);
    }

    public QuerySearchForm beginQuerySearch(){
        return new QuerySearchForm(getDriver());
    }

}
