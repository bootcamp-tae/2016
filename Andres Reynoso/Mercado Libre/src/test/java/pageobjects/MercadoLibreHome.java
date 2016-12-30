package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Colegio on 30/12/2016.
 */
public class MercadoLibreHome {



    @FindBy(id= "query")
    private WebElement textBox;

    public ResultPage doSearch (String itemToSearch) {
        textBox.sendKeys(itemToSearch);
        return new ResultPage();
    }

}
