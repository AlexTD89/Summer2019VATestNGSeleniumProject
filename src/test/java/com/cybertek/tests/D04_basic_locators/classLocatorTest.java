package com.cybertek.tests.D04_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class classLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        // locating the element by the class name
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        /*
                locate an element called 'Home'

            Home button element:
            <a class="nav-link" href="/">Home</a>

            tagName -> <a
            class name ->> class="nav-link"

         */

        WebElement home = driver.findElement(By.className("nav-link"));
        home.click();



        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //locate the title of the page "Multiple Buttons"
        WebElement title = driver.findElement(By.className("h3"));
        System.out.println("title = " + title.getText()); // title = Multiple buttons
        // text is encapsulated so we need to use the get method


        Thread.sleep(1000);
        driver.quit();

    }
}
