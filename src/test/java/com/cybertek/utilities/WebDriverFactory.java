package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    /*
     write a static method that takes a string parameter based on the value of the parameter.
     the method must return chromedriver or firefoxdriver object

     name: getDriver

     see 3 types of solutions down below...
     */



    public static WebDriver getDriver(String browserType) {
        WebDriver driver = null;
        switch (browserType.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup(); // sets up the browser
                driver = new ChromeDriver();            // opens the browser
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                break;

        }
        return driver;
    }






/*
//  Solution 1

    public static WebDriver getDriver(String browserType){

        if(browserType.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
        }else if (browserType.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
        }

    return getDriver(browserType);
    }

 */

/*
//  Solution 2

    public static WebDriver getDriver(String browserType){

        if(browserType.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if (browserType.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else {
            return null;
        }
    }

 */



}
