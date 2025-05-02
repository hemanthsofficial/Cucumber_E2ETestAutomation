package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.ExtentReportManager;

import java.io.IOException;

public class Hooks {
    @Before
    public void setup(WebDriver driver) throws IOException {
        DriverFactory.initDriver();

    }

    @After
    public void teardown(WebDriver driver) {
        DriverFactory.quitDriver();
        ExtentReportManager.flushReport();
    }
}