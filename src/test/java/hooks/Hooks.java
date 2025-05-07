package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.TestContext;

import java.io.IOException;

public class Hooks {
    private TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setup() throws IOException {
        testContext.initDriver();
        testContext.extentReportManager().createTest("Login with multiple valid user credentials");
    }

    @After
    public void teardown() {
        testContext.extentReportManager().flushReport();
        testContext.quitDriver();
    }
}