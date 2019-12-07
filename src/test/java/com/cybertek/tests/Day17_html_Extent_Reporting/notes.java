package com.cybertek.tests.Day17_html_Extent_Reporting;

/*

    HTML Reporting:

       A good  bug report must have :
                1. Bug Recreation, Recreation bug with expected and actual
                2. ScreenShot


       When we use testng/ junit with selenium, we can use reporting tools such as Allure and Extent reports.

       Extent reports: doesn't take screenshot automatically, so we need to do it in order to use extent reports

       TODAY: we added "Extent" latest dependency to our maven repository (pom file).

       Configure Extent
            1. ExtentReports report;    -->>    this class is used for starting and building the reports.
            2.ExtentHtmlReporter htmlReporter;  -->>    this class is used to create the HTML report file
            3. ExtentTest extentLogger; -->>    (used the most) this class will define a test, enables adding logs, authors etc..
                            extentLogger.info ->> we will have to wrote every time we build a new test, otherwise it will not describe the steps of the new test


        ITestResult —> this is a class from testng.
                 ITestResult contains information about the current @Test test case in testng.

        In selenium we take screenshot using TakesScreenshot class.


Interview question: which html report did you use
        explain all steps of how we use for example: Extent, all classes we use, where and how we use them.
            so for that I have to go over all these steps












 */




public class notes {

}
