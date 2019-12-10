package com.cybertek.tests.HomeWork;


import com.aventstack.extentreports.reporter.ExtentLoggerReporter;
import com.cybertek.tests.HomeWork.wikiPages.mainPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.IReporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.ITestResultNotifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
        1. Go to https://www.wikipedia.org/
        2. Enter redsox
        3. Wait until all the search suggestions load
        4. Verify that there are more that 1 search suggestions
        5. Verify that first search suggestion starts with text Boston Red Sox
        6. Create a summary that includes that show when the test started, ended and how long it took. It can be printed in console or some external report. You can use any tools.
 */
public class WikipediaTest extends TestBase {

    @BeforeMethod
    public void setUP(){
        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        url = ConfigurationReader.get("urlWiki");
        driver.get(url);
        actions = new Actions(driver);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void wikiTest(){
        extentLogger = report.createTest("Wikipedia search result test");

        extentLogger.info("navigate to www.wikipedia.org");
        mainPage mainPage = new mainPage();

        extentLogger.info("enter in search box: redsox");
        mainPage.searchBar.sendKeys("redsox");

        extentLogger.info("get all suggestions");
        List<String> allSuggestions = mainPage.getAllSuggestionsText();

        extentLogger.info("verify that it is more than 1 search result");
        Assert.assertTrue(allSuggestions.size()>1);

        extentLogger.info(("verify that first suggestion starts with: Boston Red Sox"));
        Assert.assertTrue(allSuggestions.get(0).startsWith("Boston Red Sox"));

        extentLogger.pass("Wikipedia search result test: PASS");

        List<ExtentLoggerReporter> summary = new ArrayList<>() ;
        System.out.println(extentLogger.getStatus());

    }
}
