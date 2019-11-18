package com.cybertek.tests.D02_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallTheFactory {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome"); // called a method from utilities folder, that opens a browser for us
        driver.get("http://www.google.com");

        WebDriver driver1 = WebDriverFactory.getDriver("firefox"); // called a method that opens a browser for us
        driver1.get("http://google.com");

    }
}
