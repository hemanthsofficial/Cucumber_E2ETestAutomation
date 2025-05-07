package utils;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import java.io.IOException;

public class TestContext {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private LoginPage loginPage;
    private ExtentReportManager extentReportManager;

    public TestContext() {
        driverFactory = new DriverFactory();
    }

    public WebDriver initDriver() throws IOException {
        this.driver = driverFactory.initDriver();
        return driver;
    }

    public ExtentReportManager extentReportManager() {
        return extentReportManager = new ExtentReportManager(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        driverFactory.quitDriver();
    }

    public LoginPage getLoginPage() {
        return loginPage = new LoginPage(driver);
    }
}