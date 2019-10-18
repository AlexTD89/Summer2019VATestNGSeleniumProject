package com.cybertek.tests.D1_basic_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {               // to make Thread.sleep() work
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();;
        WebDriver driver = new ChromeDriver();

        driver.get("http://cybertekschool.com/");

        System.out.println(driver.getTitle()); // returns a string title of the page and prints it in the console
                // prints title" Cybertek" that appears in the name of the tab

        // this is not from selenium, it is from java, it posses the program
        Thread.sleep(1000);

        driver.navigate().to("https://amazon.com/");
        System.out.println(driver.getTitle());
            //  Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more

        /*
            get() VS navigate().to()
                driver.get() -> waits for page to load
                navigate().to() --> does not wait for page to load
         */


        Thread.sleep(1000);
        driver.navigate().back(); // goes back at the previous website, page
        System.out.println(driver.getTitle());
            // Cybertek

        Thread.sleep(1000);
        driver.navigate().forward(); // goes forward to the previous website, page that was accessed but went back to the page before
        System.out.println(driver.getTitle());
        //   Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more


        Thread.sleep(1000);
        driver.navigate().refresh(); // reloads the page
        System.out.println(driver.getTitle());
        //   Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more
    }
}
