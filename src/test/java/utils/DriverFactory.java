package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.time.Duration;

public class DriverFactory {
    private WebDriver driver;
    private PropertyExtractor propertyExtractor;

    public WebDriver initDriver() throws IOException {
        propertyExtractor = new PropertyExtractor();
        String browser = propertyExtractor.extract("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", propertyExtractor.extract("chromepath"));
            driver = new ChromeDriver();
        }
        if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", propertyExtractor.extract("edgepath"));
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}