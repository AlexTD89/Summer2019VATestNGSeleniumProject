package com.cybertek.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected String url;
    protected Actions actions;
    protected WebDriverWait wait;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;


    @BeforeTest
    public void setUpTest(){
        //initialize variable
        report = new ExtentReports();
        //create report path, report will be in test output folder, name --> report.html
        String path = System.getProperty("user.dir") + "/test-output/report.html";
        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);
        // attach the html report to the report object
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
    @Parameters("env")
    public void setUP(@Optional String env){
        System.out.println("env = " + env);
        //ENV IS null use default url
        //if ENV is not null, get the url based on env
        if(env == null){
            url = ConfigurationReader.get("url");
        }else{
            url=ConfigurationReader.get(env+"_url");
        }
        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        url = ConfigurationReader.get("url");
        driver.get(url);
        actions = new Actions(driver);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
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
