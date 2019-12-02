package com.cybertek.tests.Day14_Framework_Design_properties_driver_class_test_base_class;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    /*
        This class extends TestBase, there you find before and after method
     */

    @Test
    public void login(){
        String url = ConfigurationReader.get("url");
        driver.get(url);
        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
    }
}
