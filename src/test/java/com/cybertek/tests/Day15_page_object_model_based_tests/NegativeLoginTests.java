package com.cybertek.tests.Day15_page_object_model_based_tests;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestBase {

    @Test
    public void wrongPasswordTest(){
        // how we use page object model to locate elements, send keys, etc...
        LoginPage loginPage = new LoginPage();
        loginPage.userName.sendKeys("salesmanager101");
        loginPage.password.sendKeys("greatpasswrod");
        loginPage.submit.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/user/login");

        // this is the way a test case in our frame work should look like. Here we do not try to find elements, we outsource everything , here we test the logic
    }

    @Test
    public void wrongUserNameTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.userName.sendKeys("saleslocaltor");
        loginPage.password.sendKeys("UserUser123");
        loginPage.submit.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/user/login");
    }
}
