package junit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pageobjects.Base;

/**
 * Created by Colegio on 30/12/2016.
 */
public class GenericTest extends Base{

    public class GenericTest(WebDriver driver) {super(driver);}

    private static String MERCADOLIBRE_URL = "http://www.mercadolibre.com.ar/";

    @Before
    public void setUp() {
        getDriver();
        driver.navigate().to(MERCADOLIBRE_URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
