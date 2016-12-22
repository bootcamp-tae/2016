package com.bootcamp.testng;

import com.bootcamp.pageobjects.GoogleHomePage;
import com.bootcamp.pageobjects.GoogleResultsPage;
import io.github.bonigarcia.wdm.Architecture;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

/**
 * Day 2 - General WebDriver usage
 * <p>
 * Overview of Page Objects
 * TestNG parameterized tests
 *
 * @author Juan Krzemien
 */

public class SuiteTestNG {

    private final WebDriver browser;

    public SuiteTestNG(WebDriver driver) {
        this.browser = driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        browser.manage().window().maximize();
        browser.navigate().to("http://www.google.com");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        browser.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        GoogleHomePage home = new GoogleHomePage(browser);
        GoogleResultsPage results = home.doSearch("Something");
        results.clickOnResultNumber(1);
    }

    public static class TestFactory {

        @DataProvider(name = "browsers")
        public static Object[][] data() {
            InternetExplorerDriverManager.getInstance().setup(Architecture.x32);
            ChromeDriverManager.getInstance().setup();
            return new Object[][]{
                    {new InternetExplorerDriver()},
                    {new ChromeDriver()}
            };
        }

        @Factory(dataProvider = "browsers")
        public Object[] createTestInstances(WebDriver driver) {
            return new Object[]{new SuiteTestNG(driver)};
        }
    }

}
