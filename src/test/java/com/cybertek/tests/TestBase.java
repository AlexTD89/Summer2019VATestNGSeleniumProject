package com.cybertek.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected String url;
    Actions actions;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;


    @BeforeTest
    public void setUpTest(){
        report = new ExtentReports();
        String path = System.getProperty("user.dir") + "/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(path);
        report.attachReporter(htmlReporter);

        // here we give name of our project
        htmlReporter.config().setReportName("Regression tests");

        //optional additional information
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
    }

    @AfterTest
    public void tearDownTest(){
        report.flush();
    }

    @BeforeMethod
    public void setUP(){
        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        url = ConfigurationReader.get("url");
        driver.get(url);
        actions = new Actions(driver);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(ITestResult result) throws InterruptedException, IOException {
        //IF FAILED TAKE SCREENSHOT
        if (result.getStatus() == ITestResult.FAILURE) {
            //record the name of the failed testcase
            extentLogger.fail(result.getName());
            // take screenshot and return location of the screenshot
            String screenshot = BrowserUtils.getScreenshot(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshot);
            //capture the exception
            extentLogger.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            //sometimes tests are skipped, this is how we log skipped tests
            extentLogger.skip("Test Skipped: " + result.getName());
        }

        //CLOSE BROWSER
        Thread.sleep(1000);
        Driver.closeDriver();
    }
}
