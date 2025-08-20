package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {

    @Before
    public void setUp() {
        System.out.println("Launching browser before scenario...");
        initializeDriver();   // ✅ Initialize driver first
        getDriver().get(getProp().getProperty("url"));  // ✅ Now it's safe
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed() && getDriver() != null) {
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        quitDriver();
    }
}
