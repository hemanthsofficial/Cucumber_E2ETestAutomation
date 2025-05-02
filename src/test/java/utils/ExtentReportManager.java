package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ExtentReportManager {
    private WebDriver remoteDriver;
    ExtentReports extentReports;

    public ExtentReportManager(WebDriver driver) {
        this.remoteDriver = driver;
    }

    public ExtentReports getExtentReports() {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("test-output/reports/extent-reports" + AbstractComponents.timestamp() + ".html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }

    public void createTest(String testName) {
        ExtentTest extentTest = getExtentReports().createTest(testName);
    }

    public ExtentTest getTest() {

    }

    public void flushReport() {
        if (extentReports != null) {
            extentReports.flush();
            extentReports = null;
        }
    }

    public String captureScreenshot(String testName) throws IOException {
        File source = ((TakesScreenshot) remoteDriver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = System.getProperty("user.dir") + "test-output/screenshots/" + testName + AbstractComponents.timestamp() + ".png";
        File destination = new File(screenshotPath);
        Files.copy(source.toPath(), destination.toPath());
        return screenshotPath;
    }
}