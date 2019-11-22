package com.cybertek.tests.Day10_Synchronization;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitTest {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();    //  written once, because we maximize the window once for all Test classes
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    //written once, but is being used by all of the findElement() methods in the Test classes

        // wait while the page is loading
//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);   // waits until page is loaded
    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        System.out.println(driver.findElement(By.id("finish")).getText());  // Hello World!

    }
}
