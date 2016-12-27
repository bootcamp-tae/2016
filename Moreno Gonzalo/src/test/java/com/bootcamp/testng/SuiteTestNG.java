package com.bootcamp.testng;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pageObjects.CheapTicketsHomePage;
import pageObjects.FlightResultsPage;
import pageObjects.FlightSearchForm;

/**
 * Created by Colegio on 19/12/2016.
 */

public class SuiteTestNG {

    private final WebDriver driver;

    public SuiteTestNG(WebDriver driver){this.driver = driver; }

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        driver.manage().window().maximize();
        driver.navigate().to("http://cheaptickets.com");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){driver.quit();}

    @Test
    public void test1() throws InterruptedException{
        CheapTicketsHomePage home = new CheapTicketsHomePage(driver);
        FlightSearchForm searchForm = home.clickOnFlightTab();
        FlightResultsPage results =   searchForm.doSearch("LAS", "LAX", 7, 7);

        results.selectDepartureFlight(4).selectReturnFlight(2);
    }

    public static class TestFactory{
        @DataProvider(name = "browsers")
        public static Object[][] data(){
            FirefoxDriverManager.getInstance().setup();
            ChromeDriverManager.getInstance().setup();
            return new Object[][]{
                    {new FirefoxDriver()},
                    {new ChromeDriver()}
            };
        }

        @Factory(dataProvider = "browsers")
        public Object[] createTestInstance(WebDriver driver){
            return new Object[]{ new SuiteTestNG(driver)};
        }
    }


}
