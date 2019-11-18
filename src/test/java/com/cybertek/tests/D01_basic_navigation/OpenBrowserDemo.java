package com.cybertek.tests.D01_basic_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowserDemo {
    public static void main(String[] args) {

        // we have to enter this line every time we want to open chrome, without it we get exception
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        //this part is selenium // WebDriver -->> represents the browser
        //new Chrome() --> this line opens chrome browser
        WebDriver driver = new ChromeDriver();
        // 99% people use the name "driver" for the name of the WebDriver

       driver.get("http://www.google.com");

        WebDriver driver1 = new FirefoxDriver();
        driver.get("http://www.facebook.com");
    }
}
