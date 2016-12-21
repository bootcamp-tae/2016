package com.bootcamp.junit;
import com.bootcamp.pageobjects.CheapTickets;
import com.bootcamp.pageobjects.FlightResult;
import com.bootcamp.pageobjects.FlightSearch;
import org.junit.Test;

public class SuiteJUnit {
    @Test
    public void FlightSearch() {

        CheapTickets home   = new CheapTickets();
        FlightSearch form   = home.clickOnFlightTab();
        FlightResult result = form.doSearch("LAS", "LAX", 7, 7);
        result.selectFlight(4);

        /*
        ChromeDriverManager.getInstance().setup();
        ChromeDriver browser = new ChromeDriver();
        FirefoxDriverManager.getInstance().setup();
        FirefoxDriver browser = new FirefoxDriver();
        browser.get("http://www.cheaptickets.com");
        //WebElement goButton = browser.findElement(By.name("Btnk"));//preguntar
        WebElement textBox = browser.findElement(By.id(("lst-lb")));
        textBox.sendKeys("something" + Keys.ENTER);
        browser.quit();
        */

    }
}
