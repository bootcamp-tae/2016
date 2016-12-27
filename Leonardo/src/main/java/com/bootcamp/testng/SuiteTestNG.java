package com.bootcamp.testng;
import com.bootcamp.pageObjects.CheapTicketsHome;
import com.bootcamp.pageObjects.FlightResultsPage;
import com.bootcamp.pageObjects.FlightSearchForm;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

/**
 * Created by Colegio on 19/12/2016.
 */
public class SuiteTestNG {

    private final WebDriver driver;

    public SuiteTestNG(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver.navigate().to("http://www.cheaptickets.com");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void flightSearch() throws InterruptedException {
        CheapTicketsHome home = new CheapTicketsHome(driver);
        FlightSearchForm tab = home.clickOnFlightTab();
        FlightResultsPage results = tab.doSearch("LAS", "LAX", 9, 7);
        FlightResultsPage results2 = results.selectFlight(5);
        //results2.selectFlight(2);
        Thread.sleep(3000);
    }

    public static class TestFactory {

        @DataProvider(name = "drivers")
        public static Object[][] data() {
            ChromeDriverManager.getInstance().setup();
            return new Object[][]{
                    {new ChromeDriver()}
            };
        }

        @Factory(dataProvider = "drivers")
        public Object[] createTestInstances(WebDriver driver) {
            return new Object[]{new SuiteTestNG(driver)};
        }
    }

}
