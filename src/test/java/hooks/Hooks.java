package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utils.DriverFactory;

public class Hooks {
    @Before
    public void setup(WebDriver driver, ) {
        DriverFactory.initDriver();

    }

    @After
    public void teardown(WebDriver driver) {
        DriverFactory.quitDriver();
    }
}