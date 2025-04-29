package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.time.Duration;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initDriver() throws IOException {
        PropertyExtractor propertyExtractor = new PropertyExtractor();

        if (propertyExtractor.extract("browser") == "chrome") {
            System.setProperty("webdriver.chrome.driver", propertyExtractor.extract("chromepath"));
            driver = new ChromeDriver();
        }
        if (propertyExtractor.extract("browser") == "edge") {
            System.setProperty("webdriver.edge.driver", propertyExtractor.extract("edgepath"));
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static void quitDriver(){
        driver.quit();
    }
}