package junit;

import org.apache.regexp.RE;
import pageobjects.Base;
import pageobjects.MercadoLibreHome;
import pageobjects.ResultPage;
import pageobjects.productPage;

/**
 * Created by Colegio on 30/12/2016.
 */
public class MLTestJUnit extends Base {
    public void BuyProduct(){
        MercadoLibreHome home = new MercadoLibreHome();
        ResultPage resultPage = home.doSearch("mama");
        resultPage.selectCheapest();
        resultPage.selectProduct(5);
        productPage = new productPage();

    }
}
