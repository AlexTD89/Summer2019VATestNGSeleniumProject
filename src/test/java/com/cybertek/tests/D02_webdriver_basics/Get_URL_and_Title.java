package com.cybertek.tests.D02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Get_URL_and_Title {

    public static void main(String[] args) {

        //set up the chrome driver
        WebDriverManager.chromedriver().setup();

        // open chrome browser
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.jetbrains.com/idea/download/");

        //get the title of the page
        String title = driver.getTitle();
        System.out.println("title is: "+title); // title is Google

        //getCurrentUrl();  -->> gets url of this page
        String url = driver.getCurrentUrl();

        //use soutv  -->> will appear print with the recent variable
        System.out.println("url = " + url); // url = https://www.google.com/


        // getPageSource()  -->> get
        String pageSource = driver.getPageSource();
            //// use soutv
        System.out.println("pageSource = " + pageSource);




    }
}
