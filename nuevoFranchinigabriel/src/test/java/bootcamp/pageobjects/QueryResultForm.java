package bootcamp.pageobjects;

import framework.web.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

/**
 * Created by Gabriel on 12/30/2016.
 */
public class QueryResultForm extends PageObjectBase{

    @FindBy(css="h2 > a")
    private List<WebElement>selectLinks;
    @FindBy(id = "BidButtonTop")
    private WebElement bidBtn;


    public QueryResultForm(WebDriver driver){
        super(driver);
    }

    public void selectResult(int index){
        getWait().until(visibilityOfAllElements(selectLinks));
        click(selectLinks.get(index - 1));
    }

    public void doBid(){
        click(bidBtn);
    }


}
