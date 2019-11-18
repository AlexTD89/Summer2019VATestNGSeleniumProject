package com.cybertek.tests.D02_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Close_and_Quit {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
    // TODO close one tab out of one
        driver.get("http://practice.cybertekschool.com");

        Thread.sleep(5000);
        // driver.close() -->> will close the window that was opened
        driver.close();


    // TODO close one tab out of two tabs
        WebDriver driver1 = new ChromeDriver(); // open new browser to access the new web-page, since the previous was closed
        driver1.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(2000);
        driver1.close();

// selenium closes one tab at the same time, so to open multiple times the browser you need to create new driver that will open the browser

        //TODO close all open tabs
        // close all windows and tabs, everything else
        driver.quit();



    }
}
