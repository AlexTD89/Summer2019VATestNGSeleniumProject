package com.cybertek.tests.Day17_html_Extent_Reporting;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReports extends TestBase {

    @Test
    public void wrongPasswordTest(){
        //if we don't add extentLogger = report.createTest, this test will not be in html report
        extentLogger =report.createTest("Wrong Password test");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Enter username");
        loginPage.userName.sendKeys("salesmanager101");
        extentLogger.info("Enter password");
        loginPage.password.sendKeys("greatpasswrod");
        extentLogger.info("Click submit");
        loginPage.submit.click();
        extentLogger.info("Verify page url");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/user/login");
        extentLogger.pass("PASS: Wrong password test"); // this line has to be after the Assertion, so it will not run if the Assertion shows fail
    }

    //this test will fail
    @Test
    public void wrongUsernameTest(){
        //if we don't add extentLogger = report.createTest, this test will not be in html report
        extentLogger =report.createTest("Wrong username test");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Enter username");
        loginPage.userName.sendKeys("salesmanager101");
        extentLogger.info("Enter password");
        loginPage.password.sendKeys("greatpasswrod");
        extentLogger.info("Click submit");
        loginPage.submit.click();
        extentLogger.info("Verify page url");
        Assert.assertEquals(driver.getCurrentUrl(), "https://google.com/");
        extentLogger.pass("PASS: Wrong username test"); // this line has to be after the Assertion, so it will not run if the Assertion shows fail
    }
}
