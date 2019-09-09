package caspar_test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"feature"},
        glue = {"Cucumber"}
)

public class CucumberTest {

    // Initializing browser before class start
    @BeforeClass
    public static void launchBrowser()
    {
        BaseTest.browserLaunch();
    }
    // Closing browser after class
    @AfterClass
    public static void closeBrowser()
    {
        BaseTest.browserClose();
    }

}
