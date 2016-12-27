package com.bootcamp.junit;
import com.bootcamp.pageobjects.CheapTickets;
import com.bootcamp.pageobjects.FlightResult;
import com.bootcamp.pageobjects.FlightSearch;
import org.junit.Test;

@RunWith(Parameterized.class)

public class SuiteJUnit {

    private WebDriver browser;

    public SuitJUnit (WebDriver browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "{index}:brws[{0}]")
    public static Collection<Object[]> data() {
        ChromeDriverManager.getInstance().setup();
        return Arrays.asList(new Object[][]{
                {new ChromeDriver()}
        });
    }

    @Before
    public void start () {
        browser.navigate().to("http://www.cheaptickets.com");
    }

    @After
    public void finish () {
        browser.quit();
    }

    @Test
    public void FlightSearch() {

        CheapTickets home   = new CheapTickets();
        FlightSearch form   = home.clickOnFlightTab();
        FlightResult result = form.doSearch("LAS", "LAX", 7, 7);
        result.selectFlight(4)
                .selectFlight(2);
        Thread.sleep(5000);

    }


}
