package bootcamp.pageobjects;

import framework.web.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Gabriel on 12/30/2016.
 */
public class QuerySearchForm extends PageObjectBase{

    @FindBy(id="query")
    private WebElement queryBox;
    @FindBy(name="mlSearchBtn")
    private WebElement searchBtn;

    public QuerySearchForm(WebDriver driver) {
        super(driver);
    }

    public QueryResultForm doSearch(String query){
        type(queryBox, query);
        click(searchBtn);

        return new QueryResultForm(getDriver());
    }
}
