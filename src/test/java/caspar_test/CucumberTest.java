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

    @BeforeClass
    public static void launchBrowser()
    {
        BaseTest.browserLaunch();
    }

    @AfterClass
    public static void closeBrowser()
    {
        BaseTest.browserClose();
    }

}
